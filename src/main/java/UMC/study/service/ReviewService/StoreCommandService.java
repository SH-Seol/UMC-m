package UMC.study.service.ReviewService;

import UMC.study.domain.Review;
import UMC.study.web._dto.MissionRequestDTO;
import UMC.study.web._dto.MissionResponseDTO;
import UMC.study.web._dto.StoreRequestDTO;

public interface StoreCommandService {
    Review addReview(Long memberId, Long storeId, StoreRequestDTO.ReviewDTO request);
    MissionResponseDTO.addMissionResultDTO addMissionToStore(Long storeId, MissionRequestDTO.addMissionDTO request);
}
