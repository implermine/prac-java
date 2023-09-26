package org.example._tenary_operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * 삼항연산자의 뒷항은 조건이 만족되지 않아도 실행되는가?
 *
 * 마치 Optional.orElse() 와 Optional.orElseGet() 의 차이가 존재하는지 테스트
 */
public class TernaryOperatorTest {

    /**
     * @목적: 삼항연산자의 뒷항은, 조건문의 조건이 만족되어 평가되지 않아도 될 것이라 간주될 때도, 평가되는가?
     *
     * @결과 : 그렇지 않음. 따라서 &가 아닌 &&와 같이 행위함.
     */
    @Test
    @DisplayName("삼항연산자의 뒷항은 조건이 만족되지 않아도 실행되는가? -> 실행되지 않음")
    void test1(){

        Object nullObject = null ;

        try{
            Object o2 = nullObject == null ? new Object() : this.test1_logic().orElseThrow(RuntimeException::new);
        }catch (Throwable th){
            System.out.println("== Catched ==");
            th.printStackTrace();
        }


    }

    private Optional<Object> test1_logic(){
        return Optional.empty();
    }
}
