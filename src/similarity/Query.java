package similarity;

import java.util.ArrayList;
import java.util.List;

import similarity.Data;
import similarity.Edit;

public class Query {
    private int count = 0;
    //    private int i = 0;//ÿ��ƥ���ģʽ�������ֵ
    public ArrayList<Integer> indexCode = new ArrayList<Integer>();
    public ArrayList<List<Integer>> patternList = new ArrayList<List<Integer>>();
    public static ArrayList<Float> similarityList;

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Integer> getIndexCode() {
        return this.indexCode;
    }

    public void setIndexCode(ArrayList<Integer> indexCode) {
        this.indexCode = indexCode;
    }

    public Query() {
        similarityList = new ArrayList<Float>();
    }

    /**
     * ����õ��ĵ�ģʽǰһλ�����һλ��ƥ��
     */
    public ArrayList<List<Integer>> sQuery(StringBuffer str1, String pattern, double similarity) {


        int i = 0;
        while (i <= str1.length() - pattern.length()) {
            if ((i = str1.indexOf("0002", i)) != -1) {
                if (i >= 1) {
                    float b = 0.0F;
                    b = Edit.editdistance(pattern, str1.substring(i - 1, i - 1 + pattern.length()));
                    if ((double) b >= similarity) {
                        //this.indexCode.add(Integer.valueOf(this.count));
                        this.indexCode.add(i - 1);

                        //this.patternList.add(Data.dataSeries.subList(this.count, this.count + pattern.length() + 1));
                        this.patternList.add(Data.dataSeries.subList(i - 1, i + pattern.length()));//Ԫ���ݱ����ݵı����һλi-1+1=i
                        //++i;
                        similarityList.add(Float.valueOf(b));
                        ++count;
                    }
                    i++;
                    //System.out.println(pattern.length());
                } else {
                    i++;
                    continue;
                }
            } else {
                break;
            }
        }

        //System.out.println("������ʱ��" + (System.currentTimeMillis() - begin) + "ms");
        return this.patternList;
    }
}
