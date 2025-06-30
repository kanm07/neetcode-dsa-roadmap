/*
 * Approach:
 * - Validate all rows and columns by checking for duplicate digits using a HashSet.
 * - Validate each 3x3 sub-box in the same way.
 * - Skip cells containing '.' since they're considered empty.
 *
 * Time Complexity: O(1) - the board is fixed at 9x9, so operations are constant.
 * Space Complexity: O(1) - uses a fixed amount of extra space for sets.
 */

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> seen_row = new HashSet<>();
            Set<Character> seen_column = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (seen_row.contains(board[i][j])) {
                    return false;
                }
                if (board[i][j] != '.') {
                    seen_row.add(board[i][j]);
                }

                if (seen_column.contains(board[j][i])) {
                    return false;
                }
                if (board[j][i] != '.') {
                    seen_column.add(board[j][i]);
                }
            }
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[i].length; j += 3) {
                Set<Character> seen = new HashSet<>();
                for (int row = i; row < i + 3; row++) {
                    for (int col = j; col < j + 3; col++) {
                        if (seen.contains(board[row][col])) {
                            return false;
                        }
                        if (board[row][col] != '.') {
                            seen.add(board[row][col]);
                        }
                    }
                }
            }
        }

        return true;
    }
}
