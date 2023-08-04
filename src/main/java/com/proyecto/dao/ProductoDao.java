package com.proyecto.dao;

import com.proyecto.domain.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository<Productos, Long>{
    
}
