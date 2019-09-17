import org.junit.jupiter.api.Assertions;

class SudokuValidatorTest {

    //Valid Sudoku
    private int[][] sudokuMatrixValid = {
            {5,3,4,6,7,8,9,1,2},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,7,2,8,4},
            {2,8,7,4,1,9,6,3,5},
            {3,4,5,2,8,6,1,7,9}};

    //Invalid Sudoku
    private int[][] sudokuMatrixInvalid = {
            {5,3,3,6,7,8,9,1,2},
            {5,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,-7,2,8,4},
            {2,8,7,4,1,9,6,3,5},
            {3,4,5,2,8,6,1,7,9}};


    @org.junit.jupiter.api.Test
    void validateSudoku() {
        Assertions.assertEquals("valid",SudokuValidator.validateSudoku(sudokuMatrixValid));
        Assertions.assertEquals("invalid",SudokuValidator.validateSudoku(sudokuMatrixInvalid));

    }

    @org.junit.jupiter.api.Test
    void validateSudokuRules() {
        Assertions.assertEquals(true, SudokuValidator.validateSudokuRules(sudokuMatrixValid, sudokuMatrixValid.length));
        Assertions.assertEquals(false, SudokuValidator.validateSudokuRules(sudokuMatrixInvalid, sudokuMatrixValid.length));
    }

    @org.junit.jupiter.api.Test
    void innerSquareCheck() {
        Assertions.assertEquals(true,SudokuValidator.innerSquareCheck(sudokuMatrixValid,0, 0, 3));
        Assertions.assertEquals(false,SudokuValidator.innerSquareCheck(sudokuMatrixInvalid,0, 0, 3));
    }

    @org.junit.jupiter.api.Test
    void rowCheck() {
        Assertions.assertEquals(true, SudokuValidator.rowCheck(sudokuMatrixValid, 0, sudokuMatrixValid.length));
        Assertions.assertEquals(false, SudokuValidator.rowCheck(sudokuMatrixInvalid, 0, sudokuMatrixValid.length));
    }

    @org.junit.jupiter.api.Test
    void columnCheck() {
        Assertions.assertEquals(true, SudokuValidator.columnCheck(sudokuMatrixValid, 0, sudokuMatrixValid.length));
        Assertions.assertEquals(false, SudokuValidator.columnCheck(sudokuMatrixInvalid, 0, sudokuMatrixValid.length));
    }

    @org.junit.jupiter.api.Test
    void validateSudokuElements() {
        Assertions.assertEquals(true,SudokuValidator.validateSudokuElements(sudokuMatrixValid, sudokuMatrixValid.length));
        Assertions.assertEquals(false,SudokuValidator.validateSudokuElements(sudokuMatrixInvalid, sudokuMatrixValid.length));
    }
}