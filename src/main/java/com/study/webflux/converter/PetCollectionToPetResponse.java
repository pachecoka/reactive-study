package com.study.webflux.converter;

import com.study.webflux.data.collections.PetCollection;
import com.study.webflux.web.responses.PetResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PetCollectionToPetResponse {

    public static PetResponse convert(PetCollection petCollection){
        return PetResponse.builder()
                .id(petCollection.getId())
                .name(petCollection.getName())
                .createdAt(petCollection.getCreatedAt())
                .updatedAt(petCollection.getUpdatedAt())
                .build();
    }
}
