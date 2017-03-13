package similarity;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import similarity.Code;
import similarity.Data;
import similarity.Query;
import similarity.XYplot;

public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        double beginTime = (double)System.currentTimeMillis();
        Data data = new Data("E:" + File.separator + "data2.csv");
//        Data data = new Data("E:\\������Ŀ\\ʱ������\\data.csv");
        //double beginTime1 = (double)System.currentTimeMillis();
        String datacode = Code.code(data.getsingleList());
        System.out.println("������ʱ��" + ((double)System.currentTimeMillis() - beginTime) + "ms");
        Integer[] da = new Integer[]{33,34,34,34,34,33,32,31};
        //new ArrayList();
        List<Integer> datapn = Arrays.asList(da);
        String pattern = Code.code(datapn);
        double beginTime2 = (double)System.currentTimeMillis();
        Query qu1 = new Query();
        StringBuffer buff = new StringBuffer();
        buff.append(datacode);
        //new ArrayList();
        ArrayList<List<Integer>> patternlist = qu1.sQuery(buff, pattern, 0.9);
        System.out.println("������" + qu1.getCount() + "������ģʽ");
        //double endTime = (double)System.currentTimeMillis();
        //System.out.println("������ʱ��" + (endTime - beginTime2)  + "ms");
        //double begin = (double)System.currentTimeMillis();

        for(int begin1 = 0; begin1 < qu1.indexCode.size(); ++begin1) {
            System.out.println("ģʽ" + (begin1 + 1) + "��" +(data.dataString.get((qu1.indexCode.get(begin1)))[0] + 
            		"-->" + data.dataString.get((qu1.indexCode.get(begin1))+ pattern.length())[0] +
            		"   ���ƶȣ�" + Query.similarityList.get(begin1)));
        }
        System.out.println("��ѯ��ʱ��" + ((double)System.currentTimeMillis() - beginTime2) + "ms");
        long a = System.currentTimeMillis();
        if(!patternlist.isEmpty() && patternlist.size() <= 60) {
            XYplot.plot(da, patternlist);
        }

        System.out.println("��ͼ��ʱ1��" + (System.currentTimeMillis() - a) + "ms");
    }
}
