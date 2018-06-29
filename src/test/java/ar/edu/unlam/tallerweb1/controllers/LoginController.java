package ar.edu.unlam.tallerweb1.controllers;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioLoginImpl;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.*;

public class LoginController extends SpringTest {

    @Test
    @Transactional
    @Rollback(true)
    public void loginController() {
        Usuario usuarioMock = mock(Usuario.class);
        HttpServletRequest requestMock = mock(HttpServletRequest.class);
        HttpSession sessionMock = mock(HttpSession.class);
        ServicioLogin servicioLoginMock= mock(ServicioLoginImpl.class);
        ControladorLogin controladorLogin = new ControladorLogin();
        controladorLogin.setServicioLogin(servicioLoginMock);
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(servicioLoginMock.consultarUsuario(usuarioMock)).thenReturn(usuarioMock);
        when(usuarioMock.getRol()).thenReturn("ROL");
        requestMock.setAttribute("ROL", usuarioMock.getRol());
        ModelAndView modelAndView = controladorLogin.validarLogin(usuarioMock, requestMock);
        assertThat(modelAndView.getViewName()).isEqualTo("redirect:/home");
    }

}
