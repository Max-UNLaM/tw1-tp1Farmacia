package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.excepciones.ErrorDeAccesoException;
import ar.edu.unlam.tallerweb1.modelo.Calculadora;
import ar.edu.unlam.tallerweb1.modelo.CalculadoraError;
import ar.edu.unlam.tallerweb1.modelo.CalculadoraExito;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculadoraController {
    protected Calculadora calculadora;
    protected static final String ERROR_AMIGABLE = "Hubo un error al realizar el cálculo. x.x";

    @RequestMapping(path = "/calcular/{operando_uno}/{operando_dos}/{operacion}")
    public ModelAndView calcular(@PathVariable(value = "operacion") String operacion,
                         @PathVariable(value = "operando_uno") Integer operandoUno,
                         @PathVariable(value = "operando_dos") Integer operandoDos) {
        try {
            setCalculadora(new Calculadora(operacion, operandoUno, operandoDos));
        } catch (ArithmeticException | ErrorDeAccesoException error) {
            return this.error();
        }
        return this.exito();
    }

    public ModelAndView exito() {
        CalculadoraExito exitoModel = new CalculadoraExito(
                this.getCalculadora().getOperandoUno().toString(),
                this.getCalculadora().getOperandoDos().toString(),
                this.getCalculadora().getOperacion(),
                this.getCalculadora().getResultado().toString()
        );
        ModelMap exitoModelMap = new ModelMap();
        exitoModelMap.put("resultado", exitoModel);
        return new ModelAndView("exito", exitoModelMap);
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
