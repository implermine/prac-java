package org.example.functionalinterface.andThen;

import java.util.Objects;

/*
And then
 */
@FunctionalInterface
public interface CustomFunctionalInterface<Accept,Return> {

    // match with Function::apply
    Return trigger(Accept t);

    // match with Function::andThen
    // andThen 을 구현하기 위해선 T,U,V 3가지 Type이 필요
    default <Return2> CustomFunctionalInterface<Accept,Return2> andThen(CustomFunctionalInterface<Return,Return2> nextFunction){

        Objects.requireNonNull(nextFunction);

        return new CustomFunctionalInterface<>(){

            // this it not `override` but `extend`
            //@Override
            public Return2 trigger(Accept t) {
                return nextFunction.trigger(CustomFunctionalInterface.this.trigger(t));
            }
        };
    }

    /**
     *    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
     *         Objects.requireNonNull(after);
     *         return (T t) -> after.apply(apply(t));
     *     }
     */

}
