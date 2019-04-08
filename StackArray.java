
public class StackArray <T> implements StackInterface<T>{ //stacks fill in last in first out; adding box of milk top top of milk stack in fridge
	private T[] stack;
	public static final int arrSize = 100;
	private int head; //head is movable; fist null element 
	
	public StackArray() {
		init(arrSize);
	}
	
	public StackArray(int aSize) {
		init(aSize);
	}
	
	private void init(int aSize) {
		if(aSize<=0)
			return;
		head = 0;
		stack = (T[])(new Object[aSize]);
	}
	
	public void push(T aData) {
		if(head>=stack.length)
			return;
		stack[head] = aData;
		head++;	
	}
	
	public T pop() { //removes last element added
		if(head<=0)
			return null;
		T ret = stack[head-1];
		head--;
		return ret;
	}
	
	public T peek() {
		if(head<=0)
			return null;
		return stack[head-1];
	}
	
	public void print() {
		for(int i = head-1; i>=0; i--)
			System.out.println(stack[i]);
	}
	
}
