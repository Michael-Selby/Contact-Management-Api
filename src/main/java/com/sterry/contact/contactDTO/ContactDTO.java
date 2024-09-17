package com.sterry.contact.contactDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class ContactDTO {
@NotBlank(message="Field Cannot Be empty")
    @Pattern(regexp="[a-zA-Z]+",message="Field should be words only")
    private String name;

@NotBlank(message = "Field cannot be empty")
    @Pattern(regexp="[0-9]+",message="Field includes numbers only")
    private String number;
}
