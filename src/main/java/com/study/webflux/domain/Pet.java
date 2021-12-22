package com.study.webflux.domain;

import com.study.webflux.enums.Status;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Pet {

    private String name;
    private Status status;
    private String category;

}
