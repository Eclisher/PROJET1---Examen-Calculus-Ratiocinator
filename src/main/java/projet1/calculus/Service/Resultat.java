package projet1.calculus.Service;


import projet1.calculus.Model.Affirmation;

public class Resultat {
    private  static Affirmation affirmation;
    public  static  final String VRAI = "vrai";
    public  static  final String FAUX = "faux";
    public  static  final  String JE_NE_SAIS_PAS = "JeNeSaisPas";


    public  static  String calculer(Affirmation affirmation){
        try {
            if( affirmation.estVraie()){
                return  VRAI;
            } else {
                return FAUX;
            }
        }
        catch (Exception e){
            return  JE_NE_SAIS_PAS;
        }
    }
}