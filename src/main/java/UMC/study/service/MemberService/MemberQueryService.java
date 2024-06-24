package UMC.study.service.MemberService;

import UMC.study.domain.Member;
import UMC.study.domain.Review;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> findById(Long memberId);
    Page<Review> getReviewList(Long memberId, Integer page);
}
