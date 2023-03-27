package com.hmg.querydsl.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class MemberDto {

    private String username;
    private int age;

    public MemberDto() {
    }

    @QueryProjection // dto도 Q파일로 생성됨
    public MemberDto(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
