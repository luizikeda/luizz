package com.example.luizz.DAO.helper.index;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.luizz.DAO.filter.IndexFilter;
import com.example.luizz.DAO.paginacao.PaginacaoUtil;
import com.example.luizz.Model.IndexModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public class IndexImpl implements IndexQueries {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private PaginacaoUtil paginacaoUtil;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public Page<IndexModel> filtrar(IndexFilter filtro, Pageable pageable) {
        Criteria criteria = manager.unwrap(Session.class).createCriteria(IndexModel.class);

        paginacaoUtil.preparar(criteria, pageable);
        adicionarFiltro(filtro, criteria);

        return new PageImpl<>(criteria.list(), pageable, total(filtro));
    }

    private Long total(IndexFilter filtro) {
        Criteria criteria = manager.unwrap(Session.class).createCriteria(IndexModel.class);
        adicionarFiltro(filtro, criteria);
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }

    private void adicionarFiltro(IndexFilter filtro, Criteria criteria) {
        if (filtro != null) {
            if (filtro.getNome() != null) {
                criteria.add(Restrictions.eq("Nome", filtro.getNome()));
            }

            if (filtro.getCpf()) {
                criteria.add(Restrictions.eq("cpf", filtro.getCpf()));
            }

            if (filtro.getEmail() != null) {
                criteria.add(Restrictions.eq("Email", filtro.getEmail()));
            }

        }
    }

}