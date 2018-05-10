package ar.edu.unlam.tallerweb1.modelo;

public class CalculadoraError {
    protected String mensajeAmigable;
    protected String mensajeTecnico;

    public CalculadoraError(){}

    public CalculadoraError(String mensajeAmigable, String mensajeTecnico) {
        setMensajeAmigable(mensajeAmigable);
        setMensajeTecnico(mensajeTecnico);
    }

    public String getMensajeAmigable() {
        return mensajeAmigable;
    }

    public void setMensajeAmigable(String mensajeAmigable) {
        this.mensajeAmigable = mensajeAmigable;
    }

    public String getMensajeTecnico() {
        return mensajeTecnico;
    }

    public void setMensajeTecnico(String mensajeTecnico) {
        this.mensajeTecnico = mensajeTecnico;
    }
}
