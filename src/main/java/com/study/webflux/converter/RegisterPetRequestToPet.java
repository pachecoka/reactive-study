package com.study.webflux.converter;

import com.study.webflux.domain.Pet;
import com.study.webflux.web.requests.RegisterPetRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RegisterPetRequestToPet {

    public static Pet convert(RegisterPetRequest pet){
        return Pet.builder()
                .name(pet.getName())
                .category(pet.getCategory())
                .status(pet.getStatus())
                .build();
    }
}
