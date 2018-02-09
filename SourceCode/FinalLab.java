import java.util.Scanner;

public class FinalLab {

	public static void main(String[] args) {
		Scanner derp = new Scanner(System.in);
		System.out.print("n = ");
		int n =derp.nextInt();
		System.out.print("k = ");
		int k= derp.nextInt();;
		System.out.println("Binomial Coefficient = " + binC(n,k));
		System.out.println();
		derp.close();
	}
	
	public static int binC(int n, int k)
	{
		int[][] bMat = new int[n+1][k+1];
		for (int i = 0; i <= n; i++)
		{
			for (int j = 0; j <= Math.min(i, k); j++)
			{
				if (j == 0 || j == i)
					bMat[i][j] = 1;
				else
					bMat[i][j] = bMat[i-1][j-1] + bMat[i-1][j];
			}
		}
		return bMat[n][k];
	}

}
