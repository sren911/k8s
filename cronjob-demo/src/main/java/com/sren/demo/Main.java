package com.sren.demo;

import java.util.Random;

/**
 * @author: renshuai
 * @date: 2019/10/31 下午1:32
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        Random r = new Random();
        int time = r.nextInt(20) + 10;
        System.out.println("I will working for " + time + " seconds");

        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All work is done! Bye!");
    }
}
