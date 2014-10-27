package kz.kbtu.epos;

import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;



public class SubtractionTest extends TestCase {

    public void testGetAmount() throws Exception {
        String data = "3000.54\r\n";
        InputStream stdin = System.in;

        try {

            System.setIn(new ByteArrayInputStream(data.getBytes()));
            Scanner scanner = new Scanner(System.in);
            Subtraction test = new Subtraction();
            Double amount = test.getAmount();
            System.out.println(amount);
        } finally {
            System.setIn(stdin);
        }

    }
}