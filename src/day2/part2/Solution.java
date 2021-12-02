package day2.part2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileReader = new FileInputStream("src\\day2\\part2\\input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fileReader, StandardCharsets.UTF_8));
        ArrayList<String> list = new ArrayList<>();
        String row;
        int horizontal = 0;
        int vertical = 0;
        int target = 0;
        int result;

        while ((row = br.readLine()) != null) {
            list.add(row);
        }

        for (String s : list) {
            String[] partsOfRow = s.split(" ");
            int step = Integer.parseInt(partsOfRow[1]);
            switch (partsOfRow[0]) {
                case "forward" -> {
                    vertical += step;
                    horizontal += target * step;
                }
                case "down" -> target += step;
                case "up" -> target -= step;
            }
        }

        result = horizontal * vertical;
        System.out.println("result = " + result);
    }
}
