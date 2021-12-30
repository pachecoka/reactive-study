package com.study.webflux.converter;

import com.study.webflux.domain.Pet;
import com.study.webflux.web.requests.RegisterPetRequest;
import com.study.webflux.web.requests.UpdatePetRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UpdatePetRequestToPet {

    public static Pet convert(UpdatePetRequest pet){
        return Pet.builder()
                .name(pet.getName())
                .category(pet.getCategory())
                .status(pet.getStatus())
                .build();
    }
}
