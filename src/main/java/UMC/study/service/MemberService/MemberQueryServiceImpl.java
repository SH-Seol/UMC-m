package UMC.study.service.MemberService;

import UMC.study.domain.Member;
import UMC.study.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {
    private MemberRepository memberRepository;

    @Override
    public Optional<Member> findById(Long memberId){
        return memberRepository.findById(memberId);
    }

}
