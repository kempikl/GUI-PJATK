public class ChoryNaGlowe extends Pacjent {

    public ChoryNaGlowe(String name) {
        super(name);
    }

    public final String choroba = "głowa";
    public final String leczenie = "aspiryna";

    @Override
    public String choroba() {
        return choroba;
    }

    @Override
    public String leczenie() {
        return leczenie;
    }
}