
public class GenLL <T>{ //generic of type t
	private class ListNode{ //internal class
		private T data;
		private ListNode link;
		
		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}
	
	private ListNode head; //first item in list
	private ListNode current;
	private ListNode previous;
	
	public GenLL() {
		head = current = previous = null;
	}
	
	public void insert(T aData) {
		ListNode newNode = new ListNode(aData, null);//null since inserted at end of list
		if(head == null) {
			head = newNode; //head and newNode hold addresses to same data in heap memory
			current = head; //since head is first element, its also the current
			return;
		}
		ListNode temp = head;
		while(temp.link!=null) {
			temp = temp.link;
		}
		temp.link = newNode;
	}
	
	public void print() {
		for(ListNode temp = head; temp!=null; temp = temp.link)
			System.out.println(temp.data);
		System.out.println();
	}
	
	public T getCurrent() {
		if(current != null)
			return current.data;
		return null;
	}
	
	public void setCurrent(T aData) {
		if(current != null)
			current.data = aData;
	}
	
	public void goToNext() {
		if(current == null)
			return;
		previous = current;
		current = current.link;
	}
	
	public void reset() {
		previous = null;
		current = head;
	}
	
	public void insertAfterCurrent(T aData) {
		if(current == null)
			return;
		ListNode newNode = new ListNode(aData, current.link);
		current.link = newNode;
	}
	
	public void deleteCurrent() {
		if(current!=null && previous!=null) {
			previous.link = current.link; //memory address of previous.link is current so just skip over current
			current = current.link;
		}
		else if(current!=null && previous == null) { //current at head
			head = head.link; //current = current.link
		}
	}
	
	private ListNode search(T aData) {
		ListNode temp = head;
		while(temp!= null) {
			if (temp.data.equals(aData))
				return temp;
			temp = temp.link;
		}
		return null;
	}
	
	public boolean isContained(T aData) {
		return this.findNodeWith(aData) != null;
	}
	
	private ListNode findNodeWith(T aData) {
		ListNode temp = head;
		while(temp!=null) {
			if(temp.data.equals(aData)) {
				return temp;
			}
		}
		return null;
	}
	
	public void goToItem(T aData) {
		ListNode temp = this.findNodeWith(aData);
		if(temp == null)
			return;
		this.resetCurrent();
		while(this.hasMore() && current!= temp) {
			this.goToNext();
		}
	}
	
	public void resetCurrent() {
		current = head;
	}
	
	public boolean hasMore() {
		return current!=null;
	}
	
	public void delteCurrent() {
		if(current!=null && previous!=null) { //current is at anything but the head
			previous.link = current.link; //previous.link is the same thing as current
			current = current.link;
		}
		else if(current!=null) {
			head = head.link;
		}
	}
	//goToPrevious; start at head and while
}
