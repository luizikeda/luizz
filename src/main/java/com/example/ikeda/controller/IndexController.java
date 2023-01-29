package com.example.ikeda.controller;

import com.example.ikeda.DAO.IndexDAO;
import com.example.ikeda.Model.IndexModel;
import com.example.ikeda.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IndexDAO indexDAO;

    @Autowired
    private CadastroService cadastroService ;

    @RequestMapping
    public ModelAndView novo(IndexModel indexModel) {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("indexModel", indexModel);
        return mv;
    }

    @PostMapping(value = "/novo")
    public ModelAndView cadastrar(@Valid IndexModel index, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return novo(index);
        }

        cadastroService.salvar(index);
        attributes.addFlashAttribute("mensagem", "Cadastro salvo com sucesso!");
        return new ModelAndView("redirect:/index");
    }
}