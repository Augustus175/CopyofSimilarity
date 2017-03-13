package similarity;

public class Edit {
    public Edit() {
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String a = "111101010101";
        String b = "010101010101";

        for(int i = 0; i < 1500000; ++i) {
            editdistance(a, b);
        }

        System.out.println(editdistance(a, b));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public static float editdistance(String str1,String str2) {
		//���������ַ����ĳ���
	   int  len1 = str1.length();//m
		int len2 = str2.length();//n
		//�������飬(m+1)*(n+1)ά
		int[][] edit = new int[len1 + 1][len2 + 1];
		//����ֵ������B��
		for (int i = 0; i <= len1; i++) {
			edit[i][0] = i;
		}
		for (int j = 0; j <= len2; j++) {
			edit[0][j] = j;
		}
		//���������ַ��Ƿ�һ�����������ϵ�ֵ
		int temp;
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					temp = 0;
				} else {
					temp = 1;
				}
				//ȡ����ֵ����С��
				//dif[i][j] = min(dif[i - 1][j - 1] + temp, dif[i][j - 1] + 1,
						//dif[i - 1][j] + 1);
				edit[i][j]=Math.min(edit[i - 1][j - 1] + temp, Math.min(edit[i][j - 1] + 1, edit[i - 1][j] + 1));
			}
		}
		//System.out.println("�ַ���\""+str1+"\"��\""+str2+"\"�ıȽ�");
		//ȡ�������½ǵ�ֵ��ͬ����ͬλ�ô���ͬ�ַ����ıȽ�
		//System.out.println("��С�༭���룺"+edit[len1][len2]);
		//�������ƶ�
		float similarity =1.0F - (float) edit[len1][len2] / Math.max(str1.length(), str2.length());
		//System.out.println("���ƶȣ�"+similarity);
		return similarity;
	}
}
