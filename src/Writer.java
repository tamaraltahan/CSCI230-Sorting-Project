import java.io.*;
import java.util.ArrayList;

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


