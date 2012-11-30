/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posjava.exemplo;

import posjava.dao.DAOPessoa;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Cesumar
 */
@Controller
public class ExemploController  {
    
    @Autowired
    DAOPessoa daoPessoa;
    
    public ExemploController() {
    }
    
    @RequestMapping("/helloworld.htm")
    public ModelAndView helloWorld(ModelAndView modelAndView) {
        
        modelAndView.addObject("dataAtual", new Date());
        modelAndView.setViewName("helloWorld");       
        return modelAndView;
    }
    
    
   
}
