public class MatrixMultiplication {
    public int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) throws InterruptedException {
        int m = matrixA.length;    
        int n = matrixA[0].length; 
        int p = matrixB[0].length; 
        
        int[][] result = new int[m][p];
        
        Thread[] threads = new Thread[m];
        
        for (int i = 0; i < m; i++) {
            final int row = i;
            threads[i] = new Thread(() -> {
                for (int j = 0; j < p; j++) {
                    result[row][j] = 0;
                    for (int k = 0; k < n; k++) {
                        result[row][j] += matrixA[row][k] * matrixB[k][j];
                    }
                }
            });
        }

        for (int i = 0; i < m; i++) {
            threads[i].start();
        }

        for (int i = 0; i < m; i++) {
            threads[i].join();
        }

        return result;
    }

    public static void main(String[] args) {
        MatrixMultiplication matrixMultiplication = new MatrixMultiplication();

        int[][] matrixA = {
            {1, 2},
            {3, 4}
        };

        int[][] matrixB = {
            {2, 0},
            {1, 2}
        };

        try {
        
            int[][] result = matrixMultiplication.multiplyMatrices(matrixA, matrixB);
        
            System.out.println("Result of the multiplication:");
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
