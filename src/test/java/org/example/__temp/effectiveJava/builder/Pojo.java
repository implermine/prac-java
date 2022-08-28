package org.example.__temp.effectiveJava.builder;

public class Pojo {

    private String name = "foo";
    
    private boolean original = true;

    public Pojo(String name, boolean original) {
        this.name = name;
        this.original = original;
    }

    public Pojo() {
    }

    private static String $default$name() {
        return "foo";
    }

    private static boolean $default$original() {
        return true;
    }

    public static PojoBuilder builder() {
        return new PojoBuilder();
    }

    public String getName() {
        return this.name;
    }

    public boolean isOriginal() {
        return this.original;
    }

    public static class PojoBuilder {
        private String name$value;
        private boolean name$set;
        private boolean original$value;
        private boolean original$set;

        PojoBuilder() {
        }

        public PojoBuilder name(String name) {
            this.name$value = name;
            this.name$set = true;
            return this;
        }

        public PojoBuilder original(boolean original) {
            this.original$value = original;
            this.original$set = true;
            return this;
        }

        public Pojo build() {
            String name$value = this.name$value;
            if (!this.name$set) {
                name$value = Pojo.$default$name();
            }
            boolean original$value = this.original$value;
            if (!this.original$set) {
                original$value = Pojo.$default$original();
            }
            return new Pojo(name$value, original$value);
        }

        public String toString() {
            return "Pojo.PojoBuilder(name$value=" + this.name$value + ", original$value=" + this.original$value + ")";
        }
    }
}
