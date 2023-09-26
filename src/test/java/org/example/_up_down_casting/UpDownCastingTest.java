package org.example._up_down_casting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class UpDownCastingTest {


    public static class Helper{
        public static String returnBaseAndShout(){
            System.out.println("returnBaseAndShout() is invoked...");
            return "Base";
        }

        public static String returnDerivedAndShout(){
            System.out.println("returnDerivedAndShout() is invoked...");
            return "Derived";
        }
    }

    private static class Base{
        String whoAmI = Helper.returnBaseAndShout(); // Base

        public String whoAmI(){
            return "Base";
        }
    }
    private static class Derived extends Base{
        String whoAmI = Helper.returnDerivedAndShout(); // Derived

        public String whoAmI(){
            return "Derived";
        }
    }

    /**
     * @목적 업다운캐스팅 및 오버라이딩 + 하이딩
     *
     * @결과 field는 초기 객체 생성시 필드가 고정된다(하이딩)
     */
    @Test
    @DisplayName("UpDown")
    void test1(){
        // 업캐스팅
        Base base = new Derived();
        System.out.println("base = " + base); //base = Derived@6108b2d7
        System.out.println("base.getClass() = " + base.getClass()); //base.getClass() = class Derived

        System.out.println(base.whoAmI); // Base; it is hidden by type(compile) , and it is fixed when the first object creation is finished.
        Assertions.assertThat(base.whoAmI).isEqualTo("Base");

        System.out.println(base.whoAmI()); // Derived; it is overridden by real(runtime)
        Assertions.assertThat(base.whoAmI()).isEqualTo("Derived");

        if(base instanceof Derived){ // true
            System.out.println("실제 런타임 타입에 의존한다.");
        }

        // 원상복귀 의미의 다운캐스팅만 허용한다.
        Derived derived = (Derived)base;

        System.out.println("derived = " + derived); //derived = Derived@6108b2d7
        System.out.println("derived.getClass() = " + derived.getClass()); //derived.getClass() = class Derived

        System.out.println(base.whoAmI); // Base; ~~it is hidden by type(compile)~~ , it is fixed
        Assertions.assertThat(base.whoAmI).isEqualTo("Base");

        System.out.println(base.whoAmI()); // Derived; ~~it is overridden by real(runtime)~~
        Assertions.assertThat(base.whoAmI()).isEqualTo("Derived");
    }
}
