package ar.edu.unlam.tallerweb1.modelo;

public class CalculadoraError {
    protected String mensajeAmigable;
    protected String mensajeTecnico;
    protected static final String ERROR_AMIGABLE = "Hubo un error al realizar el cálculo. x.x";
    public CalculadoraError(){}

    public CalculadoraError(String mensajeTecnico) {
        setMensajeAmigable(ERROR_AMIGABLE);
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
