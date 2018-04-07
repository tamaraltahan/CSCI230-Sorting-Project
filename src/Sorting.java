import java.util.ArrayList;
import java.util.Queue;

public class Sorting<K, V> {

    TypeComparator comp = new TypeComparator();


    int compares = 0;
    int dataMoves = 0;
    String method;
    int valuesSorted;
    double time;


    String type;
    //key types
    String type1 = "Integer";
    String type2 = "String";


    /*
    Display info:

    1. Sorting Method
    2. Input file name
    3. Number of values sorted and key data type
    4. Number of Key Compares and Data Moves (each SWAP of two values is counted as 3 data moves)
    5. The time in milliseconds
    6. The first 5 pairs and last 5 pairs
     */

    public void selectionSort(ArrayList<Entry<Integer, String>> list) {
        method = "Selection Sort";
        valuesSorted = list.size();
        type = type1;

        double t1 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            Entry entry = list.get(i);
            int j = i - 1;
            compares++;
            while (j >= 0 && comp.compare(list.get(j).getKey(), entry.getKey()) == 1) {
                compares++;
                list.set(j + 1, list.get(j));
                dataMoves += 3;
                j = j - 1;
            }
            list.set(j + 1, entry);
            dataMoves += 3;
        }
        double t2 = System.currentTimeMillis();
        time = t2 - t1;

    }

    public void insertionSort(ArrayList<Entry<Integer, String>> list) {
        method = "Insertion Sort";
        valuesSorted = list.size();
        type = type1;


        double t1 = System.currentTimeMillis();
        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i).getKey();
            int j = i - 1;
            compares++;
            while (j > 0 && comp.compare(list.get(j).getKey(), key) == 1) {
                compares++;
                list.set(j + 1, list.get(j));
                dataMoves += 3;
                j = j - 1;
            }
            list.set(j + 1, list.get(i));
            dataMoves += 3;
        }
        double t2 = System.currentTimeMillis();
        time = t2 - t1;

    }

    private void quickSort(Queue<Entry<Integer,String>> S){

    }

    public void quickSort(ArrayList<Entry<Integer, String>> list) {
        Queue<Entry<Integer, String>> S = new linkedQueue<>();

        for (int i = 0; i < list.size(); i++) {
            S.add(list.get(i));
        }

        method = "Insertion Sort";
        valuesSorted = list.size();
        type = type1;

        if (S.size() < 2) {
            return;
        }

        Integer pivot = list.get(0).getKey() + list.get(list.size() - 1).getKey() + list.get(list.size() / 2).getKey();
        Queue<Entry<Integer, String>> L = new LinkedQueue<>();
        Queue<Entry<Integer, String>> E = new LinkedQueue<>();
        Queue<Entry<Integer, String>> G = new LinkedQueue<>();

        while (!S.isEmpty()) {
            Entry element = S.poll();
            int c = comp.compare(element, pivot);
            if (c < 0)
                L.add(element);
            else if (c > 0)
                G.add(element);
            else
                E.add(element);
        }
        quickSort(L);
        quickSort(G);

    }


    public void mergeSort() {
        method = "Insertion Sort";
    }


}
