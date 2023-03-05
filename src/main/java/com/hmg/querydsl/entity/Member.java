package com.hmg.querydsl.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter // Setter는 실제 운영에서는 거의 쓰지 말것.
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA에서는 기본 생성자 필요
@ToString(of = {"id", "username", "age"}) // ToString 작성 시 본인 필드만. 연관관계 필드까지 포함 시 (Team) 무한 루프 가능. (Member->Team->Member)
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY) // 1:N 관계에서 보통 N쪽이 주인임
    @JoinColumn(name = "team_id") // JoinColumn 을 가지고 있으면 연관관계의 주인
    private Team team;

    public Member(String username) {
        this(username, 0);
    }

    public Member(String username, int age) {
        this(username, age, null);
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        if (team != null) {
            changeTeam(team);
        }
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
