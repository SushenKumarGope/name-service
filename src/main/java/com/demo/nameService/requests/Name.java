package com.demo.nameService.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Name {

    @JsonProperty("Name")
    @NotBlank(message = "Name cannot be blank")
    String name;

    @JsonProperty("Surname")
    @NotBlank(message = "Surname cannot be blank")
    String surname;

}
