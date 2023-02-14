package at.mirtschi.Wiesenbluetenhof.datamodel;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty @NotBlank
    @Column(name = "username")
    private String username;
    @NotEmpty @NotBlank
    @Column(name = "password")
    private String password;

}
