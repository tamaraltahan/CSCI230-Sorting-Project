import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Reader<K,V> {

    //-------------------------------file names------------------------------------
    private static final String smallFile = "C:\\Users\\Tamar\\Downloads\\small1k.txt";
    private static final String largeFile = "C:\\Users\\Tamar\\Downloads\\large100k.txt";
    //-----------------------------------------------------------------------------

    //---------------------containers------------------------
    private ArrayList<Entry<K, V>> listA = new ArrayList<>();
    private ArrayList<Entry<K, V>> listB = new ArrayList<>();
    //-------------------------------------------------------

    //read namesake's file, and populate arraylists with their values
    public void readSmallFile() {
        ArrayList<Integer> tempSmall = new ArrayList<>();
        readFile(smallFile,tempSmall);
        setLists(tempSmall);
    }
    public void readLargeFile() {
        ArrayList<Integer> tempLarge = new ArrayList<>();
        readFile(largeFile, tempLarge);
        setLists(tempLarge);
    }
    //----------------------------------------------------------------

    //--------------------------getters-------------------------------
    public ArrayList<Entry<K, V>> getListA() {
        ArrayList<Entry<K, V>> A = new ArrayList<>(listA);
        listA.clear();
        return A;
    }
    public ArrayList<Entry<K, V>> getListB() {
        ArrayList<Entry<K, V>> B = new ArrayList<>(listB);
        listA.clear();
        return B;
    }
    //----------------------------------------------------------------


    private void readFile(String FILENAME, ArrayList<Integer> list) {
        BufferedReader reader = null;

        try {
            String text;
            reader = new BufferedReader(new FileReader(FILENAME));
            while ((text = reader.readLine()) != null) {
                if(FILENAME.equals(largeFile)){
                    list.add(Integer.parseInt(text));
                }
                else {
                    String[] numbers = text.split("\\s+"); //split by space
                    for (int i = 1; i < numbers.length; i++) {
                        list.add(Integer.parseInt(numbers[i]));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
    }

    //sets two Arraylists with entry types Integer,String - and String,Integer (same values - different types)
    //also Entry has been changed from an interface to a class so I can directly insert entries
    private void setLists(ArrayList<Integer> intermediateList) {
        for (int i = 0; i < intermediateList.size(); i++) {
            String entryString = Integer.toString(intermediateList.get(i));
            Entry entryA = new Entry(intermediateList.get(i), entryString);
            Entry entryB = new Entry(entryString, intermediateList.get(i));
            listA.add(entryA);
            listB.add(entryB);
        }
    }
}