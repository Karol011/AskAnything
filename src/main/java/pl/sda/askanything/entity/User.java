package pl.sda.askanything.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class User extends AbstractEntity{

    @NonNull
    private String name;

    @NonNull
    private String email;

    private String password;

    @OneToOne
    @JoinColumn(name = "responder")
    private Response response;

    public User(@NonNull String name, @NonNull String email, String password, Response response) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.response = response;
    }

}
