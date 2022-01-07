package com.study.webflux.data;

import com.study.webflux.data.collections.PetCollection;
import com.study.webflux.enums.Status;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PetRepository {

    public Mono<PetCollection> save(PetCollection petCollection){
        return Mono.just(petCollection);
    };

    public Mono<PetCollection> findById(String id){
        return Mono.just(PetCollection.builder().status(Status.AVAILABLE).name("Gandalf").category("cat").build());
    };

    public Flux<PetCollection> findByStatus(Status status){
        return Flux.just(PetCollection.builder().status(Status.AVAILABLE).name("Kurama").category("cat").build());
    };

}
