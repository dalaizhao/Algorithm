import java.util.Stack;

/*
 * ��Ŀ����
 *	���������������У���һ�����б�ʾջ��ѹ��˳��
 *	���жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
 *	����ѹ��ջ���������־�����ȡ�
 *	��������1,2,3,4,5��ĳջ��ѹ��˳��
 *	����4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
 *	��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С�
 *	��ע�⣺���������еĳ�������ȵģ�
 * */
public class IsPopOrder {

	// ջ��ѹ�롢��������
	public boolean isPopOrder(int[] pushA, int[] popA) {

		if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length)
			return false;

		Stack<Integer> pushAStack = new Stack<>();
		int pushAIndex = 0, popAIndex = 0;
		while (popAIndex < popA.length) {
			while (pushAStack.empty() || pushAStack.peek() != popA[popAIndex]) {
				if (pushAIndex == pushA.length)
					break;
				pushAStack.push(pushA[pushAIndex]);
				pushAIndex++;
			}
			if (pushAStack.peek() != popA[popAIndex]) {
				break;
			}
			pushAStack.pop();
			popAIndex++;
		}
		if (pushAStack.empty() && popAIndex == popA.length)
			return true;
		return false;
	}
}
