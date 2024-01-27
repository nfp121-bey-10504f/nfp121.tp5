package question1;

public class EnsembleTest extends junit.framework.TestCase {

    public void testUnion() {
        question1.Ensemble<Integer> e1, e2;
        e1 = new question1.Ensemble<Integer>();
        assertEquals(true, e1.add(2));
        assertEquals(true, e1.add(3));

        e2 = new question1.Ensemble<Integer>();
        assertEquals(true, e2.add(3));
        assertEquals(true, e2.add(4));

        question1.Ensemble<Integer> union = e1.union(e2);
        assertEquals(3, union.size());
        assertTrue(union.contains(2));
        assertTrue(union.contains(3));
        assertTrue(union.contains(4));
    }

    public void testAddUnique() {
        var set = new question1.Ensemble<Integer>();
        assertTrue("L'ajout a échoué pour un nouvel élément (1)", set.add(1));
        assertTrue("L'ajout a échoué pour un nouvel élément (2)", set.add(2));
        assertEquals("Après avoir ajouté des éléments distincts, la taille devrait être 2", 2, set.size());
    }

    public void testAddDuplicate() {
        var set = new question1.Ensemble<Integer>();
        set.add(1);
        assertFalse("Ajout d'un élément déjà existant n'a pas échoué comme prévu", set.add(1));
        assertEquals("La taille attendue après l'ajout d'un doublon est 1", 1, set.size());
    }

     public void testUnion_2() {
        var e1 = new Ensemble<Integer>();
        var e2 = new Ensemble<Integer>();

        e1.add(1);
        e1.add(2);
        e2.add(2);
        e2.add(3);

        var union = e1.union(e2);

        assertEquals(3, union.size());
        assertTrue(union.contains(1));
        assertTrue(union.contains(2));
        assertTrue(union.contains(3));
    }

    public void testInter() {
        var e1 = new Ensemble<Integer>();
        var e2 = new Ensemble<Integer>();

        e1.add(1);
        e1.add(2);
        e2.add(2);
        e2.add(3);

        var inter = e1.inter(e2);

        assertEquals(1, inter.size());
        assertTrue(inter.contains(2));
    }

    public void testDiff() {
        var e1 = new Ensemble<Integer>();
        var e2 = new Ensemble<Integer>();

        e1.add(1);
        e1.add(2);
        e2.add(2);
        e2.add(3);

        var diff = e1.diff(e2);

        assertEquals(1, diff.size());
        assertTrue(diff.contains(1));
    }

    public void testDiffSym() {
        var e1 = new Ensemble<Integer>();
        var e2 = new Ensemble<Integer>();

        e1.add(1);
        e1.add(2);
        e2.add(2);
        e2.add(3);

        var diffSym = e1.diffSym(e2);

        assertEquals(2, diffSym.size());
        assertTrue(diffSym.contains(1));
        assertTrue(diffSym.contains(3));
    }

}
