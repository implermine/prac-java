package org.example._who_is_this_when_constructing_super;

import org.junit.jupiter.api.Test;

/**
 * @목적 생성(Construct) 중에 `this` keyword는 누구를 지칭하는가?
 *
 * @결과 실제 그 타입(Runtime Type)에 의존한다.
 */
public class WhoIsThisWhenConstructingSuperTest {

    public static class Parent{

        public Parent() {
            this.whoAmI(); // `this` indicates Child
        }

        public void whoAmI(){
            System.out.println("Parent");
            //System.out.println(this.getClass().getSimpleName());
        }


    }

    public static class Child extends Parent{

        public Child() {
            super();
        }

        public void whoAmI(){
            System.out.println("Child");
            //System.out.println(this.getClass().getSimpleName());
        }
    }

    @Test
    void test(){
        Parent parent = new Child(); // Child;
    }
}
