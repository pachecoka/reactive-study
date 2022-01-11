package com.study.webflux.data;

import com.study.webflux.data.collections.PetCollection;
import com.study.webflux.enums.Status;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PetRepository extends FirestoreReactiveRepository<PetCollection> {

     Flux<PetCollection> findByStatus(Status status);

}
