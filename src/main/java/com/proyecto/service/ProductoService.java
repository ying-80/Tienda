package com.proyecto.service;

import com.proyecto.domain.Productos;
import java.util.List;


public interface ProductoService {
    
    public List<Productos> getProductos(boolean activos);
    
    public Productos getProducto(Productos producto);
    
    public void save(Productos producto);
    
    public void delete(Productos producto);
}
