package ar.edu.unlam.tallerweb1.tragamonedas;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Tambor;
import ar.edu.unlam.tallerweb1.modelo.Tragamonedas;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TragamonedasTest extends SpringTest {


    @Before
    public void tuneUp() {
    }

    @Test
    public void elTamborDevuelveDe0A9() {
        Tambor tambor = new Tambor(true);
        assertThat(tambor.getCara()).isGreaterThan(0);
        assertThat(tambor.getCara()).isLessThan(9);
    }

    @Test
    public void obtenerPremio() {
        Tragamonedas tragamonedas = new Tragamonedas();
        tragamonedas.girarTambores();
        Integer caraTamborUno = tragamonedas.getTamborUno().getCara();
        Integer caraTamborDos = tragamonedas.getTamborDos().getCara();
        Integer caraTamborTres = tragamonedas.getTamborTres().getCara();
        Boolean valores = caraTamborUno.equals(caraTamborDos) && caraTamborUno.equals(caraTamborTres);
        assertThat(valores).isEqualTo(tragamonedas.obtenerPremio());
    }

    @Test
    public void ganar() {
        Tambor tamborUno = mock(Tambor.class);
        Tambor tamborDos = mock(Tambor.class);
        Tambor tamborTres = mock(Tambor.class);
        when(tamborUno.getCara()).thenReturn(5);
        when(tamborDos.getCara()).thenReturn(5);
        when(tamborTres.getCara()).thenReturn(5);
        Tragamonedas tragamonedas = new Tragamonedas(tamborUno,tamborDos, tamborTres);
        tragamonedas.girarTambores();
        verify(tamborUno).jugar();
        assertThat(tragamonedas.obtenerPremio()).isTrue();
    }
}
