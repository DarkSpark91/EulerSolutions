public class Euler17 {
    public static void main(String[] args) {
        int naughts = "onetwothreefourfivesixseveneightnine".length();
        int teens = "teneleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteen".length();
        int and = "and".length();
        int tens = "twentythirtyfortyfiftysixtyseventyeightyninety".length();
        int hundred = "hundred".length();
        int thousand = "thousand".length();

        System.out.println("one".length() + thousand
            + 900*hundred + 100*naughts +
            100* tens + 891*and +
            80*naughts + 10*(naughts + teens));
    }
}