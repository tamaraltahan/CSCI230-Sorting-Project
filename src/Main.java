import java.util.ArrayList;

public class Main {

    static ArrayList<Entry<Integer,String>> listTypeA = new ArrayList<>();
    static ArrayList<Entry<String,Integer>> listTypeB = new ArrayList<>();

    public static void main(String[] args) {
        Reader reader = new Reader();
        reader.readSmallFile();
        listTypeA = reader.getListA();
        listTypeB = reader.getListB();
        Sorting sorter = new Sorting();
        sorter.insertionSort(listTypeA);

    }
}
