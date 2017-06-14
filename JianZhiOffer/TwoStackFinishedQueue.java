import java.util.Stack;

/*
 * ��Ŀ����
 *	������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 * 
 * */
public class TwoStackFinishedQueue {

	// ������ջʵ�ֶ���
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {

		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		int first = stack2.pop();
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return first;
	}
}
