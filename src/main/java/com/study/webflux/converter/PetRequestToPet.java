package com.study.webflux.converter;

import com.study.webflux.domain.Pet;
import com.study.webflux.web.requests.PetRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PetRequestToPet {

    public static Pet convert(PetRequest pet){
        return Pet.builder()
                .name(pet.getName())
                .category(pet.getCategory())
                .status(pet.getStatus())
                .build();
    }
}
