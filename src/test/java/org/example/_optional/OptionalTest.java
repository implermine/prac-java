package org.example._optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;


public class OptionalTest {

    /*
    Optional flatMap은 다음과 같은 일을 구성한다.
    1. flatMap의 대상이 될 Function의 return type은 Optional이다.
    2. 즉, 내부 Optional(반환 Optional)이 empty일 경우와, 외부 Optional (대상)이 empty일 경우 모두를 empty로 처리하고 그 외 내부 Optional의 return type을 꺼낸다.
     */
    @Test
    @DisplayName("Optional flatMap")
    void flatMapInOptional() {

        Optional<Locker> locker = this.getOptMember1().flatMap(member -> member.getOptLocker());

        Assertions.assertThat(locker.isEmpty()).isTrue();
    }


    private Optional<Member> getOptMember1(){
        //내부 Optional(getOptLocker)이 null인 경우
        Member newMember = new Member("member1", null);
        return Optional.ofNullable(newMember);
    }

    @AllArgsConstructor
    private static class Member{
        private String name;
        private Locker locker;

        public Optional<Locker> getOptLocker(){
            return Optional.ofNullable(this.locker);
        }
    }

    @AllArgsConstructor
    private static class Locker{
        private String name;
    }
}
