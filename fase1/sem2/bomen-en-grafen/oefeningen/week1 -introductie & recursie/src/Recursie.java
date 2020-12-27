import java.util.ArrayList;
import java.util.List;

public class Recursie {


    // Oefening 1: n-de Fibonacci-getal

    public static int fibonacci(int getal) {
        if (getal <= 0) {
            throw new IllegalArgumentException();
        }
        if (getal == 1 || getal == 2){
            return 1;
        }
        return fibonacci(getal-1) + fibonacci(getal-2);
    }

    // Oefening 2 : som van cijfers

    public static int somVanCijfers(int getal) {
        getal = Math.abs(getal);
        if (getal == 0){
            return 0;
        }
        else {
            int i = getal % 10;
            return i + somVanCijfers((int)Math.floor(getal / 10));
        }
    }

    // Oefening 3: keer een string om
    public static String keerOm(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (s == ""){
            return "";
        }
        if (s.length() == 1) return s;
        else {
            String str = s.substring(s.length() - 1);
            return str + keerOm(s.substring(0, s.length() - 1));
        }

    }

    //oefening 4: countX

    public static int countX(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (s.length() == 0){
            return 0;
        }
        else {
            String str = s.substring(0,1);
            int i = 0;
            if (str.equals("x")) i = 1;
            return i + countX(s.substring(1));
        }
    }

    //oefening 5 : countHi
    public static int countHi(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (s.length() <= 1){
            return 0;
        }
        else {
            if (s.substring(0,2).equals("hi")){
                return 1 + countHi(s.substring(2));
            }
            else {
                return countHi(s.substring(1));
            }
        }
    }

    // oefening 6
    public static String changeXY(String s) {
        if(s ==null)
            throw new IllegalArgumentException();
        if(s.length() == 0)
            return s;
        else
            return((s.charAt(0) == 'x' ? 'y' : s.charAt(0)) + changeXY(s.substring(1)));
    }

    // oefening 7

    public static String changePi(String s) {
        if(s ==null)
            throw new IllegalArgumentException();
        if(s.length() <= 1)
            return s;
        else {
            if (s.substring(0,2).equals("pi")){
                return "3.14" + changePi(s.substring(2));
            }
            else {
                return s.charAt(0) + Recursie.changePi(s.substring(1));
            }
        }
    }

    // oefening 8:
    public static int tweelog(int getal) {
        if (getal <= 0){
            throw new IllegalArgumentException();
        }
        if (getal == 1){
            return 0;
        }
        else {
            return 1 + tweelog(getal / 2);
        }
    }

    // oefening 9;
    public static double findMaximum(List<Double> lijst) {
        if (lijst == null || lijst.size() == 0){
            throw new IllegalArgumentException();
        }
        else if (lijst.size() == 1){
            return lijst.get(0);
        }
        else {
            double g = findMaximum(lijst.subList(1, lijst.size()));
            if (lijst.get(0) > g){
                return lijst.get(0);
            }
            else {
                return g;
            }
        }
    }

    // oefening 10;
    public static ArrayList<String> findSubstrings(String string) {
        if(string ==null)throw new IllegalArgumentException();
        ArrayList<String> res = new ArrayList<String>();
        if(string.length() <= 1) {
            //ook de lege string telt mee!
            res.add(string);
            return res;
        }
        else {
            res.add(string.substring(0, 1));
            ArrayList<String> res2 = findSubstrings(string.substring(1));
            res.addAll(res2);
            for(String s : res2) {
                res.add(string.charAt(0) + s);
            }
            return res;
        }
    }
}