package platform.codingnomads.co.springdata.lab.complete.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Table(name = "areas")
@Builder
public class Area implements Serializable {

    private static final long serialVersionUID = 2233440979419205264L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String code;
}
