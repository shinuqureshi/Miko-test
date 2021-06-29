package com.miko.test.miko.Calculate;

import org.jboss.jandex.Main;

public class Calculation  implements  CalculateInterface{
    Integer result ;

    public static void main(String[] args) {

          CalculateInterface calculateInterface = new Calculation() ;
        System.out.println(calculateInterface.add(10 ,20));
     }

    @Override
    public int add(Integer firstNumber, Integer secondNumber) {
        result = firstNumber + secondNumber ;
        return  result;
    }


}
