package com.cda.dao;

import com.cda.entity.Livre;
import org.springframework.data.repository.CrudRepository;

public interface ILivreDao extends CrudRepository<Livre, Integer> {
}
