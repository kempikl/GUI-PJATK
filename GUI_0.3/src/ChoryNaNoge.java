public class ChoryNaNoge extends Pacjent {

    public ChoryNaNoge(String name) {
        super(name);
    }

    public final String choroba = "noga";
    public final String leczenie = "gips";

    @Override
    public String choroba() {
        return choroba;
    }

    @Override
    public String leczenie() {
        return leczenie;
    }
}