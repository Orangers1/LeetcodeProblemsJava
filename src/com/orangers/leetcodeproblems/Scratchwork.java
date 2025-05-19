package com.orangers.leetcodeproblems;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Scratchwork {

    // code to write a file that is just a bunch of minecraft function calls - wrote for a friend one day.
//    public static void main(String[] args) {
//
//        File output = new File(args[0]);
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
//            int score = 2;
//
//            for (int i = 0; i < 2608; i += 4) {
//                if (i == 4) {
//                    score -= 2;
//                }
//                int movieIndex = i / 4;
//                String folder = String.format("%03d", movieIndex);
//
//                for (int j = 0; j < 4; j++) {
//                    String suffix = (j == 0) ? "" : Integer.toString(j - 1);
//                    String functionName = "mural" + suffix;
//                    writer.write(String.format(
//                            "execute as @s[scores={play_movie=%d}] run function wlmt:images/minecraft_movie_trailer/%s/data/mm/functions/%s\n",
//                            score, folder, functionName));
//                    score++;
//                }
//                score += 11;
//                writer.write("\n");
//            }
//            System.out.println("File written to: " + output.getAbsolutePath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
