package fruits;

public class Fruit implements Comparable<Fruit>
{
	private int sweetness;

	public Fruit(int s)
	{
		this.sweetness = s;
	}
	
	public int compareTo(Fruit that)
	{
		if( this.sweetness < that.sweetness )
			return -1;
		else if ( this.sweetness > that.sweetness )
			return 1;
		else
			return 0;
	}
	
	
}
