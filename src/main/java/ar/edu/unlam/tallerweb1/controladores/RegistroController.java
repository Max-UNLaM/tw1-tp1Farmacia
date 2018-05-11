package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistroController {

    @RequestMapping("/registro")
    public ModelAndView irALogin() {
        return new ModelAndView("registro");
    }




    @RequestMapping(path = "/registro", method = RequestMethod.POST)
    public ModelAndView registrarUsuario(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
        ModelMap userModel = new ModelMap();
        userModel.put("usuario", usuario);
        return new ModelAndView("post_registro", userModel);
    }
}
