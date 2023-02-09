package at.mirtschi.Wiesenbluetenhof.datamodel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity //represents table in database
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cartid")
    private long cartid;

    @OneToMany
    @Column(name = "productlist")
    private List<Product> productlist;

    @OneToOne // Diskussion: ist es notwendig diesen User hier anzuführen.
    @Column (name = "user")
    private User user;
}
