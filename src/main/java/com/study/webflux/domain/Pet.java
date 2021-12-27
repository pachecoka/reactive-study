package com.study.webflux.domain;

import com.study.webflux.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pet {

    private String name;

    @Builder.Default
    private Status status = Status.AVAILABLE;

    private String category;

}
