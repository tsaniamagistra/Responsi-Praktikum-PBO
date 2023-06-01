/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdataLomba;

import DAOImplement.AksiLombaCerita;
import java.util.List;
import model.DataLombaCerita;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.*;

/**
 *
 * @author Lab Informatika
 */
public class DataLombaDAO implements AksiLombaCerita {

    Connection connection;
    final String select = "select * from lomba";
    final String insert = "INSERT INTO lomba (judul, alur, orisinalitas, pemilihanKata, nilai) VALUES (?,?,?,?,?)";
    final String update = "update lomba set alur=?, orisinalitas=?, pemilihanKata=?, nilai=? where judul=?";
    final String delete = "delete from lomba where judul=?";

    public DataLombaDAO() {
        connection = Connector.connection();
    }
    
    @Override
    public void insert(DataLombaCerita lc) {
        PreparedStatement statement = null;
        try {         
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, lc.getJudul());
            statement.setDouble(2, lc.getAlur());
            statement.setDouble(3, lc.getOri());
            statement.setDouble(4, lc.getKata());
            statement.setDouble(5, lc.getNilai());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataLombaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(DataLombaCerita lc) {
        PreparedStatement statement = null;
        try {         
            statement = connection.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            statement.setDouble(1, lc.getAlur());
            statement.setDouble(2, lc.getOri());
            statement.setDouble(3, lc.getKata());
            statement.setDouble(4, lc.getNilai());
            statement.setString(5, lc.getJudul());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataLombaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String judul) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, judul);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataLombaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<DataLombaCerita> getAll() {
        List<DataLombaCerita> lc = null;
        try {
            lc = new ArrayList<DataLombaCerita>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                DataLombaCerita c = new DataLombaCerita();
                c.setJudul(rs.getString("judul"));
                c.setAlur(rs.getDouble("alur"));
                c.setOri(rs.getDouble("orisinalitas"));
                c.setKata(rs.getDouble("pemilihanKata"));
                c.setNilai(rs.getDouble("nilai"));
                lc.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataLombaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lc;
    }
    
}
