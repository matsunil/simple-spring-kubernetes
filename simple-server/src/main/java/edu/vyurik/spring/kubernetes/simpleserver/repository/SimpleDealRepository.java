package edu.vyurik.spring.kubernetes.simpleserver.repository;

import java.util.List;

import edu.vyurik.spring.kubernetes.simpleserver.model.SimpleDeal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SimpleDealRepository extends MongoRepository<SimpleDeal, String> {

    public List<SimpleDeal> findByDestination(String destination);

}