/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli_etudiants;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Element;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.mysql.jdbc.Connection;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Anthony
 */
public class GeneratePDF {

    private static String FILE;
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private static Font smallFont = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL);

    public static void generatePdf(Etudiants etudiant) {
        try {
            FILE = "c:/temp/cv_" + etudiant.getNom().toUpperCase() + "_" + etudiant.getPrenom().substring(0, 1).toUpperCase() + etudiant.getPrenom().substring(1) + ".pdf";
            File f = new File(FILE);
            f.getParentFile().mkdirs();
            f.createNewFile();

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();

            
            Paragraph entete = new Paragraph();
            
            //ajout de la photo
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/applietudiants?user=applietudiants&password=sio");
            String query = "SELECT * FROM cv_photo WHERE id_utilisateur = " + etudiant.getId();
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);
            if (results.next()) {
                Blob blob = results.getBlob(2);
                int bloblength = (int) blob.length();
                byte[] blobBytes = blob.getBytes(1, bloblength);
                Image image = Image.getInstance(blobBytes);
                blob.free();
                image.scaleAbsolute(100, 100);
                
                image.setAbsolutePosition(document.right()-image.getScaledWidth(), document.top()-image.getScaledHeight());
                document.add(image);
            }
            
            //ajout de l'entete
            Paragraph nom = new Paragraph(etudiant.getPrenom().substring(0, 1).toUpperCase() + etudiant.getPrenom().substring(1)+" "+etudiant.getNom().toUpperCase());
            nom.setIndentationLeft(30);
            entete.add(nom);
            if (etudiant.getAdresse_rue() != null) {
                entete.add(new Paragraph(etudiant.getAdresse_rue()));
            }
            if (etudiant.getAdresse_cp() != null && etudiant.getAdresse_ville() != null) {
                entete.add(new Paragraph(etudiant.getAdresse_cp() + " " + etudiant.getAdresse_ville()));
            }
            entete.add(new Paragraph("France"));
            if (etudiant.getCourriel() != null) {
                entete.add(new Paragraph(etudiant.getCourriel()));
            }
            if (etudiant.getTel_professionnel() != null) {
                entete.add(new Paragraph(etudiant.getTel_professionnel()));
            }
            if (etudiant.getTel_personnel() != null) {
                entete.add(new Paragraph(etudiant.getTel_personnel()));
            }
            if (etudiant.getSite_web() != null) {
                entete.add(new Paragraph(etudiant.getSite_web()));
            }
            addEmptyLine(entete, 1);
            document.add(entete);

            //ajout du titre
            if (DaoS4.titreDao().queryForId(String.valueOf(etudiant.getId())) != null) {
                Paragraph titre = new Paragraph(DaoS4.titreDao().queryForId(String.valueOf(etudiant.getId())).getLibelle_titre());
                titre.setAlignment(Element.ALIGN_CENTER);
                addEmptyLine(titre, 1);
                document.add(titre);
                
            }

            //ajout des expériences professionnelles
            List<CVEP> EPs = DaoS4.epDao().queryForEq("id_utilisateur", etudiant.getId());
            
            if (!EPs.isEmpty()) {
                Paragraph ep = new Paragraph();
                Paragraph epTitre = new Paragraph("EXPERIENCE PROFESSIONNELLE", catFont);
                ep.add(epTitre);

                for (CVEP item : EPs) {
                    String[] contenu = item.getLibelle_experience_prof().split(Pattern.quote("||"));

                    ep.add(new Paragraph(contenu[0]));
                    Paragraph fonction = new Paragraph(contenu[1] + " - " + contenu[2] + " - " + contenu[3]);
                    fonction.setIndentationLeft(30);
                    ep.add(fonction);


                    for (int i = 4; i < contenu.length; i++) {
                        if (i != contenu.length - 1) {
                            Paragraph tache = new Paragraph(contenu[i], smallFont);
                            tache.setIndentationLeft(30);
                            ep.add(tache);
                        }
                    }
                }
                document.add(ep);
            }
            
            //ajout des formations
            List<CVForm> Formations = DaoS4.formDao().queryForEq("id_utilisateur", etudiant.getId());
            
            if(!Formations.isEmpty()){
                Paragraph form = new Paragraph();
                Paragraph formTitre = new Paragraph("FORMATION", catFont);
                form.add(formTitre);
                
                for (CVForm item : Formations){
                    String[] contenu = item.getLibelle_formation().split(Pattern.quote("||"));
                    
                    form.add(new Paragraph(contenu[0]));
                    
                    Paragraph laFormation = new Paragraph(contenu[1]);
                    laFormation.setIndentationLeft(30);
                    form.add(laFormation);
                    Paragraph lieu = new Paragraph(contenu[2]);
                    lieu.setIndentationLeft(30);
                    form.add(lieu);
                }
                document.add(form);
            }
            
            //ajout des compétences
            List<CVInfo> Competences = DaoS4.infoDao().queryForEq("id_utilisateur", etudiant.getId());
            
            if(!Competences.isEmpty()){
                Paragraph info = new Paragraph();
                Paragraph infoTitre = new Paragraph("INFORMATIQUE", catFont);
                info.add(infoTitre);
                
                for (CVInfo item : Competences){
                    String[] contenu = item.getLibelle_informatique().split(Pattern.quote("||"));
                    
                    info.add(new Paragraph(contenu[0]));
                    Paragraph lesCompetences = new Paragraph(contenu[1]);
                    lesCompetences.setIndentationLeft(30);
                    info.add(lesCompetences);
                }
                document.add(info);
            }
            
            //ajout des langues
            List<CVLangue> Langues = DaoS4.langueDao().queryForEq("id_utilisateur", etudiant.getId());
            
            if(!Langues.isEmpty()){
                Paragraph langues = new Paragraph();
                Paragraph languesTitre = new Paragraph("LANGUES", catFont);
                langues.add(languesTitre);
                
                for(CVLangue item : Langues){
                    String[] contenu = item.getLibelle_langue().split(Pattern.quote("||"));
                    
                    langues.add(new Paragraph(contenu[0]));
                    Paragraph niveau = new Paragraph(contenu[1], smallFont);
                    niveau.setIndentationLeft(30);
                    langues.add(niveau);
                }
                document.add(langues);
            }
            
            //ajout des centres d'interet
            List<CVCentreInteret> CIs = DaoS4.centreInteretDao().queryForEq("id_utilisateur", etudiant.getId());
            
            if(!CIs.isEmpty()){
                Paragraph centres = new Paragraph();
                Paragraph ciTitre = new Paragraph("CENTRES D'INTÉRÊT", catFont);
                centres.add(ciTitre);
                
                for (CVCentreInteret item : CIs){
                    centres.add(new Paragraph(item.getLibelle_centre_interet()));
                }
                document.add(centres);
            }

            document.close();
        } catch (DocumentException | SQLException ex) {
            Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
