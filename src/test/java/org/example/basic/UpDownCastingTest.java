package org.example.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UpDownCastingTest {

    private static class Base{
        String var1 = "Base";

        public void whoAmI(){
            System.out.println("Base");
        }
    }
    private static class Derived extends Base{
        String var1 = "Derived";

        public void whoAmI(){
            System.out.println("Derived");
        }
    }

    /**
     *
     */
    @Test
    @DisplayName("UpDown")
    void test1(){
        // 업캐스팅
        Base base = new Derived();
        System.out.println("base = " + base); //base = Derived@6108b2d7
        System.out.println("base.getClass() = " + base.getClass()); //base.getClass() = class Derived
        System.out.println(base.var1); //Base
        base.whoAmI(); //Derived

        if(base instanceof Derived){ // true
            System.out.println("실제 런타임 타입에 의존한다.");
        }

        // 원상복귀 의미의 다운캐스팅만 허용한다.
        Derived derived = (Derived)base;
        System.out.println("derived = " + derived); //derived = Derived@6108b2d7
        System.out.println("derived.getClass() = " + derived.getClass()); //derived.getClass() = class Derived
        System.out.println(base.var1); //Base
        base.whoAmI(); //Derived
    }
}
