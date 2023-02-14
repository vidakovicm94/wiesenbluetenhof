package at.mirtschi.Wiesenbluetenhof.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ProductDTO {

    @Positive
    private Long pid;

    @NotEmpty @NotBlank
    private String name;

    @NotEmpty @NotBlank
    private String description;

    @Positive
    private Float price;

    @NotEmpty @NotBlank
    private String imagepath;

    @Positive
    private Long category;
}

//Validations in der DTO um die Controller nicht zu überladen.
