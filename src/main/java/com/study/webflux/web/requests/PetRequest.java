package com.study.webflux.web.requests;

import com.study.webflux.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetRequest {

    @NotBlank
    private String name;

    private Status status;

    @NotBlank
    private String category;

}
