package com.basicgrammer.poly_parameter;

/**
 * @author pi
 * @date 2021/03/24 16:53:02
 **/
public class PloyParameter {
    public static void main(String[] args) {

        Employee tom = new Worker("Tom",2000);
        Employee king = new Manager("King",3000,20000);

        PloyParameter p = new PloyParameter();
        p.showEmpAnnual(tom);
        p.showEmpAnnual(king);

        p.testWork(tom);
        p.testWork(king);

    }

    public void showEmpAnnual(Employee e) {
        //动态绑定
        System.out.println(e.getAnnual());
    }

    public void testWork(Employee e) {
        if(e instanceof Worker){
            ((Worker)e).work();
        }else if(e instanceof  Manager){
            ((Manager)e).manage();
        }
    }


}
