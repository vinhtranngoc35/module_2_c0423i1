package ultil;

import java.util.Scanner;

public class GetValue {
    static Scanner scanner = new Scanner(System.in);
    public static String getString(String str){
        System.out.println(str);
        return scanner.nextLine();
    }

    public static int getInt(String str){
        System.out.println(str);
       // logic validate de lay duoc int
        return 0;
    }
}
