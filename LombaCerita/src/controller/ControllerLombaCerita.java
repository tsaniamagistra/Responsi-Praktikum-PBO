/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAOImplement.AksiLombaCerita;
import DAOdataLomba.DataLombaDAO;
import java.util.List;
import model.*;
import view.ViewUtama;

/**
 *
 * @author Lab Informatika
 */
public class ControllerLombaCerita {
    ViewUtama frame;
    AksiLombaCerita impldata;
    List<DataLombaCerita> lc;

    public ControllerLombaCerita(ViewUtama frame) {
        this.frame = frame;
        impldata = new DataLombaDAO();
        lc = impldata.getAll();
    }
    
    public void isitabel(){
        lc = impldata.getAll();
        ModelTabelDataLombaCerita mc = new ModelTabelDataLombaCerita(lc);
        frame.getLcTable().setModel(mc);
    }
    
    public void insert(){
        DataLombaCerita lc = new DataLombaCerita();
        lc.setJudul(frame.getJudulTf().getText());
        lc.setAlur(Double.parseDouble(frame.getAlurTf().getText()));
        lc.setOri(Double.parseDouble(frame.getOriTf().getText()));
        lc.setKata(Double.parseDouble(frame.getKataTf().getText()));
        impldata.insert(lc);
    }
    
    public void update(){
        DataLombaCerita lc = new DataLombaCerita();
        lc.setJudul(frame.getJudulTf().getText());
        lc.setAlur(Double.parseDouble(frame.getAlurTf().getText()));
        lc.setOri(Double.parseDouble(frame.getOriTf().getText()));
        lc.setKata(Double.parseDouble(frame.getKataTf().getText()));
        impldata.update(lc);
    }
    
    public void delete(){
        String judul = frame.getJudulTf().getText();
        impldata.delete(judul);
    }
    
}
