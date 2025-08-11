class sudoku_solver:
    def solveSudoku(self, board):
        # Checks if a given character at (row,col) is valid.
        def isValid(row, col, character):
            # Create variables for checking the square.
            block_row = 3 * (row // 3)
            block_col = 3 * (col // 3)
            
            # Loop through the 9 potential spots and check if the charater appears in any position.
            for i in range(9):
                if (board[row][i] == character or
                    board[i][col] == character or
                    board[block_row + i // 3][block_col + i % 3] == character):
                        return False
                
            return True
            
        def solve(row, col):
            # Loop through the whole board and place the values for each empty position.
            for row in range(9):
                for col in range(9):
                    if board[row][col] == '.':
                        # For a given unsolved position, we loop through each character and see if it is valid or not.
                        # If it is valid, then we set that char and recursively call solve again to place the next value.
                        # In the case it fails, we will replace the position with an empty spot and move on to the next
                        # character.
                        for char in '123456789':
                            if isValid(row, col, char):
                                board[row][col] = char
                                if solve(0,0):
                                    return True
                                board[row][col] = '.'
                        return False
            return True
        
        solve(0, 0)


# Example
sudoku = sudoku_solver

board = [["5","3",".",".","7",".",".",".","."],
         ["6",".",".","1","9","5",".",".","."],
         [".","9","8",".",".",".",".","6","."],
         ["8",".",".",".","6",".",".",".","3"],
         ["4",".",".","8",".","3",".",".","1"],
         ["7",".",".",".","2",".",".",".","6"],
         [".","6",".",".",".",".","2","8","."],
         [".",".",".","4","1","9",".",".","5"],
         [".",".",".",".","8",".",".","7","9"]]

sudoku.solveSudoku(sudoku, board)

for sub_board in board:
    print(sub_board)