package com.study.webflux.data;

import com.study.webflux.data.collections.PetCollection;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends ReactiveMongoRepository<PetCollection, String> {
}
