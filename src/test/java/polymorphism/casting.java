package polymorphism;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class casting {

    @AllArgsConstructor
    @NoArgsConstructor
    public static class Base{
        public String name;
        public String a;
    }

    @AllArgsConstructor
    public static class Derived extends Base{
        public String name;
        public String b;
    }

    public static void main(String[] args) {
        Base base = new Base("Base", "1");
        Derived downCastedBase = (Derived) base;
        // 원상복귀가 아닌 다운캐스팅은 불가함.
    }


}
