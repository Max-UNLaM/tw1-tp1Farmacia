package ar.edu.unlam.tallerweb1.funciones;

import ar.edu.unlam.tallerweb1.excepciones.ErrorDeAccesoException;
import ar.edu.unlam.tallerweb1.modelo.Calculadora;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.assertj.core.api.Assertions.*;

@ContextConfiguration(locations = {"/test-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CalculadoraTest {

    protected final Integer OPERANDO_UNO = 10;
    protected final Integer OPERANDO_DOS = 20;
    protected final String MULTIPLICACIO = "suma";
    protected final String RESTA = "resta";
    protected final String DIVISION = "division";
    protected final String MULTIPLICACION = "multiplicacion";
    protected final String CUALQUIER_COSA = "cualquierCosa";

    @Autowired
    private Calculadora calculadora;


    @Test
    public void probarSuma() {
        Integer mockSuma = OPERANDO_UNO + OPERANDO_DOS;
        Double resultado = mockSuma.doubleValue();
        calculadora = new Calculadora(MULTIPLICACIO, OPERANDO_UNO, OPERANDO_DOS);
        assertThat(calculadora.getResultado()).isEqualTo(resultado);
    }

    @Test
    public void probarResta() {
        Integer mock = OPERANDO_UNO - OPERANDO_DOS;
        Double resultado = mock.doubleValue();
        calculadora = new Calculadora(RESTA, OPERANDO_UNO, OPERANDO_DOS);
        assertThat(calculadora.getResultado()).isEqualTo(resultado);
    }
    @Test
    public void probarDivision() {
        Integer mock = OPERANDO_UNO / OPERANDO_DOS;
        Double resultado = mock.doubleValue();
        calculadora = new Calculadora(DIVISION, OPERANDO_UNO, OPERANDO_DOS);
        assertThat(calculadora.getResultado()).isEqualTo(resultado);
    }
    @Test
    public void probarMultiplicacion() {
        Integer mock = OPERANDO_UNO * OPERANDO_DOS;
        Double resultado = mock.doubleValue();
        calculadora = new Calculadora(MULTIPLICACION, OPERANDO_UNO, OPERANDO_DOS);
        assertThat(calculadora.getResultado()).isEqualTo(resultado);
    }

    @Test (expected = ErrorDeAccesoException.class)
    public void probarErrorIngreso() {
        calculadora = new Calculadora(CUALQUIER_COSA, OPERANDO_UNO, OPERANDO_DOS);
    }

    @Test (expected = ArithmeticException.class)
    public void probarErrorMatematico() {
        calculadora = new Calculadora(DIVISION, OPERANDO_UNO, 0);
    }
}
