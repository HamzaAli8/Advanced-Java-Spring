package platform.codingnomads.co.springdata.example.jpa.domain;

import lombok.*;


import javax.persistence.*;

@Entity
@Table(name = "weapons")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private CodeWarrior codeWarrior;

    @Column
    private String name;
}
