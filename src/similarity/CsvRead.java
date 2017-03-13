package similarity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvRead {
    //private ArrayList<String> arr = new ArrayList();

    public CsvRead() {
    }

    public static ArrayList<String> read(File file) {
        ArrayList<String> arr = new ArrayList<String >();
       // Object re = null;
        BufferedReader br = null;
        long begin1 = System.currentTimeMillis();
        //int i = 0;

        try {
            br = new BufferedReader(new FileReader(file));
            String a;
            while( (a= br.readLine()) != null){
                arr.add(a);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("bufferreaderºÄÊ±£º" + (System.currentTimeMillis() - begin1) + "ms");
        return arr;
    }

    public static void main(String[] args) {
    }
}
