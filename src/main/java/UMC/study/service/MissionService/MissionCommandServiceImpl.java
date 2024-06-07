package UMC.study.service.MissionService;

import UMC.study.converter.MemberMissionConverter;
import UMC.study.domain.Member;
import UMC.study.domain.Mission;
import UMC.study.domain.mapping.MemberMission;
import UMC.study.repository.MemberRepository;
import UMC.study.repository.MissionRepository;
import UMC.study.web._dto.MissionRequestDTO;
import UMC.study.web._dto.MissionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;


    @Override
    @Transactional
    public MissionResponseDTO.addMissionResultDTO addMissionToMember(Long memberId, Long missionId, MissionRequestDTO.addMissionDTO request){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(()-> new IllegalArgumentException("invalid member"));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(()-> new IllegalArgumentException("invalid mission"));

        MemberMission memberMission = MemberMissionConverter.toMemberMission(request, member, mission);

        member.getMemberMissionList().add(memberMission);
        mission.getMemberMissionList().add(memberMission);

        memberRepository.save(member);

        return new MissionResponseDTO.addMissionResultDTO(memberMission.getId());

    }
}
