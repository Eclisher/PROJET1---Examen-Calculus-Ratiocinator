package projet1.calculus.Model;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AffirmationGenerale extends  Affirmation {
    private  Boolean valeur;
    @Override
    public boolean estVraie() {
        if (valeur == null){
            throw new RuntimeException("Valeur null");
        }
        return valeur;
    }
}
