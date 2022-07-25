package polymorphism;

public class casting {

    public static class Base{
        public String name;
        public String a;

        public Base(String name, String a) {
            this.name = name;
            this.a = a;
        }

        public Base() {
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setA(String a) {
            this.a = a;
        }
    }

    public static class Derived extends Base{
        public String name;
        public String b;

        public Derived(String name, String b) {
            this.name = name;
            this.b = b;
        }

        public Derived() {
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setB(String b) {
            this.b = b;
        }
    }

    public static void main(String[] args) {
//        Base base = new Base("Base", "1");
//        Derived downCastedBase = (Derived) base;
//        // 원상복귀가 아닌 다운캐스팅은 불가함.

        Derived derived = new Derived();
        derived.setA("A"); // -> we can set A that is field of Base Class
    }


}
