import java.util.Scanner;
public class test{
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int up = 0;   //进位
        int ma = 0;   //进位后的尾数
        int j = 1;    //case的编号

        while (n > 0) {
            StringBuffer temResult = new StringBuffer();
            up = 0;
            String a = in.next();  //第一个数字
            String b = in.next();  //第二个数字

            //获取a和b的长度
            int al = a.length();
            int bl = b.length();

            al--;
            bl--;
            //从a和b的最低位开始相加
            for(; al >= 0 && bl >= 0; al--, bl--){

                int temp1 = Integer.parseInt(a.charAt(al)+"");
                int temp2 = Integer.parseInt(b.charAt(bl)+"");
                int temp3 = temp1 + temp2 + up;

                if(temp3 >= 10){
                    up = temp3 / 10;
                    ma = temp3 % 10;
                }else{
                    up = 0;
                    ma = temp3;
                }
                temResult.append(ma);
            }

            //两个数位数不一致，第1个数位数长
            while(al >= 0){
                //或去第一个数的下一位数字
                int temp1 = Integer.parseInt(a.charAt(al)+"");
                //加上进位
                int temp3 = temp1 + up;
                //插入结果的下一位
                temResult.append(temp3);
                //将进位设为0
                up = 0;
                al--;
            }
            //两个数位数不一致，第2个数位数长
            while(bl >= 0){
                int temp1 = Integer.parseInt(b.charAt(bl)+"");
                int temp3 = temp1 + up;

                temResult.append(temp3);
                up = 0;
                bl--;
            }
            //两个数位数一样，直接将进位插入结果的下一位
            if(up != 0){
                temResult.append(up);
            }

            //将结果转为正序排列
            int len = temResult.length();
            char[] result = new char[len];
            len--;
            for(int i = 0; len >= 0; i++, len--){
                result[i] = temResult.charAt(len);
            }

            //输出
            System.out.println("Case "+j+":");
            System.out.print(a + " +" + " " + b + " = " +
                    String.valueOf(result));

            if(n != 1){
                System.out.println();
            }
            System.out.println();
            n--;
            j++;
        }
    }
}