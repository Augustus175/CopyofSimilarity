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
//        Data data = new Data("E:\\高铁项目\\时间序列\\data.csv");
        //double beginTime1 = (double)System.currentTimeMillis();
        String datacode = Code.code(data.getsingleList());
        System.out.println("编码用时：" + ((double)System.currentTimeMillis() - beginTime) + "ms");
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
        System.out.println("检索到" + qu1.getCount() + "个相似模式");
        //double endTime = (double)System.currentTimeMillis();
        //System.out.println("检索耗时：" + (endTime - beginTime2)  + "ms");
        //double begin = (double)System.currentTimeMillis();

        for(int begin1 = 0; begin1 < qu1.indexCode.size(); ++begin1) {
            System.out.println("模式" + (begin1 + 1) + "：" +(data.dataString.get((qu1.indexCode.get(begin1)))[0] + 
            		"-->" + data.dataString.get((qu1.indexCode.get(begin1))+ pattern.length())[0] +
            		"   相似度：" + Query.similarityList.get(begin1)));
        }
        System.out.println("查询耗时：" + ((double)System.currentTimeMillis() - beginTime2) + "ms");
        long a = System.currentTimeMillis();
        if(!patternlist.isEmpty() && patternlist.size() <= 60) {
            XYplot.plot(da, patternlist);
        }

        System.out.println("画图耗时1：" + (System.currentTimeMillis() - a) + "ms");
    }
}
