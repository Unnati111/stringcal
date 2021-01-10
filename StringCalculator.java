
public class StringCalculator{

	public int Add(String numbers){
		int sum=0;
		String[] arrSplit = null;

		if(numbers.length()==0) {   //Test Case1 passed
			return 0;
		}
		else {
			arrSplit = numbers.split(",");
			for (int i=0; i < arrSplit.length; i++)
			{
				int temp=Integer.parseInt(arrSplit[i].trim());
				sum+=temp;
			}
			return sum;
		}
	}

	public static void main(String[] args){
		StringCalculator s=new StringCalculator();
		int value=s.Add("");
		int value1=s.Add("1");
		int value2=s.Add("1,2");
		int value3=s.Add("1,2,3,4,51,9"); //Test Case 2 passed
	  System.out.println("Input:''  Output:"+value);
	  System.out.println("Input:'1'  Output:"+value1);
		System.out.println("Input:'1,2'  Output:"+value2);
		System.out.println("Input:'1,2,3,4,51,9'  Output:"+value3);
	}
}
