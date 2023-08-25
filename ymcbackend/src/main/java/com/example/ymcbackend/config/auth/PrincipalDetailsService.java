package com.example.ymcbackend.config.auth;

import com.example.ymcbackend.domain.Member;
import com.example.ymcbackend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 시큐리티 설정에서 loginProcessingUrl("/login");
// login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC되어 있는 loadUserByUsername 함수가 실행됨.
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    // 시큐리티 session = Authentication = UserDetails
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(username);
        if (member != null) {
            return new PrincipalDetails(member);
        }
        // 리턴된 값이 시큐리티 session 안에 Authentication 안에 UserDetails에 들어간다.
        // session(내부 Authentication(내부 UserDetails))
        // 리턴될 때 Authentication이 자동으로 만들어진다.
        return null;
    }
}
