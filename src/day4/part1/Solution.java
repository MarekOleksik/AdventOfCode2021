package day4.part1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileReader = new FileInputStream("src\\day4\\part1\\input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fileReader, StandardCharsets.UTF_8));
        String numbers = br.readLine();
        String[] generatedNumbers = numbers.split(",");
        ArrayList<String> listOfRows = new ArrayList<>();
        String row;

        while ((row = br.readLine()) != null) {
            if (row.isBlank()) continue;
            listOfRows.add(row);
        }

        List<NumberAtBoard> numbersAtBoard = new ArrayList<>();
        for (int i = 0; i < listOfRows.size(); i++) {
            String[] partOfRow = listOfRows.get(i).replaceAll(" +", " ").trim().split(" ");
            for (int j = 0; j < partOfRow.length; j++) {
                int value = Integer.parseInt(partOfRow[j]);
                numbersAtBoard.add(new NumberAtBoard(i / 5 + 1, i % 5 + 1, j + 1, value));
            }
        }

        boolean isGameOver = false;
        int winnerBoard = 0;
        int winnerNumber = 0;

        while (!isGameOver) {
            for (int i = 0; i < generatedNumbers.length; i++) {
                int generatedNumber = Integer.parseInt(generatedNumbers[i]);
                for (int j = 0; j < numbersAtBoard.size(); j++) {
                    int value = numbersAtBoard.get(j).getValue();
                    if (value == generatedNumber) {
                        numbersAtBoard.get(j).setWin(true);
                    }
                    isGameOver = isGameOver(numbersAtBoard);
                    if (isGameOver) {
                        winnerBoard = numbersAtBoard.get(j).getBoard();
                        winnerNumber = generatedNumber;
                        break;
                    }
                }
                if (isGameOver) break;
            }
        }
        int sumOfNumbers = 0;

        for (NumberAtBoard n : numbersAtBoard) {
            if (n.getBoard() == winnerBoard && !n.isWin()) {
                sumOfNumbers += n.getValue();
            }
        }

        int result = sumOfNumbers * winnerNumber;

        System.out.println("result = " + result);
    }

    private static boolean isGameOver(List<NumberAtBoard> numbersAtBoard) {
        boolean win = false;
        int counter = 0;
        for (int i = 1; i < numbersAtBoard.size(); i++) {
            if (numbersAtBoard.get(i).getX() == numbersAtBoard.get(i - 1).getX() && numbersAtBoard.get(i - 1).isWin() && numbersAtBoard.get(i).isWin()) {
                counter++;
                if (counter == 4) {
                    win = true;
                    break;
                }
            } else {
                counter = 0;
            }
        }
        return win;
    }
}
