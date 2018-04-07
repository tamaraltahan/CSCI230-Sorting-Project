import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Reader {

    private ArrayList<Entry<Integer, String>> listA = new ArrayList<>();
    private ArrayList<Entry<String, Integer>> listB = new ArrayList<>();

    //storage for elements in the file
    private ArrayList<Integer> smallIntermediateList = new ArrayList<>();
    private ArrayList<Integer> largeIntermediateList = new ArrayList<>();

    //file names
    private static final String smallFile = "C:\\Users\\Tamar\\Downloads\\small1k.txt";
    private static final String largeFile = "C:\\Users\\Tamar\\Downloads\\large100k.txt";

    //read namesake's file, and populate arraylists with their values
    public void readLargeFile() {
        readFile(largeFile);
        setLists(largeIntermediateList);
    }

    public void readSmallFile() {
        readFile(smallFile);
        setLists(smallIntermediateList);
    }

    //getters
    public ArrayList<Entry<Integer, String>> getListA() {
        return listA;
    }

    public ArrayList<Entry<String, Integer>> getListB() {
        return listB;
    }

    private void readFile(String FILENAME) {
        BufferedReader reader = null;

        try {
            String text;
            reader = new BufferedReader(new FileReader(FILENAME));
            while ((text = reader.readLine()) != null) {
                String[] numbers = text.split("\\s+"); //split by space

                if (text.charAt(0) == 0) { //string splitting works differently when first character is null. Selecting the index is the only difference
                    for (int i = 0; i < numbers.length; i++) {
                        largeIntermediateList.add(Integer.parseInt(numbers[i]));
                    }
                } else {
                    for (int i = 1; i < numbers.length; i++) {
                        smallIntermediateList.add(Integer.parseInt(numbers[i]));
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