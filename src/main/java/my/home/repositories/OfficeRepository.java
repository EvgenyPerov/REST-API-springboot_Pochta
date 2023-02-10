package my.home.repositories;

import my.home.models.Office;
import my.home.models.Pack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OfficeRepository extends JpaRepository<Office, Integer> {

//    @Query(value ="SELECT index_office FROM offices", nativeQuery = true)
//    List<Integer> getIndexesOfOffices();

    Office findFirstByIndexIs(Integer index);
}
