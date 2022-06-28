package equivalence;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @EqualsAndHashCode 롬복 어노테이션에 의거하여
 * 동등성 비교 시, 서로 상속관계인 객체 동등성 평가
 *
 *
 * 서로 상속관계인 객체는 런타임 객체타입이 다르더라도, 동등성 평가가 가능하며,
 * .eqauls() 메서드를 호출하는 target 객체의 필드(만) 모두 동등에 대해 충족하면 .equals()가 true이다.
 */
public class EquivalenceTest {

    @Test
    public void test(){
        //given
        Derived derived = new Derived();
        Base base = new Base();

        // when
        // Derived의 이름을 Base로 바꿔, base객체와 derived 객체의 name 필드가 같도록 한다.
        derived.setName("Base");

        // then

        Assertions.assertThat(base.equals(derived)).isTrue();
    }

    private static class Base{
        String name = "Base";
        public String say(){
            return "Base::say";
        }

        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof Base)) return false;
            final Base other = (Base) o;
            if (!other.canEqual((Object) this)) return false;
            final Object this$name = this.name;
            final Object other$name = other.name;
            if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
            return true;
        }

        protected boolean canEqual(final Object other) {
            return other instanceof Base;
        }

        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final Object $name = this.name;
            result = result * PRIME + ($name == null ? 43 : $name.hashCode());
            return result;
        }
    }


    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    private static class Derived extends Base{
        String name = "Derived";
        String nickName = "NickName:Derived";
        public String say(){
            return "Derived::say";
        }
    }
}
