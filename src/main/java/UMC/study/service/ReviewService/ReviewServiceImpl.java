package UMC.study.service.ReviewService;

import UMC.study.converter.ReviewConverter;
import UMC.study.domain.Review;
import UMC.study.repository.ReviewRepository;
import UMC.study.web._dto.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    @Override
    @Transactional
    public Review addReview(ReviewRequestDTO.ReviewDTO request) {

        Review newReview = ReviewConverter.toReview(request);

        return reviewRepository.save(newReview);
    }

}
