package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class Commands {
    private String[] cmdsPlusArgs;
    private Queue<String> hist = new LinkedList<>();

    // TODO: hist operations in constructor. Constructor will be called outside while loop
    public Commands(String[] cmds){}
        this.cmds = cmdsPlusArgs;
//        this.cmdWithArgs = cmdWithArgs; // set parameter to class var
        hist.add(cmds[]);         // add command and arguments to history queue


        /**
         * Handles logic of choosing commands.
         * Switch case that takes entire CLI input as array. Chooses command to run based on cmds[0]. Args to command will
         * be in the indices that follow.
         *
         * @param cmds A String array where each CLI input is an index. Args[0] is the first command, followed by arguments.
         */
    public String matcher(String[] cmds) {
        // TODO: figure out pipes after commands are done. They take returned val of previous statement, and pass as param to next
        switch (cmds[0]) {
            case "cat":
                try {
                    System.out.println("SWITCH 1");
                    String catted = cat(cmds);
                    System.out.println("SWITCH 2");
//                    System.out.println(catted);
                    return catted;
//                    System.out.println("SWITCH 3");
                } catch (FileNotFoundException e) {
                    System.out.println("Usage: cat [TARGET FILE]. File does not exist in directory.");
                }
                break;

            case "pwd":
//                System.out.println(pwd());
                return pwd();
//                break;

            case "history":
                hist.addAll(Arrays.asList(cmds));
                hist.forEach(System.out::println);
                break;
            default:
                return "Invalid command.";
        }
//        TODO: bypass a return here? or make it return nothing to stdout?
        return null;
    }

    public void cd(){
        System.setProperty("user.dir", cmds[1]);
    }

    /**
     * Returns the current directory.
     */
    public static String pwd() {
        // TODO: find a way to get down to company directory? But Prof's version doesn't do that?
        return System.getProperty("user.dir");
    }

    /**
     * Returns entire contents of a file. Accepts multiple files, and separates them by name.
     *
     * @param files Array of files to be printed. Files should be in indices files[1] and higher.
     */
    // TODO: why tf doesnt it work? is it in cat()? matcher()? main? wtf???
    public static String cat(String[] files) throws FileNotFoundException {
        // TODO: get relative path to desired file, add it to string provided for target file, pass to fRead
        // TODO: make it read multiple files and separate them by names
        String text = "";
        try {
            for(int i = 1; i < files.length - 1; i++){  // .len - 1; avoid OutOfBounds
                System.out.println("1" + i);
                File f = new File(files[i]);    // make object for file
                System.out.println("2" + i);
                Scanner fReader = new Scanner(f);   // pass file object to Scanner so it is read
                System.out.println("3" + i);
                while (fReader.hasNextLine()) {
                    System.out.println("WHILE" + i + fReader.nextLine());
                    text = text + fReader.nextLine();
                }
            }
            return text;
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
            return text;
        }
    }
}
