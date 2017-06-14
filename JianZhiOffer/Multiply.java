/*
 * ��Ŀ����
 *	����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],
 *	����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
 * */
public class Multiply {

	// �����˻�����
	public int[] multiply(int[] A) {

		if (A == null || A.length == 0)
			return null;
		int len = A.length;
		int[] B = new int[len];
		// ʱ�临�Ӷȸߣ�Ч�ʵ�
		// for(int i=0,len=A.length;i<len;i++)
		// B[i]=1;
		// for(int i=0,len=A.length;i<len;i++){
		// for(int j=0;j<len;j++){
		// if(j!=i){
		// B[i]*=A[j];
		// }
		// }
		// }

		// ��Ϊ����ǰi-1�ͺ�n-i������������
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
