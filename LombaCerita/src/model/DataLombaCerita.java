/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lab Informatika
 */
public class DataLombaCerita {
    private String judul;
    private double alur, ori, kata, nilai;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public double getAlur() {
        return alur;
    }

    public void setAlur(double alur) {
        this.alur = alur;
    }

    public double getOri() {
        return ori;
    }

    public void setOri(double ori) {
        this.ori = ori;
    }

    public double getKata() {
        return kata;
    }

    public void setKata(double kata) {
        this.kata = kata;
    }

    public double getNilai() {
        nilai = (alur+ori+kata)/3;
        return nilai;
    }

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }
    
}
