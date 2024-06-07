package projet1.calculus;
import org.junit.jupiter.api.Test;
import projet1.calculus.Model.*;
import projet1.calculus.Model.ConjonctionLogiques.Ou;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestOu {
    @Test
    public void testOuVraieOuVraie() {
        Affirmation affirmation1 = new Verite();
        Affirmation affirmation2 = new Verite();
        Ou phraseAvecOu = new Ou(affirmation1, affirmation2);
        assertTrue(phraseAvecOu.estVraie());
    }

    @Test
    public void testOuFauxOuVraie() {
        Affirmation affirmation1 = new Mensonge();
        Affirmation affirmation2 = new Verite();
        Ou phraseAvecOu = new Ou(affirmation1, affirmation2);
        assertTrue(phraseAvecOu.estVraie());
    }

    @Test
    public void testOuVraieOuFaux() {
        Affirmation affirmation1 = new Verite();
        Affirmation affirmation2 = new Mensonge();
        Ou phraseAvecOu = new Ou(affirmation1, affirmation2);
        assertTrue(phraseAvecOu.estVraie());
    }

    @Test
    public void testOuFauxOuFaux() {
        Affirmation affirmation1 = new Mensonge();
        Affirmation affirmation2 = new Mensonge();
        Ou phraseAvecOu = new Ou(affirmation1, affirmation2);
        assertFalse(phraseAvecOu.estVraie());
    }
}
