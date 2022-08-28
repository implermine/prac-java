package org.example.__temp.effectiveJava.builder;

import lombok.ToString;

/**
 * 강제로 특정 값들을 받아야만 객체를 생성하는 빌더패턴을 사용하는 pojo
 *
 * nameForced는 값을 받기 + not null
 * originalForced는 값을 받기만 해도 되게끔
 */
@ToString
public class ForcedBuilderPojo {

    private final String nameForced;

    private final boolean originalForced;

    private final String nameNotForced;

    private boolean originalNotForced;

    private ForcedBuilderPojo(String nameForced, boolean originalForced, String nameNotForced, boolean originalNotForced) {
        this.nameForced = nameForced;
        this.originalForced = originalForced;
        this.nameNotForced = nameNotForced;
        this.originalNotForced = originalNotForced;
    }

    /**
     * 여기에 필수값(세팅이 한번은 이루어져야 하는 값) 을 세팅,
     *
     * 그리고 build()할때 AssertionError를 발생시킵니다.(여기가 아님)
     */
    public static Builder builder(String nameForced, boolean originalForced){
        return new Builder(nameForced,originalForced);
    }

    public static class Builder {
        private String nameForced;
        private boolean originalForced;
        private String nameNotForced;
        private boolean originalNotForced;

        Builder(String nameForced, boolean originalForced){
            this.nameForced = nameForced;
            this.originalForced = originalForced;
        }

        public Builder nameNotForced(String nameNotForced){
            this.nameNotForced = nameNotForced;
            return this;
        }

        public Builder originalNotForced(boolean originalNotForced){
            this.originalNotForced = originalNotForced;
            return this;
        }

        /**
         * 여기에 AssertionError 발생
         */
        public ForcedBuilderPojo build(){
            if(this.nameForced==null){
                throw new AssertionError("name must not be null");
            }

            return new ForcedBuilderPojo(this.nameForced,this.originalForced,this.nameNotForced,this.originalNotForced);
        }


    }
}
