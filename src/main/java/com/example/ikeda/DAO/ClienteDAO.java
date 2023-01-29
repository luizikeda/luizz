package com.example.ikeda.DAO;

import com.example.ikeda.Model.ClienteModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteDAO extends CrudRepository<ClienteModel, Long>{

    @Query(nativeQuery = true, value = "" +
    "select c.cep, c.cpf, c.email, c.estado, c.telefone, c.data_nascimento from cliente c\n" +
            "where upper(c.email) like upper(concat('%', :email, '%'))\n" +
            "and upper(c.cpf) like upper(concat('%', :cpf, '%'))")
    List<Object[]>getListarClientes(
            @Param("cpf") String cpf,
            @Param("email") String email
    );
}
