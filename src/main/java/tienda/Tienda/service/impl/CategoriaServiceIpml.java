package tienda.Tienda.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tienda.Tienda.dao.CategoriaDao;
import tienda.Tienda.domain.Categoria;
import tienda.Tienda.service.CategoriaService;

@Service
public class CategoriaServiceIpml implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    public List<Categoria> getCategorias(boolean activos) {
        var lista = categoriaDao.findAll();

        if (activos) {
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
