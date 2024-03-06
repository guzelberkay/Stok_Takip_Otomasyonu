package com.berkay.entity;

import java.util.Random;
import java.util.UUID;

public class Urun {

    private Long id;
    private String ad;
    private double fiyat;

    public Urun(String ad, double fiyat) {
        this.id = UUID.randomUUID().getMostSignificantBits();
        this.ad = ad;
        this.fiyat = fiyat;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Urun{");
        sb.append("id=").append(id).append('\'');
        sb.append(", ad='").append(ad).append('\'');
        sb.append(", fiyat=").append(fiyat);
        sb.append('}');
        return sb.toString();
    }
}


