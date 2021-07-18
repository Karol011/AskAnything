package pl.sda.askanything.entitiy;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    @Column(name = "user_id")
    private long userId;

    @NonNull
    private String name;

    @NonNull
    private String email;

    private String password;

    @OneToOne
    @JoinColumn(name = "responder")
    private Response response;

}
