package com.example.ymcbackend.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter // 나중에 지우기
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, length = 250)
    private String password;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String age;

    private String role;

    @OneToOne
    private RomanceInfo romanceInfo;

    @OneToMany(mappedBy = "member")
    private List<Article> articles = new ArrayList<>();

    @CreationTimestamp
    private Timestamp createdAt;

}
