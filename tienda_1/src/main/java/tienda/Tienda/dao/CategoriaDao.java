/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tienda.Tienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tienda.Tienda.domain.Categoria;

public interface CategoriaDao extends JpaRepository<Categoria, Long>{
    
}
