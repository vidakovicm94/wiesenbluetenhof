package at.mirtschi.Wiesenbluetenhof.datamodel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //represents table in database
@Getter@Setter
@AllArgsConstructor @NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uid")
    private long uid;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

}
