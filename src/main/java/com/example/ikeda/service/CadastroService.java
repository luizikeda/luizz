package com.example.ikeda.service;

import com.example.ikeda.DAO.ClienteDAO;
import com.example.ikeda.Model.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroService {

    @Autowired
    private ClienteDAO clienteDAO;

    @Transactional
    public void salvar(ClienteModel index) {
        clienteDAO.save(index);
    }

}
