package UMC.study.service.ReviewService;

import UMC.study.domain.Review;
import UMC.study.web._dto.ReviewRequestDTO;

public interface StoreCommandService {
    Review addReview(Long memberId, Long storeId, ReviewRequestDTO.ReviewDTO request);
}
