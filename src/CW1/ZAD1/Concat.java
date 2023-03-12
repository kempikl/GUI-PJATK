package CW1.ZAD1;

public class Concat implements TwoStringsOper{
    @Override
    public String apply(String str1, String str2) {
        return str1 + str2;
    }
}
