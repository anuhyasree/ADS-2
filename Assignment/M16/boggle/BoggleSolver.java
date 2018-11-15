import java.util.ArrayList;
public class BoggleSolver {
    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    Tries dictionary;
    public BoggleSolver(String[] dictionary) {
        if (dictionary == null) {
            throw new NullPointerException();
        }
        this.dictionary = new Tries();
        for (String s : dictionary) {
            this.dictionary.put(s);
        }
    }
    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public ArrayList<String> getAllValidWords(BoggleBoard board) {
        ArrayList<String> allValidWords = new ArrayList<String>();
        boolean[][] marked  = new boolean[board.rows()][board.cols()];
        for (int r = 0; r < board.rows(); r++) {
            for (int c = 0; c < board.cols(); c++) {
                StringBuilder sb = new StringBuilder();
                verifyword(sb, allValidWords, board, marked, r, c);
                marked[r][c] = false;
            }
        }
        return allValidWords;
    }
    private void verifyword(StringBuilder str,
                            ArrayList<String> toaddwordsindictionary,
                            BoggleBoard board,
                            boolean[][] marked,
                            int r,
                            int c) {

        marked[r][c] = true;
        str.append(board.getLetter(r, c));
        if (board.getLetter(r, c) == 'Q')
            str.append("U");
        if (dictionary.contains(str.toString())) {
            if (!toaddwordsindictionary.contains(str.toString()) && str.length() > 2)
                toaddwordsindictionary.add(str.toString());
        } else if (!dictionary.isPrefix(str.toString()))
            return;
        //up, left-up, right-up, right, down, down-left, down-right, left
        if (r > 0) {
            if (!marked[r - 1][c]) {
                verifyword(str, toaddwordsindictionary, board, marked, r - 1, c);
                str.deleteCharAt(str.length() - 1);
                marked[r - 1][c] = false;
            }
            if (c > 0) {
                if (!marked[r - 1][c - 1]) {
                    verifyword(str, toaddwordsindictionary, board, marked, r - 1, c - 1);
                    str.deleteCharAt(str.length() - 1);
                    marked[r - 1][c - 1] = false;
                }
            }
            if (c < board.cols() - 1) {
                if (!marked[r - 1][c + 1]) {
                    verifyword(str, toaddwordsindictionary, board, marked, r - 1, c + 1);
                    str.deleteCharAt(str.length() - 1);
                    marked[r - 1][c + 1] = false;
                }
            }
        }
        if (c < board.cols() - 1) {
            if (!marked[r][c + 1]) {
                verifyword(str, toaddwordsindictionary, board, marked, r, c + 1);
                str.deleteCharAt(str.length() - 1);
                marked[r][c + 1] = false;
            }
        }
        if (r < board.rows() - 1) {
            if (!marked[r + 1][c]) {
                verifyword(str, toaddwordsindictionary, board, marked, r + 1, c);
                str.deleteCharAt(str.length() - 1);
                marked[r + 1][c] = false;
            }
            if (c > 0) {
                if (!marked[r + 1][c - 1]) {
                    verifyword(str, toaddwordsindictionary, board, marked, r + 1, c - 1);
                    str.deleteCharAt(str.length() - 1);
                    marked[r + 1][c - 1] = false;
                }
            }
            if (c < board.cols() - 1) {
                if (!marked[r + 1][c + 1]) {
                    verifyword(str, toaddwordsindictionary, board, marked, r + 1, c + 1);
                    str.deleteCharAt(str.length() - 1);
                    marked[r + 1][c + 1] = false;
                }
            }
        }
        if (c > 0) {
            if (!marked[r][c - 1]) {
                verifyword(str, toaddwordsindictionary, board, marked, r, c - 1);
                str.deleteCharAt(str.length() - 1);
                marked[r][c - 1] = false;
            }
        }
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word) {
        if (word == null) {
            throw new NullPointerException();
        }
        if (dictionary.contains(word)) {
            switch (word.length()) {
            case 0:
            case 1:
            case 2:
                return 0;
            case 3:
            case 4:
                return 1;
            case 5:
                return 2;
            case 6:
                return 3;
            case 7:
                return 5;
            default:
                return 11;
            }
        }
        return 0;
    }
}