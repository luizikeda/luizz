package com.example.luizz.DAO.helper.index;

import com.example.luizz.DAO.filter.IndexFilter;
import com.example.luizz.Model.IndexModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IndexQueries {

    public Page<IndexModel> filtrar(IndexFilter filtro, Pageable pageable);

}
