import java.util.Scanner;

public class test1 {                               //提交的时候，把类名改成Main
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);       //使用Scanner
        int a,b;
        while(scan.hasNextInt()){                  //boolean
            a=scan.nextInt();                      //nextInt()下一个输入的整数型
            b=scan.nextInt();
            System.out.println(a+b);
        }
    }
}
