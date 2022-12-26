package com.example.luizz.DAO;

import com.example.luizz.Model.IndexModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexDAO extends CrudRepository<IndexModel, Long> {
}
