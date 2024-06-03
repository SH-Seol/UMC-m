package UMC.study.converter;

import UMC.study.domain.Review;
import UMC.study.web._dto.ReviewRequestDTO;
import UMC.study.web._dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.ReviewResultDTO toReviewResultDTO(Review review){
         return ReviewResponseDTO.ReviewResultDTO
                 .builder()
                 .reviewId(review.getId())
                 .createdAt(LocalDateTime.now())
                 .build();

    }

    public static Review toReview(ReviewRequestDTO.ReviewDTO request){
        return Review.builder()
                .content(request.getContent())
                .build();
    }
}
