
public class ReverseStrinf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = ""; 
		String output = reverse(input);
		System.out.println(output);

	}
	
	private static String reverse(String input){
		
		String reverse = "";
		if(input.isEmpty() || input ==null){
		System.out.println("Empty and null string");
		}
		
		if(input.length()<=1){
			reverse = input;
		}else{
			String[] originalarray = input.split("\\s+");
					for(String item:originalarray){  
						reverse = item + " " +reverse ; 
					}
		}
		
		return reverse;
	}

}
