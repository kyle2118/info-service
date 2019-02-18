package com.info.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface LeagueRepository extends MongoRepository<LeagueInfo, String> {

}
