package projet1.calculus;
import org.junit.jupiter.api.Test;
import projet1.calculus.Model.*;
import projet1.calculus.Model.ConjonctionLogiques.Et;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestEt {
    @Test
    public void testEtVraieEtVraie() {
        Affirmation affirmation1 = new Verite();
        Affirmation affirmation2 = new Verite();
        Et phraseAvecEt = new Et(affirmation1, affirmation2);
        assertTrue(phraseAvecEt.estVraie());
    }

    @Test
    public void testEtFauxEtVraie() {
        Affirmation affirmation1 = new Mensonge();
        Affirmation affirmation2 = new Verite();
        Et phraseAvecEt = new Et(affirmation1, affirmation2);
        assertFalse(phraseAvecEt.estVraie());
    }

    @Test
    public void testEtVraieEtFaux() {
        Affirmation affirmation1 = new Verite();
        Affirmation affirmation2 = new Mensonge();
        Et phraseAvecEt = new Et(affirmation1, affirmation2);
        assertFalse(phraseAvecEt.estVraie());
    }

    @Test
    public void testEtFauxEtFaux() {
        Affirmation affirmation1 = new Mensonge();
        Affirmation affirmation2 = new Mensonge();
        Et phraseAvecEt = new Et(affirmation1, affirmation2);
        assertFalse(phraseAvecEt.estVraie());
    }
}