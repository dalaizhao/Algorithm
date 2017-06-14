import java.util.Stack;

/*
 * ��Ŀ����
 *	����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
 * */

public class ContainMinFuncOfStack {

	// ����min������ջ
	public Stack<Integer> dataStack = new Stack<>();
	public Stack<Integer> minStack = new Stack<>();

	public void myPush(int node) {
		dataStack.push(node);
		if (minStack.size() == 0 || node < minStack.peek()) {
			minStack.push(node);
		} else {
			minStack.push(minStack.peek());
		}
	}

	public void myPop() {
		assert (dataStack.size() > 0 && minStack.size() > 0);
		dataStack.pop();
		minStack.pop();
	}

	public int myMin() {

		assert (dataStack.size() > 0 && minStack.size() > 0);
		return minStack.peek();
	}

}
