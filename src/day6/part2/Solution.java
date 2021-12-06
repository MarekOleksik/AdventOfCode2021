package day6.part2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Solution {
    private static final int DAYS = 256;

    public static void main(String[] args) throws IOException {
        FileInputStream fileReader = new FileInputStream("src\\day6\\part2\\input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fileReader, StandardCharsets.UTF_8));
        String row = br.readLine();
        String[] numbers = row.split(",");
        long[] fishes = new long[9];

        for (String n : numbers) {
            fishes[Integer.parseInt(n)]++;
        }

        long result = getResult(DAYS, fishes);
        System.out.println("result = " + result);
    }

    private static long getResult(int days, long[] fishes) {
        long result = 0;

        for (int i = 0; i < days; i++) {
            long val = fishes[0];
            System.arraycopy(fishes, 1, fishes, 0, fishes.length - 1);
            fishes[8] = val;
            fishes[6] += val;
        }

        result = Arrays.stream(fishes).sum();
        return result;
    }

}
