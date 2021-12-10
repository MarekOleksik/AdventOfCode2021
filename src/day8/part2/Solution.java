package day8.part2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> listOfRows = getRows();
        System.out.println("result = " + getResult(listOfRows));
    }

    private static List<String> getRows() throws IOException {
        FileInputStream fileReader = new FileInputStream("src\\day8\\part2\\input.txt");
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
        for (String row : list) {
            String[] partOfRow = row.split("[|]");
            String[] stringsOfNumbers = partOfRow[1].strip().split(" ");
            List<Integer> numbers = new LinkedList<>();
//TODO case 5 and 6
            for (String s : stringsOfNumbers) {
                System.out.println("s = " + s);
                switch (s.length()) {
                    case 2 -> numbers.add(1);
                    case 3 -> numbers.add(7);
                    case 4 -> numbers.add(4);
                    case 7 -> numbers.add(8);
                    case 6 -> {
                        if (s.contains("a")&& s.contains("g")) numbers.add(0);
                        else if (s.contains("f")&& s.contains("g")) numbers.add(6);
                        else if (s.contains("a")&& s.contains("f")) numbers.add(9);
                    }
                    case 5 -> {
                        if (s.contains("a")&& s.contains("g")) numbers.add(2);
                        else if (s.contains("a")&& s.contains("b")) numbers.add(3);
                        else if (s.contains("b")&& s.contains("e")) numbers.add(5);
                    }
                }
            }
            System.out.println("numbers = " + numbers);
        }
        return sumOfNumbers;
    }
}
