package pl.khuzzuk.springtest.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyEntityRepo extends JpaRepository<MyEntity, Long> {
}
