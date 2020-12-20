package com.codaglobal.HackerPremierLeague.repository;

import com.codaglobal.HackerPremierLeague.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<Team,Integer> {
}
