package ar.edu.unlam.tallerweb1.excepciones;

public class ErrorDeAccesoException extends RuntimeException {
    public ErrorDeAccesoException(String mensaje) {
        super(mensaje);
    }
}
