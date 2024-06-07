package UMC.study.web._dto;

import lombok.Getter;

public class MissionRequestDTO {
    @Getter
    public static class addMissionDTO{
        Long missionId;
        Long memberId;
    }
}
