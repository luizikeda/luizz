package com.example.ikeda.DAO;

import com.example.ikeda.Model.IndexModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexDAO extends CrudRepository<IndexModel, Long>{
}
