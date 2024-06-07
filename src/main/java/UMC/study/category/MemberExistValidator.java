package UMC.study.category;

import UMC.study.service.MemberService.MemberCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberExistValidator {

    private final MemberCommandService memberCommandService;
}
