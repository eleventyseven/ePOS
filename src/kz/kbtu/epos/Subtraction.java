package kz.kbtu.epos;

import java.io.BufferedReader;
import java.io.InputStreamReader;


class Subtraction {
    public Double getAmount() throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the amount of the order: ");
        double amount = Double.parseDouble(reader.readLine());
        return amount;
    }
}