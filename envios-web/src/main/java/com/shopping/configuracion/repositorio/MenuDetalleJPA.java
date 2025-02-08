package com.shopping.configuracion.repositorio;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shopping.configuracion.modelo.Menudetalle;
import com.shopping.configuracion.modelo.Submenu;





public interface MenuDetalleJPA extends JpaRepository<Menudetalle, Integer>{
	
	@Query(value="select * from menudetalle where idsubmenu=:id and estado='ACTIVO'", nativeQuery=true)
	List<Menudetalle> obtenerDetalleSubMenuPorID(@Param("id") int id);
}
