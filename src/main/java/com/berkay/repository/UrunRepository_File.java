package com.berkay.repository;

import com.berkay.entity.Urun;


import java.io.*;

import java.util.*;
import java.util.stream.Collectors;

public class UrunRepository_File implements Repository<Urun> {

    private static final String FILE_PATH = "products.txt";

    @Override
    public void save(Urun entity) {
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(entity.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception exception) {
            System.err.println("Hata!!!  | " + exception);
        }
    }

    @Override
    public List<Urun> findAll() throws IOException {
        List<Urun> productList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] values = line.split(" ");
            Urun urun = new Urun(values[0], Double.parseDouble(values[1]));
            productList.add(urun);
        }
        bufferedReader.close();
        return productList;
    }

    @Override
    public Optional<Urun> searchById(String id) {
        try {
            List<Urun> products = findAll();
            return products.stream()
                    .filter(urun -> urun.getId().equals(Long.parseLong(id)))
                    .findFirst();
        } catch (IOException e) {
            System.err.println("Error! | " + e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<Urun> searchByName(String name) {
        try {
            List<Urun> products = findAll();
            return products.stream()
                    .filter(product -> product.getAd().equalsIgnoreCase(name))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Error! | " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
