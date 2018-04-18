import java.util.Scanner;
public class test4 {                                                          //19-27：最精妙的一段
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();    //t个样例
        int c[][]=new int [t][3];
        for(int q=0;q<t;q++)
        {                                                                         //二维赋值
            int n=sc.nextInt();//n个整数
            int a[]=new int[n];
            int dp[]=new int[n+100];//以第i个元素结尾的最大
            int start=0,valuestart=0;
            int end=0,valuend=0;
            for(int i=0;i<n;i++)                                              //赋值
            {
                a[i]=sc.nextInt();
            }
            dp[0]=a[0];
            int dpmax=a[0];                                                   //把第一个当作最大值
            for(int i=1;i<n;i++)
            {                                                                   //  从1开始计算？
                end=i;
                dp[i]=max(a[i],dp[i-1]+a[i]);                           //都负a[i]，都正dp[i-1]+a[i]，正负混合←（代码所示）
                if(a[i]>dp[i-1]+a[i]) {start=i;}                           //前面的数<0,就把起始位置放到i处，类似我的最大值之前全部小于0就不管
                if(dp[i]>dpmax) {valuestart=start;valuend=end;dpmax=dp[i];}//一定要有等于号
            }
            c[q][0]=dpmax;
            c[q][1]=1+valuestart;
            c[q][2]=valuend+1;
        }
        for(int i=0;i<t;i++)
        {
            System.out.println("Case"+" "+(i+1)+":");
            System.out.println(c[i][0]+" "+c[i][1]+" "+c[i][2]);
            if(i!=t-1)
                System.out.println();
        }
    }
    private static int max(int i, int j) {
        return i>j?i:j;
    }
}

//↓想法彻底错误：默认了最大值只有1个：案例 100 100 -101 100，应当为200 1 2
//改进方法：寻找最优最大值，但是如果有n个最优，算法复杂度*n（放置循环对每个最大值进行一次前一次后），如此，不如从头开始反正从哪里开始都一样
//但实际上都是类似最大值思路，最大值之前之后变为了，如果sum<0，下一个即作为新起点，如果新起点之后有数之和大于max，新起点即为起点。如果没有，则旧起点为起点
//import java.util.Scanner;
//
//public class test4{
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        while (scan.hasNext()) {                  //boolean
//            int T = scan.nextInt();
//            while (T>=1&&T<=20) {
//                for (int casenum = 1; casenum <= T; casenum++) {
//                    int n = scan.nextInt();
//                    int a[] = new int[n];
//                    int max=-1000;                                //数组最大值
//                    int maxNum=0;                             //数组最大值位置
//                    int sum=0;
//                    int sumMax=-1000;
//                    int start=0;
//                    int end=0;
//
//                    for (int i = 0; i < n; i++) {               //获取最大值，并存到数组中
//                        int now = scan.nextInt();
//                        if (i == 0) {
//                            max = now;
//                        }
//                        if (now >= max) {
//                            max = now;
//                            maxNum = i + 1;
//                        }
//                        a[i] = now;
//                    }
//
//                    int replace = maxNum - 1;
//                    sum = 0;
//                    end=maxNum;
//                    start=maxNum;
//
//                    for (; replace < n; replace++) {         //从最大值往后
//                        sum += a[replace];
//                        if (sum >=sumMax) {sumMax = sum; end=replace+1;}
//                    }
//
//                    replace = maxNum - 1;
//                    sum -= a[replace];
//                    if(sumMax==max){sum=0;}
//
//                    for (; replace >= 0; replace--) {        //从最大值往前
//                        sum += a[replace];
//                        if (sum >= sumMax) {sumMax = sum; start=replace+1;}
//                    }
//                    System.out.print("Case " + casenum + ":");
//                    System.out.println();
//                    System.out.println(sumMax+" "+start+" "+end);
//                    if(casenum!=T)System.out.println();
//                }
//                break;
//            }
//            break;
//        }
//    }
//}
