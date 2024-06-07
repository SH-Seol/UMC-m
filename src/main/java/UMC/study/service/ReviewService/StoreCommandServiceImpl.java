package UMC.study.service.ReviewService;

import UMC.study.converter.ReviewConverter;
import UMC.study.domain.Mission;
import UMC.study.domain.Review;
import UMC.study.domain.Store;
import UMC.study.repository.MemberRepository;
import UMC.study.repository.MissionRepository;
import UMC.study.repository.ReviewRepository;
import UMC.study.repository.StoreRepository;
import UMC.study.web._dto.MissionRequestDTO;
import UMC.study.web._dto.MissionResponseDTO;
import UMC.study.web._dto.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private ReviewRepository reviewRepository;
    private StoreRepository storeRepository;
    private MemberRepository memberRepository;
    private MissionRepository missionRepository;

    @Override
    @Transactional
    public Review addReview(Long memberId, Long storeId, ReviewRequestDTO.ReviewDTO request) {

        Review newReview = ReviewConverter.toReview(request);
        newReview.setMember(memberRepository.findById(memberId).get());
        newReview.setStore(storeRepository.findById(storeId).get());

        return reviewRepository.save(newReview);
    }

    @Override
    @Transactional
    public MissionResponseDTO.addMissionResultDTO addMissionToStore(Long storeId, MissionRequestDTO.addMissionDTO request){
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid store ID"));

        Mission mission = Mission.builder()
                .point(request.getPoint())
                .dueDate(request.getDueDate())
                .store(store)
                .build();

        missionRepository.save(mission);

        return new MissionResponseDTO.addMissionResultDTO(mission.getId());
    }
}
