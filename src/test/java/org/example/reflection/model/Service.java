package org.example.reflection.model;

public abstract class Service {

    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public Service() {
        this.repository = new RepositoryImpl();
    }
}
