package co.edu.unicordoba.decorator.reportes_sin_patron.model;



import java.util.Base64;

/**
 * DEFECTO DE DISEÑO (SIN PATRÓN DECORATOR):
 * Esta clase intenta aplicar formato, encabezado/pie de página y cifrado
 * mediante banderas booleanas (flags) dentro de un único método.
 * 
 * Problemas de diseño:
 * 1. Violación del Principio de Responsabilidad Única (SRP): La clase se encarga del contenido,
 *    formato, maquetación y cifrado al mismo tiempo.
 * 2. Violación del Principio Open/Closed (OCP): Para agregar un nuevo formato (ej. exportar a PDF/HTML),
 *    hay que modificar esta clase agregando más campos y más condicionales.
 * 3. Combinatoria rígida y poco escalable.
 */
public class ReporteMonolitico {

    private String contenido;
    private boolean conMayusculas;
    private boolean conEncabezadoPie;
    private boolean conCifrado;

    public ReporteMonolitico(String contenido, boolean conMayusculas, boolean conEncabezadoPie, boolean conCifrado) {
        this.contenido = contenido;
        this.conMayusculas = conMayusculas;
        this.conEncabezadoPie = conEncabezadoPie;
        this.conCifrado = conCifrado;
    }

    public String generarContenido() {
        String resultado = this.contenido;

        // DEFECTO: Evaluación rígida de condicionales en un orden fijo
        if (conMayusculas) {
            resultado = resultado.toUpperCase();
        }

        if (conEncabezadoPie) {
            String encabezado = "=== REPORTE INSTITUCIONAL UNICÓRDOBA ===\n";
            String pie = "\n=========================================";
            resultado = encabezado + resultado + pie;
        }

        if (conCifrado) {
            resultado = "[CIFRADO-BASE64] " + Base64.getEncoder().encodeToString(resultado.getBytes());
        }

        return resultado;
    }
}