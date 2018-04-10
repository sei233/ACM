import java.util.Scanner;

public class test3 {
    static int up=0;     //进位
    static int ma;     //余位
    static StringBuffer temResult = new StringBuffer();
    static StringBuffer Result = new StringBuffer();
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);       //使用Scanner
        String a,b;                                    //int 一定比2147483647小，比-2147483648大
        while(scan.hasNext()) {                  //boolean
            int n = scan.nextInt();
            while (n>=1&&n<=20) {                 //1<=T<=20
                //int len = length(n);
                int casenum=n;                           //防止少输出case
                for (int i = 1; i <= casenum; i++) {
                    a = scan.next();                      //nextInt()下一个输入的整数型
                    b = scan.next();
                    sum(a,b);                             // 相加
                    reverse(temResult);                   //反转
                    System.out.print("Case " + i + ":");
                    System.out.println();
                    System.out.println("" + a + " + " + b + " = "+String.valueOf(Result));
                    if(n!=1)System.out.println();
                    temResult.setLength(0);
                    Result.setLength(0);
                    n--;   //使其可以结束
                }
                break;
            }
            break;
        }
    }

    static void sum(String a,String b){
        int al=a.length();
        int bl=b.length();
        al--;
        bl--;
        for (;al>=0&&bl>=0;al--,bl--) {
            int temp1 = Integer.parseInt(String.valueOf(a.charAt(al)));   //char转string再转int
            int temp2 = Integer.parseInt(String.valueOf(b.charAt(bl)));
            int temp3=temp1+temp2+up;
            if(temp3>=10){
                up=temp3/10;
                ma=temp3%10;
            }else{
                up=0;
                ma=temp3%10;
            }
            temResult.append(ma);
        }
        while(al>=0){
            int temp1 = Integer.parseInt(String.valueOf(a.charAt(al)));
            int temp3=temp1+up;
            if(temp3>=10){
                up=temp3/10;
                ma=temp3%10;
            }else{
                up=0;
                ma=temp3%10;
            }
            temResult.append(ma);
            al--;
        }
        while(bl>=0){
            int temp2 = Integer.parseInt(String.valueOf(b.charAt(bl)));
            int temp3=temp2+up;
            if(temp3>=10){
                up=temp3/10;
                ma=temp3%10;
            }else{
                up=0;
                ma=temp3%10;
            }
            temResult.append(ma);
            bl--;
        }
        if(up>0){
            temResult.append(up);
        }
        up=0;
    }   //计算，并成为倒序

    static void reverse(StringBuffer str){
        for (int i=str.length()-1;i>=0;i--) {
            int temp= Integer.parseInt(String.valueOf(str.charAt(i)));   //char转string再转int
            Result.append(temp);
        }
    }
}
