package com.berkay.repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface Repository <T>{
    public void save(T entity) throws IOException;
    public List<T> findAll() throws IOException;
    public Optional<T> searchById(String id);
    public List<T> searchByName(String name);

}
