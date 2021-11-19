// You should utilise your implementation of ArrayDeque methods to implement this
public class Stack implements StackInterface {	

    public ArrayDeque q=new ArrayDeque();
	public void push(Object o){
    	//you need to implement this
        q.insertLast(o);
  	}

	public Object pop() throws EmptyStackException{
    	//you need to implement this
        try{
            Object p=q.last();
            q.removeLast();
            return p;
        }
        catch (EmptyDequeException e)
        {
            throw new EmptyStackException("Stack is empty");
        } 
	}

	public Object top() throws EmptyStackException{
    	//you need to implement this
        try{
            return q.last();
        } 
        catch (EmptyDequeException e)
        {
            throw new EmptyStackException("Stack is empty");
        } 
	}

	public boolean isEmpty(){
    	//you need to implement this
        if(q.isEmpty()) return true;
        else return false;
	}

    public int size(){
    	//you need to implement this
        return q.size();
    }
}