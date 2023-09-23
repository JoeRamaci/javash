package com.company;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);    // make Scanner object for input
        String[] cmds;

	    // runtime loop
        while(true){
            System.out.print("javash> ");
            String input = in.nextLine();   // save Scanner input!
            cmds = input.split(" ");

            // exit shell
            if(cmds[0].equals("exit")){
                in.close(); // close scanner before Main ends
                System.out.println("Exiting...");
                System.exit(0);
            }
        }

        // TESTING
        // print results
//        for(String s: cmds){
//            System.out.println(s);
//        }
    }
}
