import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Testing 
{
	public static void main(String[] args)
	{
		String text = "test a=\"1\" b=\"2\" c=\"3\" bar d=\"4\" e=\"5\"";
		String s = "(?<let>[a-z]*)((?:[ \t]+[a-z]=\"[0-9]\")*)";
		//Pattern p = Pattern.compile(s);
		//Matcher m = p.matcher("aasdfsadf as aa a ");
		Matcher m = Pattern.compile(s).matcher(text);
		
		/*
		while(m.find()){
			System.out.println(m.group("let"));
		}*/
		
		m.find();
		System.out.println(m.group("let"));
	}
	

}
