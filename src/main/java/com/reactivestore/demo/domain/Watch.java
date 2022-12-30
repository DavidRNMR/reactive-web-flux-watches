package com.reactivestore.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Watch {

    @Id
    private String id;
    @NotBlank(message = "id.brand must be present")
    private String brand;
    @NotNull
    @Positive(message = "prize must be positive")
    private Float prize;
    private String type;

}
