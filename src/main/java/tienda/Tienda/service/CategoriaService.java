package tienda.Tienda.service;

import java.util.List;
import tienda.Tienda.domain.Categoria;

public interface CategoriaService {
    public List<Categoria> getCategorias(boolean activos);
}
