package UMC.study.repository;

import UMC.study.domain.Mission;
import UMC.study.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findMissionsByStore(Store store, PageRequest pageRequest);
}
