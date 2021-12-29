package com.study.webflux.web;

import com.study.webflux.converter.PetCollectionToPetResponse;
import com.study.webflux.converter.PetRequestToPet;
import com.study.webflux.data.collections.PetCollection;
import com.study.webflux.domain.Pet;
import com.study.webflux.service.PetService;
import com.study.webflux.web.requests.PetRequest;
import com.study.webflux.web.responses.PetResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("pet")
@AllArgsConstructor
@Log4j2
public class PetController {

    private final PetService petService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PetResponse> registerPet(@RequestBody PetRequest petRequest){
        //TODO: return location header
        log.info("Received request to register pet {}", petRequest);
        Pet pet = PetRequestToPet.convert(petRequest);
        return petService.register(pet).map(PetCollectionToPetResponse::convert);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PetCollection> updatePet(@PathVariable String id, @RequestBody PetRequest petRequest){
        return petService.update(id, petRequest);
    }

}
