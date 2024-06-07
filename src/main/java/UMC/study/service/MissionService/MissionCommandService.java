package UMC.study.service.MissionService;

import UMC.study.domain.Member;
import UMC.study.domain.Mission;
import UMC.study.repository.MissionRepository;
import UMC.study.web._dto.MissionRequestDTO;
import UMC.study.web._dto.MissionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface MissionCommandService {

    MissionResponseDTO.addMissionResultDTO addMissionToMember(Long memberId, Long missionId, MissionRequestDTO.addMissionDTO request);
}
