package projet1.calculus;
import org.junit.jupiter.api.Test;
import projet1.calculus.Model.*;
import projet1.calculus.Model.ConjonctionLogiques.Donc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestDonc {
    @Test
    public void testDoncVraieDoncVraie() {
        Affirmation affirmation1 = new Verite();
        Affirmation affirmation2 = new Verite();
        Donc phraseAvecDonc = new Donc(affirmation1, affirmation2);
        assertTrue(phraseAvecDonc.estVraie());
    }

    @Test
    public void testDoncVraieDoncFaux() {
        Affirmation affirmation1 = new Verite();
        Affirmation affirmation2 = new Mensonge();
        Donc phraseAvecDonc = new Donc(affirmation1, affirmation2);
        assertFalse(phraseAvecDonc.estVraie());
    }

    @Test
    public void testDoncFauxDoncVraie() {
        Affirmation affirmation1 = new Mensonge();
        Affirmation affirmation2 = new Verite();
        Donc phraseAvecDonc = new Donc(affirmation1, affirmation2);
        assertTrue(phraseAvecDonc.estVraie());
    }

    @Test
    public void testDoncFauxDoncFaux() {
        Affirmation affirmation1 = new Mensonge();
        Affirmation affirmation2 = new Mensonge();
        Donc phraseAvecDonc = new Donc(affirmation1, affirmation2);
        assertTrue(phraseAvecDonc.estVraie());
    }
}