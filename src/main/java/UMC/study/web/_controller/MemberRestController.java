package UMC.study.web._controller;

import UMC.study.apiPayload.ApiResponse;
import UMC.study.category.ExistMember;
import UMC.study.converter.MemberConverter;
import UMC.study.domain.Member;
import UMC.study.service.MemberService.MemberCommandService;
import UMC.study.service.MemberService.MemberQueryServiceImpl;
import UMC.study.web._dto.MemberRequestDTO;
import UMC.study.web._dto.MemberResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryServiceImpl memberQueryServiceImpl;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDTO request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "특정 멤버의 리뷰 목록을 조회 API", description = "특정 멤버의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요.", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상해요.", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 아이디, path variable입니다."),
            @Parameter(name = "page", description = "페이지 번호 0번이 1 페이지입니다.")
    })
    public ApiResponse<MemberResponseDTO.MemberReviewResponseDTO> getReviews(@ExistMember @PathVariable(name = "memberId") Long memberId, @RequestParam(name = "page") Integer page){
        memberQueryServiceImpl.getReviewList(memberId, page);
        return null;
    }
}
