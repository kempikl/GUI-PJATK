import java.util.Iterator;

public class Hailstone implements Iterator<Integer>, Iterable<Integer> {

    public int ini;
    private int last = 0;

    public Hailstone(int ini) {
        this.ini = ini;
    }

    @Override
    public boolean hasNext() {
        if(ini != 1){
            return true;
        } else {
            ini++;
            last++;
            return last == 1;
        }
    }

    @Override
    public Integer next() {

        if(ini % 2 == 0){
            ini /= 2;
        }
        else {
            ini = 3 * ini + 1;
        }
        return ini;
    }

    @Override
    public Iterator<Integer> iterator() {
        return this;
    }

}