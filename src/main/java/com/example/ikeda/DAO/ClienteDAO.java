package com.example.ikeda.DAO;

import com.example.ikeda.Model.ClienteModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDAO extends CrudRepository<ClienteModel, Long>{
}
