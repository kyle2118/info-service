package com.info.repository;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableMongoRepositories
public interface LeagueRepository extends CrudRepository<LeagueInfo, String> {

}
