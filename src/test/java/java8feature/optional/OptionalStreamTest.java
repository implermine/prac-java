package java8feature.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalStreamTest {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(3);
        list.add(2);

//        list = null;

        Optional.ofNullable(list).stream().forEach(System.out::println);


        Optional<List<Integer>> optList = Optional.ofNullable(list);

        var collect = optList.map(integers -> integers).orElse(null);
    }
}
