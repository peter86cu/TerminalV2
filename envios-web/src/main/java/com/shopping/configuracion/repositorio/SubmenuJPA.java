package com.shopping.configuracion.repositorio;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shopping.configuracion.modelo.Submenu;





public interface SubmenuJPA extends JpaRepository<Submenu, Integer>{
	
	@Query(value="select * from submenu where idmenu=:id and estado='ACTIVO'", nativeQuery=true)
	List<Submenu> obtenerSubMenuPorID(@Param("id") int id);
}
