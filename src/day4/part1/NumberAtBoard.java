package day4.part1;

public class NumberAtBoard {
    private int board;
    private int x;
    private int y;
    private boolean isWin;
    private int value;

    public NumberAtBoard(int board, int x, int y, int value) {
        this.board = board;
        this.x = x;
        this.y = y;
        this.value = value;
        this.isWin = false;
    }

    public int getBoard() {
        return board;
    }

    public int getX() {
        return x;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "NumberAtBoard{" +
                "board=" + board +
                ", x=" + x +
                ", y=" + y +
                ", isWin=" + isWin +
                ", value=" + value +
                '}';
    }
}
