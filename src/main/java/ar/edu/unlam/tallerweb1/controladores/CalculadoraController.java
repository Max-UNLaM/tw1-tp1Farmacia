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
    @RequestMapping(path = "/calcular/{operando_uno}/{operando_dos}/{operacion}")
    public ModelAndView calcular(@PathVariable(value = "operacion") String operacion,
                                 @PathVariable(value = "operando_uno") Integer operandoUno,
                                 @PathVariable(value = "operando_dos") Integer operandoDos) {
        Calculadora calculadora = new Calculadora(operacion, operandoUno, operandoDos);
        try {
            calculadora.realizarCalculo();
        } catch (ArithmeticException | ErrorDeAccesoException error) {
            return this.error(error.getMessage());
        }
        return this.exito(calculadora);
    }

    public ModelAndView exito(Calculadora calculadora) {
        CalculadoraExito exitoModel = new CalculadoraExito(
                calculadora.getOperandoUno().toString(),
                calculadora.getOperandoDos().toString(),
                calculadora.getOperacion(),
                calculadora.getResultado().toString()
        );
        ModelMap exitoModelMap = new ModelMap();
        exitoModelMap.put("resultado", exitoModel);
        return new ModelAndView("exito", exitoModelMap);
    }

    public ModelAndView error(String message) {
        CalculadoraError calculadoraErrorModel = new CalculadoraError(message);
        ModelMap errorModelMap = new ModelMap();
        errorModelMap.put("errorCal", calculadoraErrorModel);
        return new ModelAndView("error", errorModelMap);
    }
}
