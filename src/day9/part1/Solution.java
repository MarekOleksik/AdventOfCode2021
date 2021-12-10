package day9.part1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> listOfRows = getRows();
        System.out.println("result = " + getResult(listOfRows));
    }

    private static List<String> getRows() throws IOException {
        FileInputStream fileReader = new FileInputStream("src\\day9\\part1\\input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fileReader, StandardCharsets.UTF_8));
        ArrayList<String> list = new ArrayList<>();
        String row;

        while ((row = br.readLine()) != null) {
            list.add(row);
        }
        return list;
    }

    private static int getResult(List<String> list) {
        int sumOfNumbers = 0;
        int[][] arrayOfNumbers = new int[list.size()][list.get(0).length()];
        List<Integer> lowNumbers = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String[] partOfRow = list.get(i).split("");
            for (int j = 0; j < partOfRow.length; j++) {
                arrayOfNumbers[i][j] = Integer.parseInt(partOfRow[j]);
            }
        }
        int up = 0, down = 0, left = 0, right = 0;
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            for (int j = 0; j < arrayOfNumbers[i].length; j++) {
                int num = arrayOfNumbers[i][j];


                if (j == 0) {
                    left = 9;
                    right = arrayOfNumbers[i][j+1];
                }
                if (i == 0) {
                    up = 9;
                    down = arrayOfNumbers[i+1][j];
                }
                if (j == arrayOfNumbers[i].length) right = 9;
                if (i == arrayOfNumbers.length) down = 9;
                if (j > 0 && j < arrayOfNumbers[i].length) {
                    left = arrayOfNumbers[i][j-1];
                    right = arrayOfNumbers[i][j+1];
                }
                if (i > 0 && i < arrayOfNumbers.length) {
                    up = arrayOfNumbers[i-1][j];
                    down = arrayOfNumbers[i+1][j];
                }
                System.out.println("up: " + up + ", down: " + down + ", left: " + left + ", right: " + right) ;
            }

            System.out.println();
        }
        return sumOfNumbers;
    }
}
