package com.basicgrammer.base;

public class VarParameterExercise{
    public static void main(String[] args){
        //需求：有三个方法，分别实现返回姓名和两门课程成绩(总分)，返回姓名和三门课成绩(总分)，返回姓名和五门课成绩(总分)。封装一个可变参数的方法
        //类名HspMethod 方法名 showScore
    
        HspMethod t = new HspMethod();
        HspMethod t1 =  t.showScore("王一",67,55);
        System.out.println(t1.toString());

        HspMethod t2 = t.showScore("李三", 70,80,90);
        System.out.println(t2.toString());

        HspMethod t3 = t.showScore("王二",10,10,10,10,10);
        System.out.println(t3.toString());
    }
}

class HspMethod {
    private String name;
    private int totalScore;

   
    public String getName() {
        return this.name;
    }

    public int getTotalScore(){
        return this.totalScore;
    }

    public HspMethod showScore(String name,int... sores){
        HspMethod hsp = new HspMethod();
        hsp.name = name;
        
        for(int i = 0;i < sores.length;i++){
            hsp.totalScore += sores[i];
        }
        return hsp;
    } 

    @Override
    public String toString(){
        return this.getName() + " 的考试总分为： " + this.getTotalScore();
    }
}