import java.util.Scanner;

public class test5 {

    public static void main(String[] args) {                       //wa主要原因为输入不规范,其次nextLine（）有点小问题
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {                                     //，4+Enter，“”会作为save[0]
            int t=Integer.parseInt(sc.nextLine());                     //即这行使用int t=sc.nextInt();输入方式为3 red
            int max = 1;                                           //                                      red
            String popular=" ";                                    //                                      red
            while (t!=0){                                         //                                与题目不符
                String save[] = new String[t];
                for (int i = 0; i < t; i++) {
                    String scan = sc.nextLine();
                    if(i==0)popular=scan;
                    int num = 1;
                    for (int j = i - 1; j >= 0; j--) {
                        if (scan.equals(save[j])) num++;
                        if (num > max){
                            max = num;
                            popular=scan;
                        }
                    }
                    save[i] = scan;
                }
                System.out.println(popular);
                break;
            }
            if (t==0)break;
        }
    }
}

//类似下面思路更清晰点
//import java.util.ArrayList;
//        import java.util.Scanner;
//
//public class t {
//
//    public static void main(String args[]){
//        Scanner s=new Scanner(System.in);
//        int n;
//        while((n=Integer.parseInt(s.nextLine()))!=0){
//            ArrayList<String> color=new ArrayList<String>();   //存放各种颜色以及颜色出现次数得表
//            int number[]=new int[100];
//            int k=0;
//            for(int i=0;i<n;i++){
//                String str=s.nextLine();
//                int judge=color.indexOf(str);
//                if(judge!=-1)
//                    number[judge]++;
//                else{
//                    color.add(k,str);
//                    number[k]++;
//                    k++;
//                }
//            }
//            int max=0,maxIndex=0;
//            for(int i=0;i<k;i++){
//                if(max<number[i]){
//                    max=number[i];
//                    maxIndex=i;
//                }
//            }
//            System.out.println(color.get(maxIndex));
//        }
//    }
//}