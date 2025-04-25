package hako.shareEvent.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name = "cities")
public class City {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}


