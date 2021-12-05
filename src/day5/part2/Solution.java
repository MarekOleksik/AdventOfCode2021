package day5.part2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> listOfRows = readRowsFromFile();
        List<String> listOfLines = getListOfLines(listOfRows);
        AtomicInteger result = getResult(listOfLines);
        System.out.println("result = " + result);
    }

    private static AtomicInteger getResult(List<String> listOfLines) {
        Map<String, Integer> sumOfLines = new HashMap<>();
        AtomicInteger result = new AtomicInteger();
        for (String line : listOfLines) {
            sumOfLines.merge(line, 1, Integer::sum);
        }

        sumOfLines.forEach((k, v) -> {
            if (v >= 2) result.getAndIncrement();
        });
        return result;
    }

    private static List<String> getListOfLines(ArrayList<String> listOfRows) {
        List<String> listOfLines = new ArrayList<>();

        for (String rowInList : listOfRows) {
            String[] points = rowInList.replaceAll(" -> ", ",").split(",");
            int x1 = Integer.parseInt(points[0]);
            int y1 = Integer.parseInt(points[1]);
            int x2 = Integer.parseInt(points[2]);
            int y2 = Integer.parseInt(points[3]);

            if (x1 == x2) {
                if (y1 > y2) {
                    for (int i = y2; i <= y1; i++) {
                        listOfLines.add(x1 + "," + i);
                    }
                } else {
                    for (int i = y1; i <= y2; i++) {
                        listOfLines.add(x1 + "," + i);
                    }
                }
            } else if (y1 == y2) {
                if (x1 < x2) {
                    for (int j = x1; j <= x2; j++) {
                        listOfLines.add(j + "," + y1);
                    }
                } else {
                    for (int j = x2; j <= x1; j++) {
                        listOfLines.add(j + "," + y1);
                    }
                }
            } else if (x1 > x2) {
                if (y1 > y2) {
                    for (int i = 0; i <= y1 - y2; i++) {
                        listOfLines.add((x1 - i) + "," + (y1 - i));
                    }
                } else {
                    for (int i = 0; i <= y2 - y1; i++) {
                        listOfLines.add((x1 - i) + "," + (y1 + i));
                    }
                }
            } else {
                if (y1 > y2) {
                    for (int i = 0; i <= y1 - y2; i++) {
                        listOfLines.add((x1 + i) + "," + (y1 - i));
                    }
                } else {
                    for (int i = 0; i <= y2 - y1; i++) {
                        listOfLines.add((x1 + i) + "," + (y1 + i));
                    }
                }
            }
        }
        return listOfLines;
    }

    private static ArrayList<String> readRowsFromFile() throws IOException {
        FileInputStream fileReader = new FileInputStream("src\\day5\\part2\\input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fileReader, StandardCharsets.UTF_8));
        ArrayList<String> listOfRows = new ArrayList<>();
        String row;

        while ((row = br.readLine()) != null) {
            if (row.isBlank()) continue;
            listOfRows.add(row);
        }
        return listOfRows;
    }
}
