package com.proyecto.Controller;

import com.proyecto.domain.Productos;
import com.proyecto.service.FirebaseStorageService;
import com.proyecto.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller
@Slf4j
@RequestMapping("/producto")  //esto es la carpeta donde estan los archivos listados
public class ProductosController {
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {

        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        model.addAttribute("totalproductos", productos.size());

        return "/productos/listado";
    }
    
    @GetMapping("/nuevo")
    public String productoNuevo(Productos productos) {
        return "/productos/modifica";
    }
    
     @Autowired
    private FirebaseStorageService firebaseStorageService;
    
    @PostMapping("/guardar")
    public String productoGuardar(Productos productos,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            productoService.save(productos);
            productos.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "productos",
                            productos.getIdProducto()));
        }
        productoService.save(productos);
        return "redirect:/productos/listado";
    }
    
    @GetMapping("/eliminar/{idProducto}")
    public String productoEliminar(Productos productos) {
        productoService.delete(productos);
        return "redirect:/productos/listado";
    }
    
    @GetMapping("/modificar/{idProducto}")
    public String productoModificar(Productos productos, Model model) {
        productos = productoService.getProducto(productos);
        model.addAttribute("producto", productos);
        return "/productos/modifica";
    }
    
    
}
