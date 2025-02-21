package ma.enset.gestionconsultation.entities;

import java.util.List;

//classe persistante ou entite
public class Patient {
    private long id;
    private String nom;
    private String prenom;
    private String tel;
    //l'association: un patient peut avoir plusieurs consultation
    private List<Consultation> consultations;

    public Patient(){}
    public Patient(long id, String nom, String prenom, String tel){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }

    public long getId() {
        return id;
    }
    public void setId(long idPatient) {
        this.id = idPatient;
    }
    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getTel(){
        return tel;
    }
    public void setTel(String tel){
        this.tel = tel;
    }

    public List<Consultation> getConsultations(){
        return consultations;
    }
    public void setConsultations(List<Consultation> consultations){
        this.consultations = consultations;
    }

    @Override
    public String toString() {
        return
                nom + " " + prenom ;
    }
}
