package com.study.webflux.web.requests;

import com.study.webflux.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetRequest {

    @NotBlank
    private String name;

    @Builder.Default
    private Status status = Status.AVAILABLE;

    @NotBlank
    private String category;

}
