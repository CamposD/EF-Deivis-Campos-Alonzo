package org.cibertec.edu.pe.repository;


import java.util.List;

import org.cibertec.edu.pe.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICiudadRepository extends JpaRepository<Ciudad, String>{

	@Query("SELECT c.nombre FROM Ciudad c")
    List<String> obtenerCiudades();
	
	@Query("SELECT c.nombre FROM Ciudad c")
    List<String> findAllCiudadNombres();

	Ciudad findByCodigoPostal(Ciudad ciudad);
}