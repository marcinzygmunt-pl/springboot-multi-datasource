package pl.marcinzygmunt.springmultidatasource.primary;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrimaryEntityRepository extends JpaRepository<PrimaryEntity, Integer> {
    List<PrimaryEntity> findAll();
}
