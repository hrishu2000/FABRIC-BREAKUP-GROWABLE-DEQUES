import java.util.*;
import java.io.*;

class pair
{
	private int first;
	private int second;

	public pair(int a,int b)
	{
		first=a;
		second=b;
	}
	public int key()
	{
		return first;
	}
	public int val()
	{
		return second;
	}
}
public class FabricBreakup {	
	public static void main(String args[]) throws FileNotFoundException{
		// Implement FabricBreakup puzzle using Stack interface
		try{
			FileInputStream fstream =new FileInputStream (args[0]);
			Scanner f = new Scanner(fstream);
			StackInterface s=new Stack();
			int t=f.nextInt();
			while(f.hasNextInt())
			{
			    int a = f.nextInt();
			    int b = f.nextInt();
			    if(b==1)
			    {
			    	int c=f.nextInt();
			    	try{
			    		pair p1=(pair)s.top();
					    if(c<p1.key())
					    {
					    	int count=(int)p1.val();
					    	s.pop();
					    	s.push(new pair((int)p1.key(),count+1));
					    }
					    else
					    {
					    	s.push(new pair(c,0));
					    }
					}
					catch(EmptyStackException e)
					{
						s.push(new pair(c,0));
					}
			    }
			    else
			    {
			    	try{
			    		pair p1=(pair)s.top();
						System.out.println(a+" "+(int)p1.val());
						s.pop();
			    	}
			    	catch(EmptyStackException e) 
			    	{
			    		System.out.println(a+" "+"-1");
			    	}
			    }
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found");
		}
	}
}
