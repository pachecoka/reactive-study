package com.study.webflux.converter;

import com.study.webflux.data.collections.PetCollection;
import com.study.webflux.domain.Pet;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PetToPetCollection {

    public static PetCollection convert(Pet pet){
        return PetCollection.builder()
                .name(pet.getName())
                .category(pet.getCategory())
                .status(pet.getStatus())
                .build();
    }
}
