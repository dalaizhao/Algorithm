import java.util.Stack;

/*
 * 题目描述
 *	定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * */

public class ContainMinFuncOfStack {

	// 包含min函数的栈
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
