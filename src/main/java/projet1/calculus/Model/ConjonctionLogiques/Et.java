package projet1.calculus.Model.ConjonctionLogiques;

import lombok.AllArgsConstructor;
import projet1.calculus.Model.Affirmation;

@AllArgsConstructor
public class Et extends Affirmation {
    private  Affirmation affirmation1;
    private  Affirmation affirmation2;
    @Override
    public boolean estVraie() {
        return affirmation1.estVraie() && affirmation2.estVraie();
    }
}
