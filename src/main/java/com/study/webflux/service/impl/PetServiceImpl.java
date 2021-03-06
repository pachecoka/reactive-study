package com.study.webflux.service.impl;

import com.study.webflux.converter.PetToPetCollection;
import com.study.webflux.data.PetRepository;
import com.study.webflux.data.collections.PetCollection;
import com.study.webflux.domain.Pet;
import com.study.webflux.enums.Status;
import com.study.webflux.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
@Log4j2
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    @Override
    public Mono<PetCollection> register(Pet pet) {
        log.warn("Registering new pet {}", pet);
        PetCollection petCollection = PetToPetCollection.convert(pet);
        log.error("pet: {}", petCollection);
        return petRepository.save(petCollection).onErrorResume(e -> Mono.error(new RuntimeException(
                "Failed to register new pet", e)));
    }

    @Override
    public Mono<PetCollection> update(String id, Pet pet) {
        log.info("Starting to update pet on service");
        log.debug("Pet to update {}, id {}", pet, id);
        return petRepository.findById(id).flatMap(p -> {
                    p.setCategory(pet.getCategory());
                    p.setName(pet.getName());
                    p.setStatus(pet.getStatus());
                    return petRepository.save(p);
                }
        );
    }

    @Override
    public Flux<PetCollection> findByStatus(Status status) {
        return petRepository.findByStatus(status);
    }
}
