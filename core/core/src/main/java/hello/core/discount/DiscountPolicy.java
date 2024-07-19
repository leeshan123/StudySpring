package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    //return으로 할인 대상 금액을 준다.
    int discount(Member member, int price);

}
