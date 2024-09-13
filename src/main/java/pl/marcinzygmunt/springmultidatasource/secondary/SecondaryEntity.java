package pl.marcinzygmunt.springmultidatasource.secondary;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "secondary_entity")
public class SecondaryEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String company;

    public Integer getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
