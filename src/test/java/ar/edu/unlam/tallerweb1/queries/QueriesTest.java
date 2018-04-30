package ar.edu.unlam.tallerweb1.queries;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.dao.Farmacia.FarmaciaDaoImpl;
import ar.edu.unlam.tallerweb1.dao.Farmacia.FarmaciaPuntoDao;
import ar.edu.unlam.tallerweb1.interfaces.PuntoDao;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import ar.edu.unlam.tallerweb1.modelo.Punto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ContextConfiguration(locations = {"/test-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class QueriesTest extends SpringTest {

    @Autowired
    private FarmaciaDaoImpl farmaciaDao;

    @Autowired
    private FarmaciaPuntoDao farmaciaPuntoDao;

    Farmacia farmaciaBase;

    @Before
    public void mockData() {
        Direccion direccion = new Direccion("Alcides", 123, "Temperley", "Veinte");
        farmaciaBase = new Farmacia("Prueba", "123123123", "martes", direccion);

    }

    @Test
    @Transactional
    @Rollback()
    public void alGenerarFarmaciaGuardarData() {
        boolean nuevaFarmacia = farmaciaDao.addFarmacia(farmaciaBase);
        List<Farmacia> farmacias = farmaciaDao.getFarmaciasByName("Prueba");
        for (Farmacia farmacia : farmacias) {
            assertThat(farmacia.getNombre()).isEqualTo("Prueba");
        }
        Punto punto = farmaciaPuntoDao.getPuntoById(farmaciaBase.getGeoLocalizacion().getId());
        assertThat(punto.getId()).isEqualTo(farmaciaBase.getGeoLocalizacion().getId());
    }

}
