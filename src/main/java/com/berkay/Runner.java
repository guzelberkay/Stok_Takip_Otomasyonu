package com.berkay;

import com.berkay.controller.UrunController;

import java.io.IOException;
import java.util.Scanner;

public class Runner {
    /**
     * Bir stok Takip otomasyonu yapacağız.
     *
     * 1- Ürün Ekle
     * 2- Urun Listele
     * 3- Urun Ara
     * 0- CIKIS
     *
     * şeklinde işlemleri yapabilen bir sistem olacak.
     * Bu sistem ilk olarak bir Liist<Urun> şeklinde çalışıyorken,
     * sonrasındav bir Dosyaya ürünlerin kayıt edilmesi istenmiştir.
     * Bu sistemi istenilen herhangi bir repository'ye
     * dönüşebilecek esneklikle tasarlayın ve dönüşüm
     * işini main sınıfında adı config.txt olan
     * bir sınıftan değer okuyarak yazınız.
     *
     */
    public static void main(String[] args) throws IOException {
        int sayac;
        int secim;
        Scanner scanner = new Scanner(System.in);
        UrunController controller = new UrunController();
        do {
            System.out.println("""
                    ***********************************************
                    1- Urun Ekle
                    2- Urun Listele
                    3- Id ye Gore Ara
                    4- Name e Gore Ara
                    0- C I K I S
                    """);
            System.out.print("Secim yapiniz : ");
            secim = scanner.nextInt();

            switch (secim){
                case 1: controller.save();
                case 2: controller.findAll();
                case 3: controller.searchById();
                case 4: controller.searchByName();
                case 0:
                    System.out.println("Cıkıs yapildi");

                    break;
                default:
                    System.out.println("Lutfen gecerli bir secim giriniz...");
            }
        }while (secim!=0);
    }
}
