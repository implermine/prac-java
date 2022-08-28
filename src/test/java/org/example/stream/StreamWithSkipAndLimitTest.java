package org.example.stream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamWithSkipAndLimitTest {

    @Test
    @DisplayName("skip과 limit 같이 사용해보기")
    void test() {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        var stream = list.stream();

        Stream<Integer> skipAndLimitedStream = stream.skip(10).limit(1);

        skipAndLimitedStream.forEach(System.out::println);


    }

    @Test
    @DisplayName("stream에 skip과 limit 사용하여 Page의 구현체로 반환하기")
    void test2() throws JsonProcessingException {
        List<String> list =
                Arrays.asList("a", "b","c", "d", "e", "f", "g", "h", "i", "j","k","l","m","n","o","p");
        var sourceSize = list.size();




        int limit = 5;
        int page = 3;
        int skip = limit * page;
        var newList = list.stream().skip(skip).limit(limit).collect(Collectors.toList());


        PageRequest pageRequest = PageRequest.of(page,limit, Sort.Direction.ASC,"karma");

        Page<String> newPage = new PageImpl<>(newList,pageRequest,sourceSize);

        ObjectWriter objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();

        System.out.println(objectWriter.writeValueAsString(newPage));

    }

    @Test
    @DisplayName("페이지네이션 객체 stream 변환")
    void convert_page() throws JsonProcessingException {
        List<String> list =
                Arrays.asList("a", "b","c", "d", "e", "f", "g", "h", "i", "j","k","l","m","n","o","p");
        var sourceSize = list.size();




        int limit = 5;
        int page = 2;
        int skip = limit * page;
        var newList = list.stream().skip(skip).limit(limit).collect(Collectors.toList());


        PageRequest pageRequest = PageRequest.of(page,limit, Sort.Direction.ASC,"karma");

        Page<String> newPage = new PageImpl<>(newList,pageRequest,sourceSize);


        //Page<String> newPageDto = newPage.stream()
        //        .map(s -> s.toUpperCase())
        //        .collect(Collectors.toCollection());

        Page<String> map = newPage.map(String::toUpperCase);


        ObjectWriter objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();

        System.out.println(objectWriter.writeValueAsString(map));

    }

    @Test
    @DisplayName(".skip(-1)")
    void skip_negative(){
        List<String> source =
                Arrays.asList("a", "b","c", "d", "e", "f", "g", "h", "i", "j","k","l","m","n","o","p");
        var sourceSize = source.size();

        String s = source.stream().skip(-1).findFirst().orElse(null); // illegal argument exception

        System.out.println(s);
    }

}
