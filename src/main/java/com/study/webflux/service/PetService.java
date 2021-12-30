package com.study.webflux.service;

import com.study.webflux.data.collections.PetCollection;
import com.study.webflux.domain.Pet;
import com.study.webflux.enums.Status;
import com.study.webflux.web.requests.RegisterPetRequest;
import com.study.webflux.web.requests.UpdatePetRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PetService {

    Mono<PetCollection> register(Pet pet);

    Mono<PetCollection> update(String id, Pet pet);

    Flux<PetCollection> findByStatus(Status status);
}
