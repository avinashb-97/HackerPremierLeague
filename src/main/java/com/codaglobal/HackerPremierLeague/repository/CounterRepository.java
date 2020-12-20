package com.codaglobal.HackerPremierLeague.repository;

import com.codaglobal.HackerPremierLeague.model.Counter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CounterRepository extends MongoRepository<Counter,String > {
}
