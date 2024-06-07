package UMC.study.web._controller;

import UMC.study.apiPayload.ApiResponse;
import UMC.study.category.ExistStores;
import UMC.study.converter.ReviewConverter;
import UMC.study.domain.Review;
import UMC.study.service.ReviewService.ReviewService;
import UMC.study.web._dto.ReviewRequestDTO;
import UMC.study.web._dto.ReviewResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class ReviewRestController {

    private ReviewService reviewService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.ReviewResultDTO> create(@RequestBody @Valid ReviewRequestDTO.ReviewDTO request,
                                                                 @ExistStores @PathVariable Long storeId,
                                                                 @ExistStores @PathVariable Long memberId){
        Review review = reviewService.addReview(memberId, storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO(review));
    }

}
