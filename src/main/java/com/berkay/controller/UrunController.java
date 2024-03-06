package com.berkay.controller;


import com.berkay.entity.Urun;
import com.berkay.repository.UrunRepository_File;
import com.berkay.service.UrunService;

import java.io.IOException;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UrunController {

    Scanner scanner = new Scanner(System.in);
    private final UrunService service;

    public UrunController() {
        this.service = new UrunService(new UrunRepository_File());

    }

    public void save() throws IOException {
        System.out.print("Lutfen urun adini giriniz : ");
        String ad = scanner.nextLine();

        System.out.print("Lutfen urunun fiyatini giriniz : ");
        double fiyat = scanner.nextDouble();
        scanner.nextLine();

        //Urun urun = new Urun(ad, fiyat);
        boolean isSave = service.save(ad,fiyat);

        if (isSave) {
            System.out.println("Basarili bir sekilde ekleme islemi yapildi.");
        } else System.out.println("Ekleme islemi basarisiz.");

    }

    public void findAll() throws IOException {
        service.findAll().forEach(System.out::println);
    }

    public void searchById() {
        System.out.print("Lutfen aramak istediginiz ID giriniz : ");
        String id = scanner.nextLine();

        Optional<Urun> sonucVarMi = service.searchById(id);
        if (sonucVarMi.isEmpty()) {
            System.out.println("Kayit bulunamadi");
            return;
        }
        System.out.println(sonucVarMi.get());

    }
    public void searchByName(){
        System.out.println("Lutfen aramak istediginiz ismi giriniz : ");
        String name = scanner.nextLine();
        List<Urun> urunVarMi = service.serarchByName(name);
        if (urunVarMi.isEmpty()){
            System.out.println("Urun bulunamadi");
            return;
        }
        urunVarMi.forEach(System.out::println);
    }
}

