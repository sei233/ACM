import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int n = scan.nextInt();
            int sum;
            if(n%2==0) sum=n/2*(n+1);
            else
            sum=(n+1)/2*n;

            System.out.println(sum);
            System.out.println();
        }
    }
}

//结果一样上面错，下面对，不知道为啥,n*(n+1)虽然(n*n+1)/2的值能在 32 位 signed int下存放 但对于 n*(n+1)却不一定，所以需要对计算的 顺序进行些许改变
//现在上面对了，上下都能交

//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int n = sc.nextInt();
//            int sum = 0;
//            for(int i = 1; i<=n;i++){
//                sum+=i;
//            }
//            System.out.println(sum);
//            System.out.println();
//        }
//    }
//
//}
