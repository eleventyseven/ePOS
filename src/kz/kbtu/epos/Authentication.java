package kz.kbtu.epos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.Scanner;

public class Authentication {
    public Long getInfo() throws Exception {
        System.out.println("Welcome to ePOS");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Swipe the card on the card reader: ");
        Long cid = Long.parseLong(reader.readLine());
        //System.out.println("Enter the amount of the order: ");

        //int amount = Integer.parseInt(reader.readLine());
        return cid;


    }


}



class Test {
    public static void main(String[] args) throws Exception{
        String data = "4863900811416188\r\n";
        InputStream stdin = System.in;

        try {

            System.setIn(new ByteArrayInputStream(data.getBytes()));
            Scanner scanner = new Scanner(System.in);
            Authentication test = new Authentication();
            Long cid = test.getInfo();
            System.out.println(cid);
        } finally {
            System.setIn(stdin);
        }
    }
}



/*class AuthenticationTest {
    public static void main(String[] args)throws Exception{
        Authentication test1 = new Authentication();
        Long cid = test1.getInfo();
        Subtraction test2 = new Subtraction();
        int amount = test2.getAmount();
        ConnectToDB dao = new ConnectToDB();
        double account = dao.readDataBase(cid,amount);
        //System.out.println(account);
    }
} */