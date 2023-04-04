package com.hmg.querydsl.repository;

import com.hmg.querydsl.dto.MemberSearchCondition;
import com.hmg.querydsl.dto.MemberTeamDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

// QuerydslRepositorySupport는 실무에서 사용하기에는 한계가 존재. (학습용)
public interface MemberSupportRepository {
    List<MemberTeamDto> search(MemberSearchCondition condition);
    Page<MemberTeamDto> searchPageSimple(MemberSearchCondition condition, Pageable pageable);
}
