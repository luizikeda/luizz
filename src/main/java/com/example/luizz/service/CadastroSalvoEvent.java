package com.example.luizz.service;

import com.example.luizz.Model.IndexModel;

public class CadastroSalvoEvent {

    private IndexModel index;

    public CadastroSalvoEvent(IndexModel index) {
        this.index = index;
    }

    public IndexModel getIndexModel() {
        return index;
    }

}
