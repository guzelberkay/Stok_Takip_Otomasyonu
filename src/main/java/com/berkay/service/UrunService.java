package com.berkay.service;

import com.berkay.entity.Urun;
import com.berkay.repository.Repository;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UrunService {

    private final Repository<Urun> repository;

    public UrunService(Repository<Urun> repository) {
        this.repository = repository;
    }

    public boolean save(String ad, double fiyat) throws IOException {

        Optional<Urun> optionalUrun = repository.findAll().stream().filter(user -> user.getAd()
                .equalsIgnoreCase(ad)).findAny();

        if (optionalUrun.isPresent()) {
            return false;
        }

        repository.save(new Urun(ad, fiyat));
        return true;
    }

    public List<Urun> findAll() throws IOException {
        return repository.findAll();
    }

    public Optional<Urun> searchById(String id) {
        return repository.searchById(id);
    }

    public List<Urun> serarchByName(String name) {
        return repository.searchByName(name);
    }
}