package my.home.repositories;

import my.home.models.Pack;
import my.home.models.Status;
import my.home.models.TypeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusTrackRepository extends JpaRepository<Status, Double> {
    List<Status> findStatusesByPackIdentifier(String identifier);
    List<Status> findStatusesByOfficeIndexAndNameNotLikeOrderByDate(Integer index, TypeStatus name);

}
