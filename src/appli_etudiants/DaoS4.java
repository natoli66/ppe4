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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antoine
 */
public class DaoS4 {

    static private Dao<Etudiants, String> clientDao;
    static private Dao<CVCentreInteret, String> centreInteretDao;
    static private Dao<CVTitre, String> titreDao;
    static private Dao<CVEP, String> epDao;
    static private Dao<CVForm, String> formDao;
    static private Dao<CVInfo, String> infoDao;
    static private Dao<CVLangue, String> langueDao;
    static private ConnectionSource connectionSource;
    static private String databaseUrl;
    static DaoS4 monDaoS4;

    private DaoS4() {
        try {
            DaoS4.databaseUrl = "jdbc:mysql://localhost:3306/applietudiants?user=applietudiants&password=sio";
            DaoS4.connectionSource = new JdbcConnectionSource(databaseUrl);
            DaoS4.centreInteretDao = DaoManager.createDao(DaoS4.connectionSource, CVCentreInteret.class);
            DaoS4.clientDao = DaoManager.createDao(DaoS4.connectionSource, Etudiants.class);
            DaoS4.titreDao = DaoManager.createDao(DaoS4.connectionSource, CVTitre.class);
            DaoS4.epDao = DaoManager.createDao(DaoS4.connectionSource, CVEP.class);
            DaoS4.formDao = DaoManager.createDao(DaoS4.connectionSource, CVForm.class);
            DaoS4.infoDao = DaoManager.createDao(DaoS4.connectionSource, CVInfo.class);
            DaoS4.langueDao = DaoManager.createDao(DaoS4.connectionSource, CVLangue.class);



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
    
    public static Dao<CVCentreInteret, String> centreInteretDao() {
        if (DaoS4.centreInteretDao == null) {
            DaoS4.monDaoS4 = new DaoS4();
        }
        
        return DaoS4.centreInteretDao;
    }
    
    public static Dao<CVTitre, String> titreDao() {
        if (DaoS4.titreDao == null) {
            DaoS4.monDaoS4 = new DaoS4();
        }
        
        return DaoS4.titreDao;
    }
    
    public static Dao<CVEP, String> epDao() {
        if (DaoS4.epDao == null) {
            DaoS4.monDaoS4 = new DaoS4();
        }
        
        return DaoS4.epDao;
    }
    
    public static Dao<CVForm, String> formDao(){
        if (DaoS4.formDao == null) {
            DaoS4.monDaoS4 = new DaoS4();
        }
        
        return DaoS4.formDao;
    }
    
    public static Dao<CVInfo, String> infoDao(){
        if (DaoS4.infoDao == null) {
            DaoS4.monDaoS4 = new DaoS4();
        }
        
        return DaoS4.infoDao;
    }
    
    public static Dao<CVLangue, String> langueDao(){
        if (DaoS4.langueDao == null) {
            DaoS4.monDaoS4 = new DaoS4();
        }
        
        return DaoS4.langueDao;
    }
;

}
