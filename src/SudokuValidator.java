public class SudokuValidator {

    public static void main(String[] args){
        //valid sudoku solution taken from wikipedia
        int[][] sudokuMatrix = {
                {5,3,4,6,7,8,9,1,2},
                {6,7,2,1,9,5,3,4,8},
                {1,9,8,3,4,2,5,6,7},
                {8,5,9,7,6,1,4,2,3},
                {4,2,6,8,5,3,7,9,1},
                {7,1,3,9,2,4,8,5,6},
                {9,6,1,5,3,7,2,8,4},
                {2,8,7,4,1,9,6,3,5},
                {3,4,5,2,8,6,1,7,9}};

        //invalid sudoku solution
/*        int[][] sudokuMatrix = {
                {5,3,3,6,7,8,9,1,2},
                {6,7,2,1,9,5,3,4,8},
                {1,9,8,3,4,2,5,6,7},
                {8,5,9,7,6,1,4,2,3},
                {4,2,6,8,5,3,7,9,1},
                {7,1,3,9,2,4,8,5,6},
                {9,6,1,5,3,7,2,8,4},
                {2,8,7,4,1,9,6,3,5},
                {3,4,5,2,8,6,1,7,9}};*/

        displayMatrix(sudokuMatrix);
        System.out.println("\n Given Sudoku solution is " + validateSudoku(sudokuMatrix));
    }

    /**
     * This method checks for valid sudoku entries by considering the elements range
     * and uniqueness of every row, column and subsquares.
     * @param sudokuMatrix
     * @return String 'valid' or 'invalid'
     */
    public static String validateSudoku(int[][] sudokuMatrix){
        String result = "valid";

        int rowCount = sudokuMatrix.length;

        //Checking for an empty sudoku input or sudoku with unequal rows and columns count
        if(sudokuMatrix == null || rowCount != sudokuMatrix[0].length){
            return "invalid";
        }else{
            //Checking for range of the each elements between 0-9
            if(!validateSudokuElements(sudokuMatrix, rowCount)) {
                return "invalid";
            }
            //Checking each row, column and subsquares for validity.
            if(!validateSudokuRules(sudokuMatrix, rowCount)){
                return "invalid";
            }
        }

        return result;
    }

    /**
     * This method checks each row, column and subsquare for the validity.
     * @param sudokuMatrix
     * @param rowCount
     * @return boolean
     */
    public static boolean validateSudokuRules(int[][] sudokuMatrix, int rowCount){

        int innerSquareSize = 3;

        //Checking each row
        for(int i=0; i<rowCount; i++){
            if(!rowCheck(sudokuMatrix, i, rowCount)){
                return false;
            }
        }

        //Checking each column
        for(int j=0; j<rowCount; j++){
            if(!columnCheck(sudokuMatrix, j, rowCount)){
                return false;
            }
        }

        //Checking each subsquare
        for(int i=0; i<rowCount; i+=innerSquareSize){
            for(int j=0; j<rowCount; j+=innerSquareSize){
                if(!innerSquareCheck(sudokuMatrix, i, j, innerSquareSize)){
                    return false;
                }
            }
        }

        return true;

    }

    /**
     * This method checks every subsquare for duplicate occurance of an element
     * @param matrix
     * @param row
     * @param col
     * @param innerSquareSize
     * @return boolean
     */
    public static boolean innerSquareCheck(int[][] matrix, int row, int col, int innerSquareSize){
        boolean[] elementOccurance = new boolean[matrix.length];

        for(int i=row; i<(row+innerSquareSize); i++){
            for(int j=col; j<(col+innerSquareSize); j++){
                if(!elementOccurance[matrix[i][j]-1]){
                    elementOccurance[matrix[i][j]-1] = true;
                }else
                    return false;
            }
        }
        return true;
    }

    /**
     * This method checks each row for the duplicate occurance of an element
     * @param matrix
     * @param rowNo
     * @param size
     * @return boolean
     */
    public static boolean rowCheck(int[][] matrix, int rowNo, int size){
        boolean[] elementOccurance = new boolean[size];
        int element;
        boolean flag = true;

        for(int j=0; j<size; j++){
            element = matrix[rowNo][j];
            if(!elementOccurance[element-1]){
                elementOccurance[element-1] = true;
            }else{
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * This method checks every column for duplicate occurance of an element
     * @param matrix
     * @param columnNo
     * @param size
     * @return boolean
     */
    public static boolean columnCheck(int[][] matrix, int columnNo, int size){
        boolean[] elementOccurance = new boolean[size];
        int element;
        boolean flag = true;

        for(int i=0; i<size; i++){
            element = matrix[i][columnNo];
            if(!elementOccurance[element-1]){
                elementOccurance[element-1] = true;
            }else{
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * This method checks each all the elements in the soduko for range 0-9
     * @param sudokuMatrix
     * @param count
     * @return
     */
    public static boolean validateSudokuElements(int[][] sudokuMatrix, int count){

        for(int i=0; i<count; i++){
            for(int j=0; j<count; j++){
                if(sudokuMatrix[i][j] < 1 || sudokuMatrix[i][j] > 9){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method simply displays the sudoku matrix
     * @param sudoku
     */
    private static void displayMatrix(int[][] sudoku){
        for(int[] eachRow:sudoku){
            for(int eachElement:eachRow){
                System.out.print(" " + eachElement);
            }
            System.out.println();
        }
    }
}
