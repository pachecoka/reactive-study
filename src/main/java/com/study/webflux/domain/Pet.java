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
    private Status status;
    private String category;

}
