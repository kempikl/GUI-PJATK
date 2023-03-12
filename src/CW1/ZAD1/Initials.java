package CW1.ZAD1;

public class Initials implements TwoStringsOper{
    @Override
    public String apply(String str1, String str2) {
        return str1.charAt(0) + "" + str2.charAt(0);
    }
}
