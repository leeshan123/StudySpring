package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

 //Component라는 어노테이션이 같이 있다.
@Transactional
public class MemberService { //ctrl + shift + t 테스트 클래스 만들기

    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원 가입
    public Long join(Member member){
        //같은 이름이 있는 중복 회원 X

        long start = System.currentTimeMillis();
        try {
        validataDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join = "+ timeMs + "ms");
        }
    }
    //전체 회원 조회.
    public List<Member> findMember(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }


    private void validataDuplicateMember(Member member) { //ctrl + alt + t 리펙토링 메서드
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }


}
