package at.mirtschi.Wiesenbluetenhof.datamodel;

import jakarta.persistence.*;
import lombok.*;

@Entity //erstellt Tabelle
@Getter @Setter //lombok erstellt automatisch Getter, Setter & Konstruktoren --> shortcut für alle 4: @Data
@NoArgsConstructor @AllArgsConstructor //dafür ist zB beim SpringInitializer lombok als dependency zu aktivieren
//Getter, Setter usw one Lombok --> Alt + Einfg
public class Product
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //erstellt pid autoamatisch
    @Column(name = "pid") //dazu da, um die Spalte beschreiben zu können
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

    //Produkt erstellt, damit dieses für das DTO übergeben werden kann, siehe Product Controller
    // wir brauchen keine pid, daher ein extra Konstruktor


}
