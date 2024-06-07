package UMC.study.web._controller;

import UMC.study.apiPayload.ApiResponse;
import UMC.study.category.ExistMember;
import UMC.study.service.MissionService.MissionCommandServiceImpl;
import UMC.study.web._dto.MissionRequestDTO;
import UMC.study.web._dto.MissionResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MissionRestController {

    private final MissionCommandServiceImpl missionCommandService;

    @PostMapping("/{MemberId}/missions")
    public ApiResponse<MissionResponseDTO.addMissionResultDTO> addMission(@RequestBody @Valid MissionRequestDTO.addMissionDTO request,
                                                                          @ExistMember @PathVariable Long memberId){
        MissionResponseDTO.addMissionResultDTO result = missionCommandService.addMissionToMember(memberId, request.getMissionId(), request);
        return ApiResponse.onSuccess(result);
    }

}
