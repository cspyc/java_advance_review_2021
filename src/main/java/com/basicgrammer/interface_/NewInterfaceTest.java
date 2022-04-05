package com.basicgrammer.interface_;

import java.util.concurrent.locks.Lock;

/**
 * @author Pi
 * @date 2021-04-26 11:06
 */
public class NewInterfaceTest {
   private A[] aArray;
   private void initial(){
      aArray = new A[10];
   }
   public static void main(String[] args) {
   }
}

interface A {
   void add();
}

interface B extends A{

}
