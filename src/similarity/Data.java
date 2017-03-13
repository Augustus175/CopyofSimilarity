package similarity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import similarity.CsvRead;

public class Data {
    public List<String[]> dataString;
    public static List<Integer> dataSeries;
    public File datafile;

    public Data(String filepath) {
        this.datafile = new File(filepath);
        this.dataString = new ArrayList<String []>();
        dataSeries = new ArrayList<Integer>();
    }

    public List<Integer> getDataSeries() {
        return dataSeries;
    }

    public void setDataSeries(List<Integer> dataSeries) {
        Data.dataSeries = dataSeries;
    }

    public List<Integer> getsingleList() {
        ArrayList<String > ar = CsvRead.read(this.datafile);
        System.out.println("读取到" + ar.size() + "个数据点");

        int i;
        for(i = 0; i < ar.size(); ++i) {
            this.dataString.add(new String[]{((String)ar.get(i)).split(",")[0], ((String)ar.get(i)).split(",")[1]});
        }

        for(i = 0; i < this.dataString.size(); ++i) {
            dataSeries.add(Integer.valueOf(Integer.parseInt(((String[])this.dataString.get(i))[1])));
        }

        return dataSeries;
    }
}
