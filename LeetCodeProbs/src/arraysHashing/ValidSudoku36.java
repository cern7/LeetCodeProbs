package arraysHashing;

import java.util.*;

public class ValidSudoku36 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.' },
                {'6', '.', '.', '1', '9', '5', '.', '.', '.' },
                {'.', '9', '8', '.', '.', '.', '.', '6', '.' },

                {'8', '.', '.', '.', '6', '.', '.', '.', '3' },
                {'4', '.', '.', '8', '.', '3', '.', '.', '1' },
                {'7', '.', '.', '.', '2', '.', '.', '.', '6' },

                {'.', '6', '.', '.', '.', '.', '2', '8', '.' },
                {'.', '.', '.', '4', '1', '9', '.', '.', '5' },
                {'.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println(new ValidSudoku36().isValidSudoku(matrix));

    }

    class Key {
        int i;
        int j;

        public Key(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public Key getIJ() {
            return this;
        }

        @Override
        public String toString() {
            return "[" + this.i + "][" + this.j + "] =>\n";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return i == key.i && j == key.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int column = board[0].length;
        Map<Key, Set<Character>> hm3X3 = new HashMap<>(3);
        Map<Integer, Set<Character>> rowValid = new HashMap<>();
        Map<Integer, Set<Character>> columnValid = new HashMap<>();

        for (int i = 0; i < row; i++) {
            if (!rowValid.containsKey(i)) {
                rowValid.put(i, new HashSet<>());
            }
            for (int j = 0; j < column; j++) {

                char c = board[i][j];
                if (!Character.isDigit(c)) {
                    continue;
                }
                Key br3x3 = new Key(i / 3, j / 3);
                if (!columnValid.containsKey(j)) {
                    columnValid.put(j, new HashSet<>());
                }
                if (!hm3X3.containsKey(br3x3)) {
                    hm3X3.put(br3x3, new HashSet<>());
                }
                if (rowValid.get(i).contains(c)
                        || columnValid.get(j).contains(c)
                        || hm3X3.get(br3x3).contains(c)) {
                    return false;
                }
                rowValid.get(i).add(c);
                columnValid.get(j).add(c);
                hm3X3.get(br3x3).add(c);
            }
        }
        return true;
    }
}
