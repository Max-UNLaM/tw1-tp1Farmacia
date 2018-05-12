package ar.edu.unlam.tallerweb1.modelo;

public class CalculadoraExito {
    public String operacion;
    public String operandoUno;
    public String operandoDos;
    public String resultado;

    public CalculadoraExito() {
    }

    public CalculadoraExito(String operandoUno, String operandoDos, String operacion, String resultado) {
        setOperacion(operacion);
        setOperandoUno(operandoUno);
        setOperandoDos(operandoDos);
        setResultado(resultado);
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getOperandoUno() {
        return operandoUno;
    }

    public void setOperandoUno(String operandoUno) {
        this.operandoUno = operandoUno;
    }

    public String getOperandoDos() {
        return operandoDos;
    }

    public void setOperandoDos(String operandoDos) {
        this.operandoDos = operandoDos;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
