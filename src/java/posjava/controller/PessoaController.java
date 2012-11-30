package posjava.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import posjava.dao.DAOPessoa;
import posjava.modelo.Pessoa;

/**
 *
 * @author Cesumar
 */
@Controller
public class PessoaController {

    @Autowired
    DAOPessoa daoPessoa;

    @RequestMapping("/pessoa/lista.htm")
    public ModelAndView list(ModelAndView modelAndView) {
        modelAndView.addObject("lista", daoPessoa.list());
        modelAndView.setViewName("pessoa/lista");
        return modelAndView;

    }

    @RequestMapping("/pessoa/delete.htm")
    public String delete(Pessoa pessoa) {
        daoPessoa.delete(pessoa);
        return "redirect:/pessoa/lista.htm";
    }

    @RequestMapping("/pessoa/cria.htm")
    public ModelAndView criaPessoa(ModelAndView modelAndView) {
        Pessoa pessoa = new Pessoa();
        modelAndView.addObject("pessoa", pessoa);
        modelAndView.setViewName("/pessoa/form");
        return modelAndView;
    }

    @RequestMapping("/pessoa/edita.htm")
    public ModelAndView alteraPessoa(Pessoa pessoa, ModelAndView modelAndView) {
        pessoa = daoPessoa.consulta(pessoa);
        modelAndView.addObject("pessoa", pessoa);
        modelAndView.setViewName("/pessoa/form");
        return modelAndView;
    }

    @RequestMapping("/pessoa/salva.htm")
    public String salva(@Valid Pessoa pessoa, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/pessoa/form";
        }
        daoPessoa.save(pessoa);
        return "redirect:/pessoa/lista.htm";
    }

    @RequestMapping("/pessoa/listaJSON.htm")
    public @ResponseBody
    List listJSON() {
        return daoPessoa.list();
    }

    @RequestMapping("/pessoa/listaXML.htm")
    public @ResponseBody
    List<Pessoa> listXML(HttpServletResponse response) {
        response.setContentType("application/xml");
        return daoPessoa.list();

    }
}