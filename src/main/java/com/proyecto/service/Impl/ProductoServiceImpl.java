package com.proyecto.service.Impl;



import com.proyecto.dao.ProductoDao;
import com.proyecto.domain.Productos;
import com.proyecto.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Productos> getProductos(boolean activos) {

        var lista = productoDao.findAll();

        if (activos) {
            lista.removeIf(e -> !e.isActivo());

        }

        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Productos getProducto(Productos producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Productos producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Productos producto) {
        productoDao.delete(producto);
    }

}
