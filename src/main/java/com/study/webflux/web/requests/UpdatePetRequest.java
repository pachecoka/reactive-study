package com.study.webflux.web.requests;

import com.study.webflux.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdatePetRequest {

    @NotBlank
    private String name;

    @NotNull
    private Status status;

    @NotBlank
    private String category;

}
