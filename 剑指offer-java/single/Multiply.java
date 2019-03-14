/*
 * 题目描述
 *	给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 *	其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * */
public class Multiply {

	// 构建乘积数组
	public int[] multiply(int[] A) {

		if (A == null || A.length == 0)
			return null;
		int len = A.length;
		int[] B = new int[len];
		// 时间复杂度高，效率低
		// for(int i=0,len=A.length;i<len;i++)
		// B[i]=1;
		// for(int i=0,len=A.length;i<len;i++){
		// for(int j=0;j<len;j++){
		// if(j!=i){
		// B[i]*=A[j];
		// }
		// }
		// }

		// 分为计算前i-1和后n-i俩部分来计算
		int[] forword = new int[len];
		int[] backword = new int[len];

		forword[0] = 1;
		backword[0] = 1;

		for (int i = 1; i < len; i++) {
			forword[i] = A[i - 1] * forword[i - 1];
			backword[i] = A[len - i] * backword[i - 1];
		}
		for (int i = 0; i < len; i++) {
			B[i] = forword[i] * backword[len - i - 1];
		}

		return B;
	}
}
