package tienda.Tienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tienda.Tienda.domain.Categoria;

public interface CategoriaDao extends JpaRepository<Categoria, Long>{
    
}
