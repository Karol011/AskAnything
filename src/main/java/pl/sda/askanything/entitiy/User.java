package pl.sda.askanything.entitiy;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
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

    @ManyToOne()
    private CommentToResponse comment;
}
