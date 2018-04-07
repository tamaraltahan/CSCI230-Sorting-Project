import java.util.ArrayList;

public class Sorting<K,V> {


    String method;
    int valuesSorted;
    double time;

    String type;

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

    public void selectionSort(ArrayList<Entry<Integer,String>> list){
        method = "Selection Sort";
        valuesSorted = list.size();
        type = type1;

        for(int i = 0; i < list.size(); i++){
            int key = list.get(i).getKey();
            int j = i - 1;
            while(j >= 0 && list.get(j).getKey() > key){
                list.set(j+1, j);
            }

        }

    }
    public void insertionSort(){
        method = "Insertion Sort";
    }

    public void quickSort(){
        method = "Insertion Sort";
    }

    public void mergeSort(){
        method = "Insertion Sort";
    }


}
