package co.edu.unicordoba.decorator.reportes_sin_patron.controller;



import co.edu.unicordoba.decorator.reportes_sin_patron.model.ReporteMonolitico;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador REST para exponer la versión defectuosa (SIN DECORATOR) en Render.
 */
@RestController
@RequestMapping("/api/sin-decorator")
public class SinDecoratorController {

    @GetMapping("/demo")
    public List<String> ejecutarDemostracion() {
        List<String> resultados = new ArrayList<>();

        resultados.add("=== DEMOSTRACIÓN DEL SISTEMA SIN PATRÓN DECORATOR (VERSIÓN CON DEFECTO) ===");

        // 1. Reporte simple (todos los flags en false)
        ReporteMonolitico reporteSimple = new ReporteMonolitico(
                "Informe de rendimiento académico - Semestre IV", false, false, false);
        resultados.add("1. Reporte Base: " + reporteSimple.generarContenido());

        // 2. Reporte con Mayúsculas y Encabezado (se pasan booleanos manualmente)
        ReporteMonolitico reporteFormal = new ReporteMonolitico(
                "Informe de rendimiento académico - Semestre IV", true, true, false);
        resultados.add("\n2. Reporte con Encabezado y Mayúsculas:\n" + reporteFormal.generarContenido());

        // 3. Reporte completo (todos los flags en true)
        ReporteMonolitico reporteSeguro = new ReporteMonolitico(
                "Informe de rendimiento académico - Semestre IV", true, true, true);
        resultados.add("\n3. Reporte Completo (con Cifrado):\n" + reporteSeguro.generarContenido());

        return resultados;
    }
}

