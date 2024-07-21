package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static  class TestBean{

        //Member는 스프링 빈이 아님.
        //true 일때 UnsatisfiedDependencyException이 뜬다.
        @Autowired(required = false)
        public void setNoBean1(Member NoBean1){
            System.out.println("NoBean1 = " + NoBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member NoBean2){
            System.out.println("NoBean2 = " + NoBean2);
        }
        
        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }
    }


}
