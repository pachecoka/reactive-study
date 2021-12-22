package com.study.webflux.web;

import com.study.webflux.web.requests.PetRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("pet")
public class PetController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<String> registerPet(@RequestBody PetRequest petRequest){
        return Mono.just(petRequest.toString());
    }

}
