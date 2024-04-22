import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Permission;
import java.util.Scanner;
import java.util.*;
import java.security.*;

public class Bai11 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        bufferedReader.close();

        // Convert n to string
        String strN = Integer.toString(n);

        // Check if n is successfully converted into a string
        if (strN != null) {
            System.out.println("Good job");
        } else {
            System.out.println("Wrong answer");
        }
    }
}
