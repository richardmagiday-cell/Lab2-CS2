import.java.util*;

public class Main
{

    static Scanner in = new Scanner();

    private int[][] square;

    private magicConst;

    private int totalSqs;

    private boolean[] possible;

    private int num;

    public int findingMagicConstant(int N)
    {
        return N * ((N*N) + 1) / 2;
    }

    public Main(int N)
    {
        if(N < 2)
        {
            System.out.print("Only give values > 2!");
            System.exit(1);
        }
    }
    
    public static void main(String[] args)
    {

    }
}