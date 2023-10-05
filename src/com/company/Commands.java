package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class Commands {
    private String[] cmdWithArgs;
    private Queue<String> hist = new LinkedList<>();

    // TODO: hist operations in constructor or in matcher() success cases? Do I even need cmdWithArgs?
    public Commands(){}
//    String[] cmdWithArgs) {
//        this.cmdWithArgs = cmdWithArgs; // set parameter to class var
//        hist.add(cmdWithArgs[]);         // add command and arguments to history queue


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
                    String catted = cat(cmds);
                    System.out.println(catted);
                } catch (FileNotFoundException e) {
                    System.out.println("Usage: cat [TARGET FILE]. File does not exist in directory.");
                }
                break;

            case "pwd":
                System.out.println(pwd());
                break;

            case "history":
                hist.addAll(Arrays.asList(cmds));
                hist.forEach(System.out::println);
                break;
        }
        return null;
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
    public static String cat(String[] files) throws FileNotFoundException {
        // TODO: get relative path to desired file, add it to string provided for target file, pass to fRead
        // TODO: make it read multiple files and separate them by names
        String text = "";
        try {
            for(int i = 1; i < files.length - 1; i++){  // .len - 1; avoid OutOfBounds
                File f = new File(files[i]);    // make object for file
                Scanner fReader = new Scanner(f);   // pass file object to Scanner so it is read
                while (fReader.hasNextLine()) {
                    text = text + (fReader.nextLine());
                }
            }
            return text;
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
            return text;
        }
    }
}
