package UMC.study.service.ReviewService;

import UMC.study.domain.Mission;
import UMC.study.domain.Review;
import UMC.study.domain.Store;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long storeId);

    Page<Review> getReviewList(Long storeId, Integer page);
    Page<Mission> getMissionList(Long storeId, Integer page);
}
