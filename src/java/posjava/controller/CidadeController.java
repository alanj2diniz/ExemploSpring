package posjava.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import posjava.dao.DAOCidade;
import posjava.modelo.Cidade;

/**
 *
 * @author alan
 */
@Controller
public class CidadeController {
    
    @Autowired
    DAOCidade daoCidade = new DAOCidade();
    List<Cidade> cidades = new ArrayList<Cidade>();

    public CidadeController() {
        cidades = daoCidade.list();
    }
    
    @RequestMapping("/cidade/lista.htm")
    public ModelAndView list(ModelAndView modelAndView) {
        modelAndView.addObject("lista", daoCidade.list());
        modelAndView.setViewName("cidade/lista");
        return modelAndView;
        
    }

    public List<Cidade> getCidades() {
        return cidades;
    }
    
    @RequestMapping("/cidade/delete.htm")
    public String delete(Cidade cidade) {
        daoCidade.delete(cidade);
        return "redirect:/cidade/lista.htm";
    }
    
    @RequestMapping("/cidade/salva.htm")
    public String salva(@Valid Cidade cidade, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/cidade/form";
        }
        daoCidade.save(cidade);
        return "redirect:/cidade/lista.htm";
    }
    
    @RequestMapping("/cidade/edita.htm")
    public ModelAndView alteraCidade(Cidade cidade, ModelAndView modelAndView) {
        cidade = daoCidade.consulta(cidade);
        modelAndView.addObject("cidade", cidade);
        modelAndView.setViewName("/cidade/form");
        return modelAndView;
    }
    
    @RequestMapping("/cidade/cria.htm")
    public ModelAndView criaCidade(ModelAndView modelAndView) {
        Cidade cidade = new Cidade();
        modelAndView.addObject("cidade", cidade);
        modelAndView.setViewName("/cidade/form");
        return modelAndView;
    }
    
}