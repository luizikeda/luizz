package com.example.luizz.DAO.paginacao;

import net.bytebuddy.TypeCache;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class PaginacaoUtil {

    public void preparar(Criteria criteria, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

        criteria.setFirstResult(primeiroRegistro);
        criteria.setMaxResults(totalRegistrosPorPagina);

        TypeCache.Sort sort = pageable.getSort();
        if (sort != null) {
            TypeCache.Sort.Order order = sort.iterator().next();
            String property = order.getProperty();
            criteria.addOrder(order.isAscending() ? Order.asc(property) : Order.desc(property));
        }
    }

}
