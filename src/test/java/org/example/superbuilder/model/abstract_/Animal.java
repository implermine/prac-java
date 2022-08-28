package org.example.superbuilder.model.abstract_;

public abstract class Animal {

    private String name;

    Animal(){}
    protected Animal(AnimalBuilder<?, ?> b) {
        this.name = b.name;
    }

    public static abstract class AnimalBuilder<C extends Animal, B extends AnimalBuilder<C, B>> {
        private String name;

        public B name(String name) {
            this.name = name;
            return self();
        }

        protected abstract B self();

        public abstract C build();

        public String toString() {
            return "Animal.AnimalBuilder(name=" + this.name + ")";
        }
    }
}
