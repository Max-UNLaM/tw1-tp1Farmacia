package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.excepciones.ErrorDeAccesoException;
import ar.edu.unlam.tallerweb1.modelo.Calculadora;
import ar.edu.unlam.tallerweb1.modelo.CalculadoraError;
import ar.edu.unlam.tallerweb1.modelo.CalculadoraExito;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculadoraController {
    protected Calculadora calculadora;
    protected static final String ERROR_AMIGABLE = "Hubo un error al realizar el cálculo. x.x";

    @RequestMapping(path = "/calcular/{operando_uno}/{operando_dos}/{operacion}")
    public void calcular(@RequestParam(value = "operacion") String operacion,
                         @RequestParam(value = "operando_uno") Integer operandoUno,
                         @RequestParam(value = "operando_dos") Integer operandoDos) {
        try {
            setCalculadora(new Calculadora(operacion, operandoUno, operandoDos));
        } catch (ArithmeticException | ErrorDeAccesoException error) {
            this.error();
        }
        this.exito();
    }

    public ModelAndView exito() {
        CalculadoraExito resultado = new CalculadoraExito(
                this.getCalculadora().getOperandoUno().toString(),
                this.getCalculadora().getOperandoDos().toString(),
                this.getCalculadora().getResultado().toString()
        );
        return new ModelAndView("exito", "exitoModel", resultado);
    }

    public ModelAndView error() {
        CalculadoraError errorModel = new CalculadoraError(ERROR_AMIGABLE, getCalculadora().getError().getMessage());
        return new ModelAndView("error", "errorModel", errorModel);
    }

    public Calculadora getCalculadora() {
        return calculadora;
    }

    public void setCalculadora(Calculadora calculadora) {
        this.calculadora = calculadora;
    }
}
