package UMC.study.converter;

import UMC.study.domain.Member;
import UMC.study.domain.Mission;
import UMC.study.domain.enums.MissionStatus;
import UMC.study.domain.mapping.MemberMission;
import UMC.study.web._dto.MissionRequestDTO;


public class MemberMissionConverter {
    public static MemberMission toMemberMission(MissionRequestDTO.addMissionDTO request, Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }
}
