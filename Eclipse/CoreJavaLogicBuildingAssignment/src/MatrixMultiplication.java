
public class MatrixMultiplication {

	public static void main(String[] args) {
		int[][] mat1={{1,1,1},
				  {2,2,2},
				  {3,3,3}};
		int[][] mat2={{1,1,1},
				  {2,2,2},
				  {3,3,3}};
		int[][] mat3={{0,0,0},
					{0,0,0},
					{0,0,0}};
		int N=3;
		for(int i=0;i<N;i++){
			for(int k=0;k<N;k++){
				for(int j=0;j<N;j++){
					mat3[i][k]=mat3[i][k]+mat1[i][j]*mat2[j][k];
				}
				System.out.print(mat3[i][k]+" ");
			}
			System.out.println();
		}
	} 
}

