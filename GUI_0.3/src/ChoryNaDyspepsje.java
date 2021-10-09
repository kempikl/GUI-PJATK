public class ChoryNaDyspepsje extends Pacjent {

    public ChoryNaDyspepsje(String name) {
        super(name);
    }

    public final String choroba = "dyspepsja";
    public final String leczenie = "węgiel";

    @Override
    public String choroba() {
        return choroba;
    }

    @Override
    public String leczenie() {
        return leczenie;
    }
}