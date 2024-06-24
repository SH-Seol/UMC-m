package UMC.study.web._controller;

import UMC.study.apiPayload.ApiResponse;
import UMC.study.category.ExistStores;
import UMC.study.converter.StoreConverter;
import UMC.study.domain.Review;
import UMC.study.service.ReviewService.StoreCommandService;
import UMC.study.web._dto.StoreRequestDTO;
import UMC.study.web._dto.StoreResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class ReviewRestController {

    private StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.ReviewResultDTO> create(@RequestBody @Valid StoreRequestDTO.ReviewDTO request,
                                                                @ExistStores @PathVariable Long storeId,
                                                                @ExistStores @PathVariable Long memberId){
        Review review = storeCommandService.addReview(memberId, storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toReviewResultDTO(review));
    }

}
