package com.example.ikeda.controller;

import com.example.ikeda.DAO.ClienteDAO;
import com.example.ikeda.Model.ClienteModel;
import com.example.ikeda.Model.Estados;
import com.example.ikeda.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteDAO clienteDAO;

    @Autowired
    private CadastroService cadastroService;

    @GetMapping("/novo")
    public ModelAndView novo(ClienteModel clienteModel) {
        ModelAndView mv = new ModelAndView("usuario/form_cliente");
        mv.addObject("clienteModel", clienteModel);
        return mv;
    }

    @PostMapping(value = "/novo")
    public ModelAndView cadastrar(@Valid ClienteModel clienteModel, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return novo(clienteModel);
        }

        cadastroService.salvar(clienteModel);
        attributes.addFlashAttribute("mensagem", "Cadastro salvo com sucesso!");
        return new ModelAndView("redirect:/cliente");
    }

    @ModelAttribute("todosEstados")
    public List<Estados> todosEstados() {
        return Arrays.asList(Estados.values());
    }
}