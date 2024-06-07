package projet1.calculus;

import org.junit.jupiter.api.Test;
import projet1.calculus.Model.*;
import projet1.calculus.Model.ConjonctionLogiques.Donc;
import projet1.calculus.Model.ConjonctionLogiques.Et;
import projet1.calculus.Model.ConjonctionLogiques.Ou;
import projet1.calculus.Service.Resultat;

import static org.junit.jupiter.api.Assertions.*;

public class TestAffirmation {

    @Test
    public void testPhrase1() {
        Affirmation louEstPauvre = new Mensonge();
        Affirmation louEstGenereux = new AffirmationGenerale(true);
        Affirmation phrase = new Et(louEstPauvre, louEstGenereux);
        assertEquals(Resultat.FAUX, Resultat.calculer(phrase));
    }

    @Test
    public void testPhrase2() {
        Affirmation louEstBeau = new Verite();
        Affirmation louEstPauvre = new Mensonge();
        Affirmation phrase = new Donc(louEstBeau, louEstPauvre);
        assertEquals(Resultat.FAUX, Resultat.calculer(phrase));
    }

    @Test
    public void testPhrase3() {
        Affirmation louEstPauvre = new Mensonge();
        Affirmation louEstGenereux = new AffirmationGenerale(true);
        Affirmation phrase = new Donc(louEstPauvre, louEstGenereux);
        assertEquals(Resultat.VRAI, Resultat.calculer(phrase));
    }

    @Test
    public void testPhrase4() {
        Affirmation louEstBeau = new Verite();
        Affirmation louEstGenereux = new AffirmationGenerale(true);
        Affirmation louEstPauvre = new Mensonge();
        Affirmation phrase = new Donc(new Ou(louEstBeau, louEstGenereux), louEstPauvre);
        assertEquals(Resultat.FAUX, Resultat.calculer(phrase));
    }

    @Test
    public void testPhrasesSpecifiques() {
        Affirmation louEstBeauOuLouEstGenereux = new Ou(new Verite(), new AffirmationGenerale(true));
        Affirmation louEstPauvre = new Mensonge();
        Affirmation phrase1 = new Donc(louEstBeauOuLouEstGenereux, louEstPauvre);
        Affirmation louEstGenereux = new AffirmationGenerale(true);
        Affirmation phrase2 = new Ou(louEstPauvre, louEstGenereux);
        Affirmation phrase = new Et(phrase2, phrase1);
        assertEquals(Resultat.FAUX, Resultat.calculer(phrase));
    }

    @Test
    public void testValeurIndeterminee() {
        AffirmationGenerale affirmationIndeterminee = new AffirmationGenerale(null);
        assertThrows(RuntimeException.class, affirmationIndeterminee::estVraie);
    }
}