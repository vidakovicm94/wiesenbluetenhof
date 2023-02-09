package at.mirtschi.Wiesenbluetenhof.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ProductDTO {

    @Positive
    private Long pid;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @Positive
    private Float price;

    @Positive
    private Long category;
}
