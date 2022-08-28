package org.example.__temp.effectiveJava.builder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BuilderTest {

    @Test
    @DisplayName("default value가 있는 Builder는 default하게 객체를 생성했을 경우 그 값이 존재해야 한다.")
    void should_default_values_are_present_when_builder_build_default(){
        Pojo pojo = Pojo.builder().build();

        assertThat(pojo.getName()).isEqualTo("foo");
        assertThat(pojo.isOriginal()).isTrue();
    }

    @Test
    @DisplayName("default value가 있는 Builder는 default하게 객체를 생성했을 경우 그 값이 No-Arg와 같아야 한다.")
    void should_default_values_are_same_with_builder_and_no_arg(){
        Pojo build = Pojo.builder().build();
        Pojo noArg = new Pojo();

        assertThat(build.getName()).isEqualTo(noArg.getName());
        assertThat(build.isOriginal()).isEqualTo(noArg.isOriginal());
    }

    @Test
    @DisplayName("Force POJO Builder test")
    void forced_pojo_builder_test(){

        ForcedBuilderPojo build = ForcedBuilderPojo.builder(null, true)
                .nameNotForced("nameNotForced")
                .build();

        System.out.println(build);
    }
}
