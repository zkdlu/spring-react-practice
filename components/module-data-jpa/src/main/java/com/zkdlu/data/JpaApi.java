package com.zkdlu.data;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/data/jpa")
public class JpaApi {
    private final MemberRepository memberRepository;

    @GetMapping("/insert")
    public Member insert() {
        Team team = new Team("team1");
        Member member = new Member("member1", team);

        return memberRepository.save(member);
    }

    @GetMapping("/list")
    public List<Member> list() {
        return memberRepository.findAll();
    }
}
