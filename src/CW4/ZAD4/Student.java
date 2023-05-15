package CW4.ZAD4;

class Student {
    private final String name;
    private final String group;
    private final int score;

    public Student(String name, String group, int score) {
        this.name = name;
        this.group = group;
        this.score = score;
    }

    public String getGroup() {
        return this.group;
    }

    @Override
    public String toString() {
        return this.name + "(" + this.group + ")-" + this.score;
    }
}
