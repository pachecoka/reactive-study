package com.study.webflux.service;

import com.study.webflux.data.collections.PetCollection;
import com.study.webflux.domain.Pet;
import com.study.webflux.web.requests.PetRequest;
import reactor.core.publisher.Mono;

public interface PetService {

    Mono<PetCollection> register(Pet pet);

    Mono<PetCollection> update(String id, PetRequest pet);
}
