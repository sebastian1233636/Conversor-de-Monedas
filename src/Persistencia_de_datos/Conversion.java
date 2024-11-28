package Persistencia_de_datos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conversion {
    private String result;
    private String descripcion;
    private String fechaHora;

    public Conversion(String result, String descripcion) {
        this.result = result;
        this.descripcion = descripcion;
        this.fechaHora = obtenerFechaHoraActual();
    }

    private String obtenerFechaHoraActual() {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return fechaHoraActual.format(formatter);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaHora() {
        return fechaHora;
    }
}