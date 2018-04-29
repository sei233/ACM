import java.util.Scanner;

public class test6{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b;
        int n;
        while (in.hasNext()) {
            a = in.nextInt();
            b = in.nextInt();
            n = in.nextInt();
            // 1 <= A, B <= 1000, 1 <= n <= 100,000,000
            if (a < 1 & a > 1000 & b < 1 & b > 1000 & b < 1 & a > 100000000)
                System.exit(0);
            if (a == 0 & b == 0 & n == 0)
                System.exit(0);
            int f[] = new int[50];
            for (int i = 1; i < 50; i++) {
                if (i == 1 || i == 2) {
                    f[i] = 1;
                } else {
                    f[i] = (a * f[i - 1] + b * f[i - 2]) % 7;
                }
            }
            System.out.println(f[n % 49]);   //模7{0，1，2，3，4，5，6}最多49循环一周，防止n过大
        }
        in.close();
    }
}
//空间、执行时间超时，毕竟是递归
//import java.util.Scanner;
//
//public class test6 {
//    static int A;
//    static int B;
//    static int n;
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        while (sc.hasNext()) {
//            A=sc.nextInt();
//            B=sc.nextInt();
//            n=sc.nextInt();
//            if((A!=0&&B!=0&&n!=0)||(n<=100000000&&n>=1)) {
//                System.out.println(f(n));
//            }else{
//                break;
//            }
//        }
//    }
//
//    static int f(int a){
//        if(a==1 || a==2) return 1;
//        return (A*f(a-1)+B*f(a-2))%7;
//    }
//}
