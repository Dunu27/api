package practice;
import practice.*;
public class  StringReverseRecursion {

	public static void main(String[] args) {
    String s="welcome to tyss welcome to class";
    String reverse=recursion(s);
     System.out.println(reverse);    
}
public static String recursion(String s){
if(s.isEmpty())
 return s;
else
	
	
return recursion(s.substring(1))+s.charAt(0); 


}

}
	


