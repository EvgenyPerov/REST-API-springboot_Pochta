package my.home.repositories;

import my.home.models.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackRepository extends JpaRepository<Pack, Double> {

    Pack findPackByIdentifierIs(String str);
}
