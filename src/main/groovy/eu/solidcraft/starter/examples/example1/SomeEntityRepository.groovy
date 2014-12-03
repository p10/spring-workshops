package eu.solidcraft.starter.examples.example1
import org.springframework.data.jpa.repository.JpaRepository

interface SomeEntityRepository extends JpaRepository<SomeEntity, Long> {
    List<SomeEntity> findByUsername(String username)
}