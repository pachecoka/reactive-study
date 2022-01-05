package com.study.webflux.data.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class BaseCollection {

    private String id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
