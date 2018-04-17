import java.util.ArrayList;

public class Main {

    static ArrayList<Entry<Integer,String>> listTypeA = new ArrayList<>();
    static ArrayList<Entry<String,Integer>> listTypeB = new ArrayList<>();

    public static void main(String[] args) {
        Reader reader = new Reader();
        Sorting sorter = new Sorting();
        reader.readSmallFile();
        listTypeA = reader.getListA();
        listTypeB = reader.getListB();
        sorter.insertionSort(listTypeA);
        sorter.selectionSort(listTypeA);
        sorter.quickSort(listTypeA);
        sorter.mergeSort(listTypeA);
        sorter.insertionSort(listTypeB);
        sorter.selectionSort(listTypeB);
        sorter.quickSort(listTypeB);
        sorter.mergeSort(listTypeB);

        reader.readLargeFile();
        listTypeA = reader.getListA();
        listTypeB = reader.getListB();
        sorter.quickSort(listTypeA);
        sorter.mergeSort(listTypeA);
        sorter.quickSort(listTypeB);
        sorter.mergeSort(listTypeB);

    }
}
