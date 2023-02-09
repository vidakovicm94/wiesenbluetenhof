package at.mirtschi.Wiesenbluetenhof.datamodel;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Product
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pid")
    private Long pid;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Float price;

    @OneToOne
    @JoinColumn(name = "cid")
    private Category category;


    public Product(String name, String description, Float price, Category category) {
        this.name           = name;
        this.description    = description;
        this.price          = price;
        this.category       = category;
    }


}
