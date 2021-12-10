package day7.part1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> positions = getPositions();
        System.out.println("result = " + getResult(positions));
    }

    private static List<Integer> getPositions() throws IOException {
        FileInputStream fileReader = new FileInputStream("src\\day7\\part1\\input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fileReader, StandardCharsets.UTF_8));
        String row = br.readLine();
        String[] numbers = row.split(",");
        List<Integer> positions = new ArrayList<>();

        for (String n : numbers) {
            positions.add(Integer.parseInt(n));
        }
        return positions;
    }

    private static int getResult(List<Integer> list) {
        Collections.sort(list);
        int maxPosition = list.get(list.size() - 1);
        List<Integer> fuels = new ArrayList<>();

        for (int position = 0; position < maxPosition; position++) {
            int fuel = 0;
            for (Integer integer : list) {
                fuel += Math.abs(position - integer);
            }

            fuels.add(fuel);
        }
        Collections.sort(fuels);

        return fuels.get(0);
    }
}
