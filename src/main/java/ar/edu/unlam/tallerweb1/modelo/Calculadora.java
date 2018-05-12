package ar.edu.unlam.tallerweb1.modelo;

import ar.edu.unlam.tallerweb1.excepciones.ErrorDeAccesoException;

public class Calculadora {
    protected String operacion;
    protected Integer operandoUno;
    protected Integer operandoDos;
    protected double resultado;
    protected Exception error;

    public Calculadora() {
    }


    public Calculadora(String operacion, Integer operandoUno, Integer operandoDos) {
        setOperacion(operacion);
        setOperandoUno(operandoUno);
        setOperandoDos(operandoDos);
        this.obtenerResultado();
    }

    public void obtenerResultado() {
        this.setResultado(this.calcular());
    }

    protected double calcular() {
        switch (getOperacion().toLowerCase()) {
            case "suma":
                Integer suma = getOperandoUno() + getOperandoDos();
                return suma.doubleValue();
            case "resta":
                Integer resta = getOperandoUno() - getOperandoDos();
                return resta.doubleValue();
            case "multiplicacion":
                Integer multiplicacion = getOperandoUno() * getOperandoDos();
                return multiplicacion.doubleValue();
            case "division":
                return (double)(getOperandoUno() / getOperandoDos());
        }
        throw new ErrorDeAccesoException("No se admite la operación dada");
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Integer getOperandoUno() {
        return operandoUno;
    }

    public void setOperandoUno(Integer operandoUno) {
        this.operandoUno = operandoUno;
    }

    public Integer getOperandoDos() {
        return operandoDos;
    }

    public void setOperandoDos(Integer operandoDos) {
        this.operandoDos = operandoDos;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    public Exception getError() {
        return error;
    }

    public void setError(Exception error) {
        this.error = error;
    }
}
