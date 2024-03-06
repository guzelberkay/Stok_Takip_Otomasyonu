package com.berkay.repository;

import com.berkay.entity.Urun;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UrunRepositoryDB  implements Repository<Urun>{
    @Override
    public void save(Urun entity) {

    }

    @Override
    public List<Urun> findAll() throws IOException {
        return null;
    }

    @Override
    public Optional<Urun> searchById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Urun> searchByName(String name) {
        return null;
    }
}
