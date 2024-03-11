package org.cibertec.edu.pe.repository;

import org.cibertec.edu.pe.model.Ciudad;
import org.cibertec.edu.pe.model.DetalleVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IDetalleVentaRepository extends JpaRepository<DetalleVenta, Integer>{

}