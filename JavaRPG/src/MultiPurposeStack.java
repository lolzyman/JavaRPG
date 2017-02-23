
public class MultiPurposeStack {

	
	private Node head, foot;
	private int length;
	
	public MultiPurposeStack(){
		length = 0;
	}
	
	public boolean isEmpty(){
		if(length == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public void addBeginning(int value){
		Node newNode = new Node();
		newNode.setIntValue(value);
		newNode.setParent(null);
		
		if(isEmpty()){
			newNode.setChild(null);
			head = newNode;
			foot = newNode;
		}else{
			newNode.setChild(head);
			head.setParent(newNode);
			head = newNode;
		}
		length++;
	}
	
	public void addEnd(int value){
		Node newNode = new Node();
		newNode.setIntValue(value);
		newNode.setChild(null);
		
		if(isEmpty()){
			newNode.setParent(null);
			head = newNode;
			foot = newNode;
		}else{
			newNode.setParent(foot);
			foot.setChild(newNode);
			foot = newNode;
		}
		length++;
	}
	
	public void deleteEnd(){
		if(!isEmpty()){
			if(foot.equals(head)){
				foot.Destory();
			}else{
				foot = foot.getParent();
				foot.getChild().Destory();
			}
			length--;
		}
	}
	
	public void deleteBeginning(){
		if(!isEmpty()){
			if(head.equals(foot)){
				head.Destory();
			}else{
				head = head.getChild();
				head.getParent().Destory();
			}
			length--;
		}
	}
	
	public void deleteAt(int index){
		if(index == 1){
			head = head.getChild();
			head.getParent().Destory();
			length--;
			return;
		}
		if(index == length){
			foot = foot.getParent();
			foot.getChild().Destory();
			length--;
			return;
		}
		
		Node inQuestion = head;
		for(int i = 1; i < index; i++){
			inQuestion = inQuestion.getChild();
		}
		inQuestion.Destory();
		length--;
	}
	
	//this can probably be written in a better fashion. like with a for loop
	public void deleteValue(int value){
		Node inQuestion = head;
		while(!inQuestion.equals(foot)){
			if(inQuestion.getIntValue() == value){
				if(inQuestion.equals(head)){
					head = inQuestion.getChild();
				}
				inQuestion.Destory();
				return;
			}
			inQuestion = inQuestion.getChild();
		}
		if(inQuestion.getIntValue() == value){
			foot = inQuestion.getParent();
			inQuestion.Destory();
		}
		length--;
	}
	public void purge(){
		Node inQuestion = head, yeh;
		while(!inQuestion.equals(foot)){
			yeh = inQuestion.getChild();
			inQuestion.Destory();
			inQuestion = yeh;
		}
		inQuestion.Destory();
		head = null;
		foot = null;
		length = 0;
	}
	/*public void deleteValue(String value){
		
	}
	
	public void deleteValue(double value){
		
	}
	*/
	
}

class Node{
	
	//String stringValue;
	int intValue;
	Node child, parent;
	MultiPurposeStack master;
	
	public void Destory(){
		if(child != null && parent != null){
			child.setParent(parent);
			parent.setChild(child);
		}else if(child != null){
			child.setParent(null);
		}else{
			parent.setChild(null);
		}
		child = null;
		parent = null;
	}	
	//getters and setters
	public int getIntValue() {
		return intValue;
	}
	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}
	public Node getChild() {
		return child;
	}
	public void setChild(Node child) {
		this.child = child;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
}