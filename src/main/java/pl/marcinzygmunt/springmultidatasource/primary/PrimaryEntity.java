package pl.marcinzygmunt.springmultidatasource.primary;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "primary_entity")
public class PrimaryEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
