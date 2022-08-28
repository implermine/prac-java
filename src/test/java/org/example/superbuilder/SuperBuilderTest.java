package org.example.superbuilder;

import org.example.superbuilder.model.notabstract.Copper;
import org.example.superbuilder.model.notabstract.Metal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * SuperBuilder 사용성 테스트
 */
public class SuperBuilderTest {

    /**
     * @목적 : Metal의 SuperBuilder를 단순히 사용해봄
     */
    @Test
    void test(){
        Metal.MetalBuilder<?, ?> builder = Metal.builder();

        builder.metalName("metalName");

        Metal built = builder.build();

        System.out.println(built);
    }

    /**
     * @목적: Copper(son of Metal)를 통해 Metal을 같이 생성
     *
     * @결과(의의) : son을 통해 parent를 생성할 수 있다.
     * 쓸일...지금은 없다.
     */
    @Test
    void test2(){
        Copper.CopperBuilder<?, ?> builder = Copper.builder();
        builder.copperName("copperName");
        builder.metalName("metalName");

        Copper built = builder.build();

        System.out.println(built);
    }
}
