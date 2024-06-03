package UMC.study.web._controller;

import UMC.study.apiPayload.ApiResponse;
import UMC.study.converter.ReviewConverter;
import UMC.study.domain.Review;
import UMC.study.service.ReviewService.ReviewService;
import UMC.study.web._dto.ReviewRequestDTO;
import UMC.study.web._dto.ReviewResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private ReviewService reviewService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.ReviewResultDTO> create(@RequestBody @Valid ReviewRequestDTO.ReviewDTO request){
        Review review = reviewService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO(review));
    }

}
