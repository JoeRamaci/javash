package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);    // make Scanner object for input

	    // runtime loop
        while(true){
            System.out.print("javash> ");   // cursor
            String input = in.nextLine();   // save Scanner input!
            String[] cmds = input.split(" ");

            // print another cursor
            if(cmds[0].equals(" ")){
                continue;
            }

            // cmdMatcher handles CLI logic
            Commands cmdMatcher = new Commands();
            cmdMatcher.matcher(cmds);

            // exit
            if(cmds[0].equals("exit")){
                System.out.println("Exiting...");
                System.exit(0);
                break;
            }
        }
        in.close(); // close scanner before Main ends

        // TESTING
//         print results
//        for(String s: cmds){
//            System.out.println(s);
//        }
    }
}
