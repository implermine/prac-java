package org.example.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapTest {

    @Getter
    @SuperBuilder
    @AllArgsConstructor
    public static class Bean{
        private Integer id;
    }

    private final List<Bean> beanList1 = new ArrayList<>();
    private final List<Bean> beanList2 = new ArrayList<>();
    private final List<Bean> beanList3 = new ArrayList<>();

    private final List<List<Bean>> allBeanList = new ArrayList<>();

    @BeforeEach
    public void beforeAll(){
        this.beanList1.add(new Bean(1));
        this.beanList1.add(new Bean(2));
        this.beanList1.add(new Bean(3));

        this.beanList2.add(new Bean(4));
        this.beanList2.add(new Bean(5));

        this.beanList3.add(new Bean(6));
        this.beanList3.add(new Bean(7));
        this.beanList3.add(new Bean(8));
        this.beanList3.add(new Bean(9));

        allBeanList.add(this.beanList1);
        allBeanList.add(this.beanList2);
        allBeanList.add(this.beanList3);
    }

    /**
     * flatMap은 map과 return Type은 같으나, callback의 return type이 Stream이다.
     *
     * 즉, map이 stream을 반환하나, flatMap을 거치면, 각각의 Stream이 concat 된다고 생각.
     */
    @Test
    public void flatMapUsage(){

        List<Integer> collect = this.allBeanList.stream()
                .flatMap(beans -> beans.stream().map(bean -> bean.getId())).collect(Collectors.toList());

        System.out.println(collect);

    }
}
