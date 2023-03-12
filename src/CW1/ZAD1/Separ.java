package CW1.ZAD1;

public class Separ implements TwoStringsOper {
    private String initStr;

    public Separ(String initStr) {
        this.initStr = initStr;
    }

    @Override
    public String apply(String str1, String str2) {
        return str1 + " " + initStr + " " + str2;
    }
}
