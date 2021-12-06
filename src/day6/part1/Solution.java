package day6.part1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final int DAYS = 80;

    public static void main(String[] args) throws IOException {
        FileInputStream fileReader = new FileInputStream("src\\day6\\part1\\input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fileReader, StandardCharsets.UTF_8));
        String row = br.readLine();
        String[] numbers = row.split(",");
        List<Integer> listOfLanternfish = new ArrayList<>();

        for (String n : numbers) {
            listOfLanternfish.add(Integer.parseInt(n));
        }

        int result = getResult(DAYS, listOfLanternfish);
        System.out.println("result = " + result);
    }

    private static int getResult(int days, List<Integer> list) {
        int result = 0;
        List<Integer> listForResult = new ArrayList<>(list);

        for (int i = 0; i < days; i++) {
            for (int j = 0; j < listForResult.size(); j++) {
                if (listForResult.get(j) > 0) {
                    listForResult.set(j, listForResult.get(j) - 1);
                } else if (listForResult.get(j) == 0) {
                    listForResult.add(9);
                    listForResult.set(j, 6);
                }
            }
        }

        result = listForResult.size();
        return result;
    }

}
