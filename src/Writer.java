import java.io.*;
import java.util.ArrayList;
/*
  Display info:

  1. Sorting Method
  2. Input file name
  3. Number of values sorted and key data type
  4. Number of Key Compares and Data Moves (each SWAP of two values is counted as 3 data moves)
  5. The time in milliseconds
  6. The first 5 pairs and last 5 pairs
   */

public class Writer<K, V> {

    private static final String FILENAME = "C:\\Users\\Tamar\\Desktop\\p2Results.txt";
    //private static final String FILENAME = "C:\\Users\\tamar\\Desktop\\stuff\\p2Results.txt";

    public void output(String method, String fileType, int valuesSorted, String dataType, int compares, int moves, double time, ArrayList<Entry<K, V>> list) {

        StringBuilder builder = new StringBuilder();
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            builder.append("Sorting method: " + method);
            builder.append("\r\nInput File Name: " + fileType);
            builder.append("\r\nNumber of Values Sorted: " + valuesSorted);
            builder.append("\r\nKey Data Type: " + dataType);
            builder.append("\r\nKey compares: " + compares);
            builder.append("\r\nData Moves: " + moves);
            builder.append("\r\nTime (ms): " + time);
            builder.append("\r\nFirst/last Five Pairs: ");
            builder.append("\r\nFirst 5:\r\n");
            for (int i = 0; i < 5; i++) {
                builder.append(list.get(i).getKey().toString() + "," + list.get(i).getValue().toString() + " ");
            }
            builder.append("\r\nLast 5:\r\n");
            for (int i = list.size() - 5; i < list.size(); i++) {
                builder.append(list.get(i).getKey().toString() + "," + list.get(i).getValue().toString() + " ");
            }
            builder.append("\r\n\r\n");
            fw = new FileWriter(FILENAME,true);
            bw = new BufferedWriter(fw);

            System.out.println(builder.toString());
            bw.write(builder.toString());
        } catch (IOException e) {

            e.printStackTrace();

        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}


