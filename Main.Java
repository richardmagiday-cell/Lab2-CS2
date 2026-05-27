import java.util.*;

public class Main
{
    static Scanner in = new Scanner(System.in);
    private int[][] square;
    private int magicConst;
    private int totalSqs;
    private boolean[] possible;
    private int numSquares;

    public int findingMagicConstant(int N)
    {
        return N * ((N * N) + 1) / 2;
    }

    public Main(int N)
    {
        if (N < 2)
        {
            System.out.print("Only give values > 2!");
            System.exit(1);
        }

        square = new int[N][N];
        magicConst = this.findingMagicConstant(N);
        totalSqs = N * N;

        possible = new boolean[totalSqs];
        for (int i = 0; i < totalSqs; i++)
        {
            possible[i] = true;
        }

        numSquares = 0;
    }

    public boolean validSquare()
    {
        for (int i = 0; i < square.length; i++)
        {
            int rowSum = 0;

            for (int j = 0; j < square[i].length; j++)
            {
                rowSum += square[i][j];

                if (square[i][j] == 0)
                {
                    return false;
                }
            }

            if (rowSum != magicConst)
            {
                return false;
            }
        }

        // col sum check
        for (int i = 0; i < square.length; i++)
        {
            int colSum = 0;

            for (int j = 0; j < square.length; j++)
            {
                colSum += square[j][i];

                if (square[j][i] == 0)
                {
                    return false;
                }
            }

            if (colSum != magicConst)
            {
                return false;
            }
        }

        // diag1 sum check
        int diag1Sum = 0;

        for (int r = 0; r < square.length; r++)
        {
            if (square[r][r] == 0)
            {
                return false;
            }

            diag1Sum += square[r][r];
        }

        if (diag1Sum != magicConst)
        {
            return false;
        }

        // diag2 sum check
        int diag2Sum = 0;

        for (int r = 0; r < square.length; r++)
        {
            if (square[r][square.length - 1 - r] == 0)
            {
                return false;
            }

            diag2Sum += square[r][square.length - 1 - r];
        }

        if (diag2Sum != magicConst)
        {
            return false;
        }

        return true;
    }

    public void fill(int row, int col)
    {
        if (validSquare())
        {
            System.out.print("Done!!\n");

            for (int[] r : square)
            {
                System.out.println(Arrays.toString(r));
            }

            numSquares++;
        }

        if (row == square.length)
        {
            return;
        }

        for (int i = 0; i < totalSqs; i++)
        {
            if (possible[i])
            {
                square[row][col] = i + 1;
                possible[i] = false;

                int nextCol = col + 1;
                int nextRow = row;

                if (nextCol == square.length)
                {
                    nextRow++;
                    nextCol = 0;
                }

                fill(nextRow, nextCol);

                square[row][col] = 0;
                possible[i] = true;
            }
        }
    }

    public static void main(String[] args)
    {
        int N = in.nextInt();
        System.out.println("N = " + N);
        Main ms = new Main(N);
        ms.fill(0, 0);
        
    }
}
