package pl.sda.askanything.entitiy;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    @Column(name = "category_id")
    private Long categoryId;

    @NonNull
    private String name;

    @Column(name = "parent_category")
    private String parent;
}
