import java.util.ArrayList;

public class Sorting<K,V> {

    private TypeComparator comp = new TypeComparator();
    private Writer writer = new Writer();

    private int compares = 0;
    private int dataMoves = 0;
    private String method;
    private String file;
    private int valuesSorted = 0;
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


    public void selectionSort(ArrayList<Entry<K, V>> inputList) {
        ArrayList<Entry<K,V>> list = inputList;
        valuesSorted = 0;
        dataMoves = 0;
        compares = 0;
        method = "Selection Sort";
        valuesSorted = list.size();
        file = list.size() == 1000 ? "Small1k.txt" : "Large100k.txt";
        type = list.get(0).getKey() instanceof Integer ? type1 : type2;
        double t1 = System.currentTimeMillis();

        for (int i = 0; i < list.size(); i++) {
            Entry entry = list.get(i);
            int j = i - 1;
            while (j >= 0 && comp.compare(list.get(j).getKey(), entry.getKey()) > 0) {
                compares++;
                list.set(j + 1, list.get(j));
                dataMoves += 3;
                j = j - 1;
            }
            list.set(j + 1, entry);
            compares++;
            dataMoves += 3;
        }

        double t2 = System.currentTimeMillis();
        time = t2 - t1;
        writer.output(method, file, valuesSorted, type, compares, dataMoves, time, list);
    }


    public void insertionSort(ArrayList<Entry<K, V>> inputList) {
        ArrayList<Entry<K,V>> list = inputList;
        valuesSorted = 0;
        dataMoves = 0;
        compares = 0;
        method = "Insertion Sort";
        valuesSorted = list.size();
        file = list.size() == 1000 ? "Small1k.txt" : "Large100k.txt";
        type = list.get(0).getKey() instanceof Integer ? type1 : type2;

        double t1 = System.currentTimeMillis();

        for (int i = 1; i < list.size(); i++) {
            Entry<K,V> temp = list.get(i);
            int j = i;
            compares++;
            while ((j > 0) && (comp.compare(list.get(j-1).getKey(), temp.getKey()) > 0)) {
                compares++;
                list.set(j, list.get(j-1));
                dataMoves += 3;
                j--;
            }
            list.set(j, temp);
            dataMoves += 3;
        }

        double t2 = System.currentTimeMillis();
        time = t2 - t1;
        //printList(list);
        writer.output(method,file,valuesSorted,type,compares,dataMoves,time,list);
    }

    private Entry<K, V> medianOfThree(ArrayList<Entry<K, V>> list, int left, int right) {

        int center = (left + right) / 2;

        if(comp.compare(list.get(left).getKey(),list.get(center).getKey()) > 0){
            swap(list,left,right);
        }
        if(comp.compare(list.get(left).getKey(),list.get(right).getKey()) > 0){
            swap(list,left,right);
        }
        if(comp.compare(list.get(center).getKey(),list.get(right).getKey()) > 0){
            swap(list,center,right);
        }
        swap(list,center,right-1);
        return list.get(right-1);
    }

    private void swap(ArrayList<Entry<K, V>> list, int a, int b) {
        dataMoves+=3;
        Entry<K,V> temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }


    private void quickSort(ArrayList<Entry<K, V>> list, int a, int b, int comps, int moves) {
        if(a >= b){
            compares = comps;
            dataMoves = moves;
            return;
        }
        Entry<K,V> pivot = medianOfThree(list,a,b);
        int left = a;
        int right = b - 1;
        Entry temp;
        comps++;
        while(left <= right){
            comps++;
            while(left <= right && comp.compare(list.get(left).getKey(),pivot.getKey()) < 0){
                left++;
                comps++;
            }
            while(left <= right && comp.compare(list.get(right).getKey(),pivot.getKey()) > 0){
                right--;
                comps++;
            }
            if(left <= right){
                temp = list.get(left);
                list.set(left,list.get(right));
                list.set(right,temp);
                moves+=3;
                left++;
                right--;
            }
        }
        temp = list.get(left);
        list.set(left,list.get(b));
        list.set(b,temp);
        moves += 3;

        quickSort(list,a,left-1,comps,moves);
        quickSort(list,left+1,b,comps,moves);
    }

    public void quickSort(ArrayList<Entry<K, V>> inputList) {
        ArrayList<Entry<K,V>> list = inputList;
        valuesSorted = 0;
        dataMoves = 0;
        compares = 0;
        method = "Quick Sort";
        valuesSorted = list.size();
        file = list.size() == 1000 ? "Small1k.txt" : "Large100k.txt ";
        type = list.get(0).getKey() instanceof Integer ? type1 : type2;
        double t1 = System.currentTimeMillis();
        quickSort(list, 0, list.size()-1, compares, dataMoves);
        double t2 = System.currentTimeMillis();
        time = t2 - t1;
        writer.output(method,file,valuesSorted,type,compares,dataMoves,time,list);
    }


    /**
     * Merge contents of arrays S1 and S2 into properly sized array S.
     */
    private void merge(ArrayList<Entry<K, V>> S1, ArrayList<Entry<K, V>> S2, ArrayList<Entry<K, V>> S, int comps, int moves) {
        int i = 0, j = 0;
        while (i + j < S.size()) {
            comps++;
            if (j == S2.size() || (i < S1.size() && comp.compare(S1.get(i).getKey(), S2.get(j).getKey()) < 0)) {
                S.set(i + j, S1.get(i++)); // copy ith element of S1 and increment i
                moves += 3;
            } else {
                S.set(i + j, S2.get(j++)); // copy jth element of S2 and increment j
                moves += 3;
            }
        }
        dataMoves += moves;
        compares += comps;
    }

    private void mergeSort(ArrayList<Entry<K, V>> S, int comps, int moves) {
        int n = S.size();
        if (n < 2) { // array is trivially sorted
            dataMoves += moves;
            compares += comps;
            return;
        }
        // divide
        int mid = n / 2;
        ArrayList<Entry<K, V>> S1 = new ArrayList<>(S.subList(0, mid)); // copy of first half
        ArrayList<Entry<K, V>> S2 = new ArrayList<>(S.subList(mid, n)); // copy of second half
        // conquer (with recursion)
        mergeSort(S1,comps,moves); // sort copy of first half
        mergeSort(S2,comps,moves); // sort copy of second half
        // merge results
        merge(S1, S2, S, comps, moves); // merge sorted halves back into original
    }

    public void mergeSort(ArrayList<Entry<K, V>> inputList) {
        ArrayList<Entry<K,V>> S = inputList;
        valuesSorted = 0;
        dataMoves = 0;
        compares = 0;
        method = "Merge Sort";
        valuesSorted = S.size();
        file = S.size() == 1000 ? "Small1k.txt" : "Large100k.txt";
        type = S.get(0).getKey() instanceof Integer ? type1 : type2;
        double t1 = System.currentTimeMillis();
        mergeSort(S, compares, dataMoves);
        double t2 = System.currentTimeMillis();
        time = t2 - t1;
        writer.output(method,file,valuesSorted,type,compares,dataMoves,time,S);
    }
}
