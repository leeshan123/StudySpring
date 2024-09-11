package hello.jdbc.service;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Connection;
import java.sql.SQLException;

// 트랜잭선 - @Transactional AOP

@Slf4j
public class MemberServiceV3_3 {


    private final MemberRepositoryV3 memberRepository;

    public MemberServiceV3_3(MemberRepositoryV3 memberRepository) {

        this.memberRepository = memberRepository;
    }

    @Transactional
    public void accountTransfer(String fromId, String toId, int money) throws SQLException{
                bizlogic(fromId, toId, money);

    }

    private void bizlogic(String fromId, String toId, int money) throws SQLException {
        Member fromMember = memberRepository.findById(fromId);
        Member toMember = memberRepository.findById(toId);

        memberRepository.update(fromId, fromMember.getMoney() - money);
        validation(toMember);
        memberRepository.update(toId,toMember.getMoney()+ money);
    }

    private static void validation(Member toMember){
        if(toMember.getMemberId().equals("ex")){
            throw  new IllegalStateException("이체중 예외 발생");
        }
    }

}