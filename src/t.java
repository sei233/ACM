import java.util.Scanner;

public class t{

    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int T=s.nextInt();
        for(int i=0;i<T;i++){
            int n=s.nextInt();
            int sum=0,max=-1001;
            int start=0,end=0,z=0;
            for(int j=0;j<n;j++){
                int a=s.nextInt();
                sum=sum+a;
                if(max<sum){     //先获得第一个值              都负sum不停变0再变值，直到获得最大值
                    max=sum;                                //都正sum不断的变大，再赋给max
                    end=j;                                  //正负混杂，sum比0小，说明如果下一个点作为起点，前面的都可以舍去
                    start=z;
                }
                if(sum<0){      //与a[i]>dp[i-1]+a[i]类似，即dp[i]是负的,那么下一个必然是新起点（start，not valuestart）
                    sum=0;      //一旦sum=0，下一个必然是起点必然是max
                    z=j+1;
                }
            }
            System.out.println("Case "+(i+1)+":");
            System.out.println(max+" "+(start+1)+" "+(end+1));
            if(i<T-1)
                System.out.println();
        }
    }
}