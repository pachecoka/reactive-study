package com.study.webflux.web;

import com.study.webflux.converter.PetCollectionToPetResponse;
import com.study.webflux.converter.RegisterPetRequestToPet;
import com.study.webflux.converter.UpdatePetRequestToPet;
import com.study.webflux.domain.Pet;
import com.study.webflux.enums.Status;
import com.study.webflux.service.PetService;
import com.study.webflux.web.requests.RegisterPetRequest;
import com.study.webflux.web.requests.UpdatePetRequest;
import com.study.webflux.web.responses.PetResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("pet")
@AllArgsConstructor
@Log4j2
public class PetController {

    private final PetService petService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PetResponse> registerPet(@RequestBody RegisterPetRequest registerPetRequest, ServerHttpResponse response){
        //TODO: return location header
        log.info("Received request to register pet {}", registerPetRequest);
        Pet pet = RegisterPetRequestToPet.convert(registerPetRequest);
        return petService.register(pet).map(PetCollectionToPetResponse::convert);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PetResponse> updatePet(@PathVariable String id, @RequestBody UpdatePetRequest updatePetRequest){
        log.info("Received request to update pet {} with id {}", updatePetRequest, id);
        Pet pet = UpdatePetRequestToPet.convert(updatePetRequest);
        return petService.update(id, pet).map(PetCollectionToPetResponse::convert);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<PetResponse> findByStatus(@RequestParam Status status) {
        log.info("Received request to find pets with status {}", status);
        return petService.findByStatus(status).map(PetCollectionToPetResponse::convert);
    }

}
