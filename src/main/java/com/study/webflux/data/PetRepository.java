package com.study.webflux.data;


import com.study.webflux.data.collections.PetCollection;
import com.study.webflux.enums.Status;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PetRepository extends ReactiveMongoRepository<PetCollection, String> {

     Flux<PetCollection> findByStatus(Status status);

}
