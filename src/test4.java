import java.util.Scanner;

public class test4{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int max=-1000;                                //数组最大值
        int maxNum=0;                             //数组最大值位置
        int sum=0;
        int sumMax=-1000;
        int point;
        while (scan.hasNext()) {                  //boolean
            int T = scan.nextInt();
            while (T>=1&&T<=20) {
                int n=scan.nextInt();
                int a[]=new int[n];

                for(int i=0;i<n;i++){               //获取最大值，并存到数组中
                    int now=scan.nextInt();
                    if (i==0){max=now;}
                    if(now>=max){
                        max=now;
                    maxNum=i+1;}
                    a[i]=now;
                }

                int replace=maxNum-1;
                sum=0;
                for (;replace<n;replace++){
                    sum+=a[replace];
                    if(sum>sumMax)sumMax=sum;
                }

                replace=maxNum-1;
                sum=0;
                for (;replace>=0;replace--){
                    sum+=a[replace];
                    if(sum>sumMax)sumMax=sum;
                }

                System.out.println(sumMax);
                break;
            }
            break;
        }
    }
}
