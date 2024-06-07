package UMC.study.domain.mapping;

import UMC.study.domain.Member;
import UMC.study.domain.Mission;
import UMC.study.domain.common.BaseEntity;
import UMC.study.domain.enums.MissionStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;


    public void setMember(Member member) {
        if(this.member != null){
            member.getMemberMissionList().remove(this);
        }
        this.member = member;
        member.getMemberMissionList().add(this);
    }

    public void setMission(Mission mission) {
        if(this.mission != null){
            mission.getMemberMissionList().remove(this);
        }
        this.mission = mission;
        mission.getMemberMissionList().add(this);
    }
}

