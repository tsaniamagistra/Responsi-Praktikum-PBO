/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Lab Informatika
 */
public class ModelTabelDataLombaCerita extends AbstractTableModel {
    
    List<DataLombaCerita> lc;

    public ModelTabelDataLombaCerita(List<DataLombaCerita> lc) {
        this.lc = lc;
    }

    @Override
    public int getRowCount() {
        return lc.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Judul";
            case 1:
                return "Alur";
            case 2:
                return "Orisinalitas";
            case 3:
                return "Pemilihan_Kata";
            case 4:
                return "Nilai";
            default :
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return lc.get(row).getJudul();
            case 1:
                return lc.get(row).getAlur();
            case 2:
                return lc.get(row).getOri();
            case 3:
                return lc.get(row).getKata();
            case 4:
                return lc.get(row).getNilai();
            default :
                return null;
        }
    }
    
}
