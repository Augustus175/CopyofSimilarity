package similarity;

import java.util.List;

public class Code {
    public Code() {
    }

    public static String code(List<Integer> data) {
        StringBuffer str = new StringBuffer();
        if(data != null) {
            for(int j = 1; j < data.size(); ++j) {
                if(((Integer)data.get(j - 1)).intValue() < ((Integer)data.get(j)).intValue()) {
                    str.append("1");
                } else if(data.get(j - 1) == data.get(j)) {
                    str.append("0");
                } else {
                    str.append("2");
                }
            }

            return str.toString();
        } else {
            return "没有数据";
        }
    }
}
