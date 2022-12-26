package com.example.luizz.controller;

import com.example.luizz.DAO.IndexDAO;
import com.example.luizz.DAO.filter.IndexFilter;
import com.example.luizz.Model.IndexModel;
import com.example.luizz.controller.page.PageWrapper;
import com.example.luizz.service.CadastroService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.awt.*;
import java.awt.print.Pageable;

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

    @GetMapping
    public ModelAndView pesquisar(IndexFilter indexFilter, BindingResult result
            , @PageableDefault(size = 2) Pageable pageable, HttpServletRequest httpServletRequest) {
        ModelAndView mv = new ModelAndView("cerveja/PesquisaCervejas");

        PageWrapper<IndexModel> paginaWrapper = new PageWrapper<>(indexDAO.filtrar(indexFilter, pageable)
                , httpServletRequest);
        mv.addObject("pagina", paginaWrapper);
        return mv;
    }

}
