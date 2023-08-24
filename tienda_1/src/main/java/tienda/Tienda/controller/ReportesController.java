package tienda.Tienda.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tienda.Tienda.service.ReportesService;

@Controller
@RequestMapping("/reportes")
public class ReportesController {

    @Autowired
    private ReportesService reporteService;

    @GetMapping("/principal")
    public String inicio(Model model) {
        return "/reportes/principal";

    }

    @GetMapping("/usuarios")
    public ResponseEntity<Resource> ReporteUsuarios(@RequestParam String tipo)
            throws IOException {
        var reporte = "usuarios";
        return reporteService.generarReporte(reporte, null, tipo);

    }

}
