/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service.Impl;

import com.proyecto.dao.CategoriaDao;
import com.proyecto.domain.Categoria;
import com.proyecto.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jaffe
 */
@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    public List<Categoria> getCategorias(boolean activos) {
        var lista = categoriaDao.findAll();
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
        
        @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
}
