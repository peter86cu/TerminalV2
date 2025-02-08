package com.shopping.configuracion.repositorio;



import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.configuracion.modelo.Menu;



public interface MenuJPA extends JpaRepository<Menu, Integer>{
}
