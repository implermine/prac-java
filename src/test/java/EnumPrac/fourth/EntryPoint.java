package EnumPrac.fourth;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EntryPoint {

    public static void main(String[] args) {

        var a = Arrays.stream(FeeType.values())
                .map(feeType -> new EnumMapperValue(feeType)) // <- 구현체를 생성자로 집어넣음.
                .collect(Collectors.toList());


        for (EnumMapperValue enumMapperValue : a) {
            System.out.println(enumMapperValue);
        }


        FeeType[] enumConstants = FeeType.class.getEnumConstants();

        for (FeeType enumConstant : enumConstants) {
            System.out.println(enumConstant);
        }
    }
}
