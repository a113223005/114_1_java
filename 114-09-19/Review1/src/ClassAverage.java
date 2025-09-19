import java.util.Scanner;

public class ClassAverage {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int total = 0; //總分
        int gradesCounter = 0; //成績計數器

        System.out.println("輸入完成請按ctrl-z (Windows) 或 ctrl-d (Mac/Linux) 結束輸入");

        while(input.hasNext()){
            if(input.hasNextInt()){
                int grade = input.nextInt(); //讀取成績
                total += grade; //累加總分
                gradeCounter++; //成績計數器加1
            } else {
                System.out.println("輸入錯誤，請輸入整數成績！");
                input.next(); //跳過錯誤輸入
            }
        }

        if(gradeCounter != 0){
            double average = (double) total / gradeCounter; //計算平均
            System.out.printf("總分: %d%n", total); //printf可用%n表示換行
            System.out.printf("成績數: %d%n", gradeCounter);
            System.out.printf("平均: %.2f%n", average);
        } else {
            System.out.println("沒有輸入任何成績");
        }
    }
}
