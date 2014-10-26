package kz.kbtu.epos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Corey on 26.10.2014.
 */
class Subtraction {
    public Integer getAmount() throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the amount of the order: ");
        int amount = Integer.parseInt(reader.readLine());
        return amount;
    }
}