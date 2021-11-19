public class ArrayDeque implements DequeInterface {

	private int front;
	private int rear;
	private int n;
	private Object [] arr;
	public ArrayDeque()
	{
		arr=new Object[1];
		front=0;
		rear=0;
		n=1;
	}

  public void insertFirst(Object o){
    //you need to implement this
    if((n+front-rear)%n==n-1)
    {
    	Object [] temp=new Object[2*n];
    	for(int i=0;i<n-1;i++)
    	{
    		temp[i]=arr[(rear+i)%n];
    	}
    	arr=temp;
    	front=n-1;
    	rear=0;
    	n=2*n;
    }
    arr[(n+rear-1)%n]=o;
    rear=(n+rear-1)%n;
    
  }
  
  public void insertLast(Object o){
    //you need to implement this
    if((n+front-rear)%n==n-1)
    {
    	Object [] temp=new Object[2*n];
    	for(int i=0;i<n-1;i++)
    	{
    		temp[i]=arr[(rear+i)%n];
    	}
    	arr=temp;
    	front=n-1;
    	rear=0;
    	n=2*n;
    }
    arr[front]=o;
    front=(front+1)%n;
    
  }
  
  public Object removeFirst() throws EmptyDequeException{
    //you need to implement this
    if(front==rear)
    {
        throw new EmptyDequeException("Deque is empty");
    }
    else
    {
        rear = (rear+1)%n;
        return arr[(n+rear-1)%n];
    }
    
  }
  
  public Object removeLast() throws EmptyDequeException{
    //you need to implement this
    if(front==rear)
    {
        throw new EmptyDequeException("Deque is empty");
    }
    else
    {
        front = (n+front-1)%n;
        return arr[front];
    }
    
  }

  public Object first() throws EmptyDequeException{
    //you need to implement this
    if(front==rear)
    {
        throw new EmptyDequeException("Deque is empty");
    }
    else
    {
        return arr[rear];
    }
    
  }
  
  public Object last() throws EmptyDequeException{
    //you need to implement this
    if(front==rear)
    {
        throw new EmptyDequeException("Deque is empty");
    }
    else
    {
        return arr[(n+front-1)%n];
    }
    
  }
  
  public int size(){
    //you need to implement this
    return (n+front-rear)%n;
  }
  
  public boolean isEmpty(){
    //you need to implement this
    if(this.size()==0) return true;
    return false;
    
  }

  public String toString(){
    //you need to implement this
    String res="[";
    if(front!=rear) 
    {
    	for(int i=rear;i<rear+this.size()-1;i++) {
    		res+=arr[i%n];res+=", ";
    	}
    	res+=arr[(n+front-1)%n];
    }
    res+="]";
    return res;
    
  }  
}