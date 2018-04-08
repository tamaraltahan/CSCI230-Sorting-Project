import java.util.ArrayList;


public class Sorting {

    private TypeComparator comp = new TypeComparator();

    private int compares = 0;
    private int dataMoves = 0;
    private String method;
    private int valuesSorted;
    private double time;


    private String type;
    //key types
    private String type1 = "Integer";
    private String type2 = "String";


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
    private int medianOfThree(ArrayList<Entry<Integer,String>> list, int left, int right){
        int mid = (left + right) / 2;
        if(list.get(left).getKey() > list.get(mid).getKey()){
            swap(list, left, mid);
        }
        if(list.get(left).getKey() > list.get(right).getKey()){
            swap(list,left, right);
        }
        if(list.get(mid).getKey() > list.get(right).getKey())
            swap(list,mid,right);

        swap(list,mid,right-1);
        return list.get(right-1).getKey();
    }

    private void swap(ArrayList<Entry<Integer,String>> list, int left, int right){
        Entry temp = list.get(left);
        list.set(left,list.get(right));
        list.set(right,temp);
    }

    private void sort(ArrayList<Entry<Integer, String>> list, int comps, int moves) {
        ArrayList<Entry<Integer, String>> tempList = new ArrayList<>();
        if (list.size() < 2) {
            return;
        }
        int pivot = medianOfThree(list,list.get(0).getKey(),list.get(list.size()-1).getKey());
        ArrayList<Entry<Integer, String>> L = new ArrayList<>();
        ArrayList<Entry<Integer, String>> E = new ArrayList<>();
        ArrayList<Entry<Integer, String>> G = new ArrayList<>();

        int index = 0;
        while (list.get(0) != null) {
            Entry element = list.get(index);
            int c = comp.compare(element.getKey(), pivot);
            if (c < 0)
                L.add(element);
            else if (c > 0)
                G.add(element);
            else
                E.add(element);
            index++;
        }
        sort(L,compares,dataMoves);
        sort(G,compares,dataMoves);

        for (Entry<Integer, String> aL : L) {
            tempList.add(aL);
        }
        for (Entry<Integer, String> aE : E) {
            tempList.add(aE);
        }
        for (Entry<Integer, String> aG : G) {
            tempList.add(aG);
        }
    }

    public void quickSort(ArrayList<Entry<Integer, String>> list) {
        method = "Quick Sort";
        valuesSorted = list.size();
        type = type1;
        double t1 = System.currentTimeMillis();
        sort(list,compares,dataMoves);
        double t2 = System.currentTimeMillis();
        time = t2 - t1;
    }


    /**
     * Merge contents of arrays S1 and S2 into properly sized array S.
     */
    private void merge(ArrayList<Entry<Integer, String>> S1, ArrayList<Entry<Integer, String>> S2, ArrayList<Entry<Integer, String>> S) {
        int i = 0, j = 0;
        while (i + j < S.size()) {
            if (j == S2.size() || (i < S1.size() && comp.compare(S1.get(i).getKey(), S2.get(j).getKey()) < 0))
                S.set(i + j, S1.get(i++)); // copy ith element of S1 and increment i
            else
                S.set(i + j, S2.get(j++)); // copy jth element of S2 and increment j
        }
    }

    public void mergeSort(ArrayList<Entry<Integer, String>> S) {
        method = "Insertion Sort";
        valuesSorted = S.size();
        type = type1;

        double t1 = System.currentTimeMillis();
        int n = S.size();
        if (n < 2) return; // array is trivially sorted
        // divide
        int mid = n / 2;
        ArrayList<Entry<Integer, String>> S1 = new ArrayList<>(S.subList(0, mid)); // copy of first half
        ArrayList<Entry<Integer, String>> S2 = new ArrayList<>(S.subList(mid, n)); // copy of second half
        // conquer (with recursion)
        mergeSort(S1); // sort copy of first half
        mergeSort(S2); // sort copy of second half
        // merge results
        merge(S1, S2, S); // merge sorted halves back into original
        double t2 = System.currentTimeMillis();
        time = t2 - t1;
    }
}
