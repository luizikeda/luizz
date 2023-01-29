package com.example.ikeda.service;

import com.example.ikeda.DAO.IndexDAO;
import com.example.ikeda.Model.IndexModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroService {

    @Autowired
    private IndexDAO indexDAO;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Transactional
    public void salvar(IndexModel index) {
        indexDAO.save(index);
    }

}
