package UMC.study.converter;

import UMC.study.domain.Mission;
import UMC.study.domain.Review;
import UMC.study.domain.Store;
import UMC.study.web._dto.StoreRequestDTO;
import UMC.study.web._dto.StoreResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static StoreResponseDTO.ReviewResultDTO toReviewResultDTO(Review review){
         return StoreResponseDTO.ReviewResultDTO
                 .builder()
                 .reviewId(review.getId())
                 .createdAt(LocalDateTime.now())
                 .build();

    }

    public static Review toReview(StoreRequestDTO.ReviewDTO request){
        return Review.builder()
                .content(request.getContent())
                .build();
    }

    public static StoreResponseDTO.ReviewPreviewDTO reviewPreviewDTO(Review review){
        return StoreResponseDTO.ReviewPreviewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt().toLocalDate())
                .content(review.getContent())
                .build();
    }

    public static StoreResponseDTO.ReviewPreviewListDTO reviewPreviewListDTO(Page<Review> reviewList){

        List<StoreResponseDTO.ReviewPreviewDTO> reviewPreviewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreviewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreviewDTOList.size())
                .reviewList(reviewPreviewDTOList)
                .build();

    }

    public static StoreResponseDTO.StoreMissionDTO storeMissionDTO(Mission mission){

        return StoreResponseDTO.StoreMissionDTO.builder()
                .content(mission.getContent())
                .point(mission.getPoint())
                .dueDate(mission.getDueDate())
                .build();
    }
    public static StoreResponseDTO.StoreMissionListDTO storeMissionListDTO(Page<Mission> missionList){
        List<StoreResponseDTO.StoreMissionDTO> storeMissionDTOList = missionList.stream()
                .map(StoreConverter::storeMissionDTO).collect(Collectors.toList());
        return StoreResponseDTO.StoreMissionListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(storeMissionDTOList.size())
                .missionList(storeMissionDTOList).build();
    }
}
