package pl.marcinzygmunt.springmultidatasource.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.marcinzygmunt.springmultidatasource.primary.PrimaryEntity;

import java.util.List;

public interface SecondaryEntityRepository extends JpaRepository<SecondaryEntity, Integer> {
    List<SecondaryEntity> findAll();
}
