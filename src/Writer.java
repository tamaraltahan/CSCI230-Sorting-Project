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

public class Writer {

    private static final String FILENAME = "C:\\Users\\Tamar\\Desktop\\p2Results.txt";

    public void output() {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            String content = "This is the content to write into file\n";
            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);
            bw.write(content);

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


