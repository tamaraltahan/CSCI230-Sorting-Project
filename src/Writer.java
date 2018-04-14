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

    public void output(String method, String fileType, int valuesSorted, String dataType, int compares, int moves, double time, ArrayList<Entry<K, V>> list) {

        StringBuilder builder = new StringBuilder();
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            builder.append("Sorting method: " + method);
            builder.append("\nInput File Name: " + fileType);
            builder.append("\nNumber of Values Sorted: " + valuesSorted);
            builder.append("\nKey Data Type: " + dataType);
            builder.append("\nKey compares: " + compares);
            builder.append("\nData Moves: " + moves);
            builder.append("\nTime (ms): " + time);
            builder.append("\nFirst/last Five Pairs: ");
            builder.append("\nFirst 5:\n");
            for (int i = 0; i < 5; i++) {
                builder.append(list.get(i).getKey().toString() + "," + list.get(i).getValue().toString() + " ");
            }
            builder.append("\nLast 5:\n");
            for (int i = list.size() - 5; i < list.size(); i++) {
                builder.append(list.get(i).getKey().toString() + "," + list.get(i).getValue().toString() + " ");
            }
            builder.append('\n');

            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);

            System.out.println(builder.toString());
            bw.write(builder.toString());
            System.out.println("Done");

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


