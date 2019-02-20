package com.info.repository;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableMongoRepositories
@Repository
public interface ClubRepository
        extends CrudRepository<ClubInfo, String> {
    Optional<ClubInfo> findByName(String name);
}
