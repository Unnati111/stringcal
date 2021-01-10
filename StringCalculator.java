import java.util.*;
public class StringCalculator{
  int count=0;
	public int Add(String numbers){
		List<Integer> negatives=new ArrayList<>();
		int sum=0,start=0,end=0;
		String[] arrSplit = null;
		String delimiter=null,newstring=null;
		count++;
		if(numbers.length()==0) {   //Test Case1 passed
			return 0;
		}
		else {
			if(numbers.startsWith("//")) {
				  start=numbers.indexOf("[");
				  end=numbers.indexOf("]");
				  if(start!=-1 && end!=-1){
					delimiter = numbers.substring(start+1, end);
				}else{
					delimiter=Character.toString(numbers.charAt(2));
				}
					newstring=numbers.substring(numbers.indexOf("\n")+1);
					arrSplit = newstring.replace(delimiter,"-").split("-");
				}
				else{
					arrSplit = numbers.split(",|\\n");
				}
			 for (int i=0; i < arrSplit.length; i++){
				int temp=Integer.parseInt(arrSplit[i].trim());
				if(temp<0){
					negatives.add(temp);
				}
				if(temp>1000){
					temp=0;
				}
				sum+=temp;
			 }
			 if(negatives.size()>0)throw new RuntimeException("negatives not allowed-"+negatives);

			return sum;
		}
	}

	 public int GetCalledCount(){
		 return count;
	 }


	public static void main(String[] args){
		StringCalculator s=new StringCalculator();
		try{
		int value=s.Add("");
		int value1=s.Add("1");
		int value2=s.Add("1,2");
		int value3=s.Add("1,2,3,4,51,9"); //Test Case 2 passed
		int value4=s.Add("1\n2,3"); //Test Case 3 passed
		int value5=s.Add("//;\n1;2;7");//Test Case 4 passed
//		int value6=s.Add("1,-1,-2"); //Test case 5 passed
		int counter=s.GetCalledCount();//Test case 7 passed
		int value7=s.Add("//;\n1;1200;7");
		int value8=s.Add("//[***]\n1***2***3");
	  	System.out.println("Input:''  Output:"+value);
	  	System.out.println("Input:'1'  Output:"+value1);
		System.out.println("Input:'1,2'  Output:"+value2);
		System.out.println("Input:'1,2,3,4,51,9'  Output:"+value3);
		System.out.println("Input:'1\\n2,3'  Output:"+value4);
		System.out.println("Input:'//;\\n1;2;7'  Output:"+value5);
		System.out.println("Count--"+counter);
		System.out.println("Input:'//;\\n1;1200;7'  Output:"+value7);
		System.out.println("Input:'//[***]\\n1***2***3'  Output:"+value8);
	}catch(RuntimeException e){
		System.out.println(e);
	}
	}
}
