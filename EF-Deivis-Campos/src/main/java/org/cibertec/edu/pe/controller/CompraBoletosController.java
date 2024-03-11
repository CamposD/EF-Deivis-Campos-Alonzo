package org.cibertec.edu.pe.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.cibertec.edu.pe.model.Ciudad;
import org.cibertec.edu.pe.model.DetalleVenta;
import org.cibertec.edu.pe.model.Venta;
import org.cibertec.edu.pe.model.VentaBoleto;
import org.cibertec.edu.pe.repository.ICiudadRepository;
import org.cibertec.edu.pe.repository.IDetalleVentaRepository;
import org.cibertec.edu.pe.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("boletosAdd")
public class CompraBoletosController {

    @Autowired
    private ICiudadRepository ciudadRepository;

    @Autowired
    private IVentaRepository ventaRepository;

    @Autowired
    private IDetalleVentaRepository detalleVentaRepository;

    @GetMapping("/inicio")
    public String inicio(Model model) {
        List<Ciudad> ciudades = ciudadRepository.findAll();
        List<VentaBoleto> ventaBoletos = (List<VentaBoleto>) model.getAttribute("boletosAdd");

        if(ventaBoletos.size() > 0){
            VentaBoleto ventaBoletoEncontrado = ventaBoletos.get(ventaBoletos.size()-1);
            model.addAttribute("ventaBoleto", ventaBoletoEncontrado);
        } else {
            model.addAttribute("ventaBoleto", new VentaBoleto());
        }

        model.addAttribute("ciudades", ciudades);

        return "index";
    }

    @PostMapping("/agregar-venta-boleto")
    public String agregarVentaBoleto(@ModelAttribute VentaBoleto ventaBoleto, Model model) {
        List<Ciudad> ciudades = ciudadRepository.findAll();
        Double precioBoleto = 50.00;

        ventaBoleto.setSubTotal(ventaBoleto.getCantidad() * precioBoleto);

        List<VentaBoleto> ventaBoletos = (List<VentaBoleto>) model.getAttribute("boletosAdd");
        ventaBoletos.add(ventaBoleto);

        model.addAttribute("boletosAdd", ventaBoletos);
        model.addAttribute("ciudades", ciudades);
        model.addAttribute("mensaje", "Boleto agregado correctamente.");
        model.addAttribute("ventaBoleto", new VentaBoleto());

        return "redirect:/inicio";
    }

    @PostMapping("/comprar")
    public String comprar(Model model) throws ParseException {
        List<VentaBoleto> ventaBoletos = (List<VentaBoleto>) model.getAttribute("boletosAdd");
        Double montoTotal = 0.0;

        for (VentaBoleto ventaBoleto : ventaBoletos) {
            montoTotal += ventaBoleto.getSubTotal();
        }

        Venta nuevaVenta = new Venta();
        nuevaVenta.setFechaVenta(new Date());
        nuevaVenta.setMontoTotal(montoTotal);
        nuevaVenta.setNombreComprador(ventaBoletos.get(0).getNombreComprador());

        Venta ventaGuardada = ventaRepository.save(nuevaVenta);

        for (VentaBoleto ventaBoleto : ventaBoletos) {
            DetalleVenta detalleVenta = new DetalleVenta();
            detalleVenta.setVenta(ventaGuardada);
            detalleVenta.setFechaViaje(ventaBoleto.getFechaViaje());
            detalleVenta.setFechaRetorno(ventaBoleto.getFechaRetorno());
            detalleVenta.setCantidad(ventaBoleto.getCantidad());
            detalleVenta.setSubTotal(ventaBoleto.getSubTotal());
            detalleVenta.setCiudadOrigen(ventaBoleto.getCiudadOrigen());
            detalleVenta.setCiudadDestino(ventaBoleto.getCiudadDestino());
            detalleVentaRepository.save(detalleVenta);
        }

        ventaBoletos.clear();

        return "redirect:/inicio";
    }

    @GetMapping("/limpiar")
    public String limpiar(Model model) {
        List<Ciudad> ciudades = ciudadRepository.findAll();

        model.addAttribute("ventaBoleto", new VentaBoleto());
        model.addAttribute("ciudades", ciudades);

        return "index";
    }

    @ModelAttribute("boletosAdd")
    public List<VentaBoleto> boletosBuy() {
        return new ArrayList<>();
    }
}
