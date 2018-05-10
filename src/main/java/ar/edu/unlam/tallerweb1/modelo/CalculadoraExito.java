package ar.edu.unlam.tallerweb1.modelo;

public class CalculadoraExito {
    protected String operacion;
    protected String operandoUno;
    protected String operandoDos;

    public CalculadoraExito() {}
    
    public CalculadoraExito(String operacion, String operandoUno, String operandoDos) {
        setOperacion(operacion);
        setOperandoUno(operandoUno);
        setOperandoDos(operandoDos);
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
}
