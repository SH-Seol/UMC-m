package UMC.study.web._dto;

import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class addMissionDTO{
        Long missionId;
        Long memberId;
        LocalDate dueDate;
        int point;
    }
}
