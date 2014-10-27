package kz.kbtu.epos;

import junit.framework.TestCase;
import java.io.*;
import java.util.Scanner;

public class AuthenticationTest extends TestCase {

    public void testGetInfo() throws Exception {
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