package com.study.webflux.data.collections;

import com.study.webflux.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "pet")
public class PetCollection extends BaseCollection {

    private String name;
    private Status status;
    private String category;

}
