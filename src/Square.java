
public class Square 
{
	private String displaySymbol = " - "; //default empty
	Color color = null;
	public Square()
	{
		
	}
	
	public String getDisplaySymbol()
	{
		return displaySymbol;
	}
	
	public void setDisplaySymbol(String newSymbol)
	{
		displaySymbol = " " + newSymbol + " ";
	}
	
	public void clearSymbol()
	{
		displaySymbol = " - ";
	}
	
	public boolean isEmpty()
	{
		if(displaySymbol.equals(" - "))
		{
			return true;
		}
		else
			return false;
	}
	
	public String takeSymbol()
	{
		String temp = this.displaySymbol;
		clearSymbol();
		return temp;
	}
	
	

}
