package com.example.ymcbackend.repository;

import com.example.ymcbackend.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// CRUD 함수를 JpaRepository가 들고있음.
// @Reposiotry라는 어노테이션이 없어도 IoC됨. -> JpaRepository 상속받고 있기 때문
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // findBy규칙 -> Email 문법
    // select * from member where email = ?
    Member findByEmail(String email); //jpa query method

    Member findByUsername(String username);
}
