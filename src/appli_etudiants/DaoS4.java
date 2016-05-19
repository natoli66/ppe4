/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli_etudiants;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antoine
 */
public class DaoS4 {

    static private Dao<Etudiants, String> clientDao;
    static private ConnectionSource connectionSource;
    static private String databaseUrl;
    static DaoS4 monDaoS4;

    private DaoS4() {
        try {
            DaoS4.databaseUrl = "jdbc:mysql://localhost:3306/applietudiants?user=applietudiants&password=sio";
            DaoS4.connectionSource = new JdbcConnectionSource(databaseUrl);
            DaoS4.clientDao = DaoManager.createDao(DaoS4.connectionSource, Etudiants.class);

        } catch (SQLException ex) {
            Logger.getLogger(DaoS4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Dao<Etudiants, String> etudiantsDao() {
        if (DaoS4.clientDao == null) {
            DaoS4.monDaoS4 = new DaoS4();
        }
        
        return DaoS4.clientDao;
    }
    
    public static Integer getSize() throws SQLException{
        List<Etudiants> clients = DaoS4.etudiantsDao().queryForAll();
        
        return clients.size();
    }
;

}
