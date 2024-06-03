package UMC.study.service.ReviewService;

import UMC.study.domain.Review;
import UMC.study.web._dto.ReviewRequestDTO;

public interface ReviewService {
    Review addReview(ReviewRequestDTO.ReviewDTO request);
}
