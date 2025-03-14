package counterADT;

public class CounterComplete implements CounterADT 
{
	//attribute
	private int count;
	
	public CounterComplete() 
	{
		super();
	}
	
	public CounterComplete(int count) 
	{
		this.count = count;
	}
	
	@Override
	public void setCounter(int count) throws InvalidCounterException 
	{
		if( count < 0 )
		{
			throw new InvalidCounterException("Value must be non-negative.");
		}
		this.count = count;
	}

	@Override
	public void incCounter() 
	{
		this.count++;
	}

	@Override
	public void decCounter() throws InvalidCounterException 
	{
		if( this.count == 0 )
		{
			throw new InvalidCounterException("Counter cannot be decremented.");
		}
		this.count--;
	}

	@Override
	public int getCounter() 
	{
		return this.count;
	}

	@Override
	public boolean isZero() 
	{
		if( this.count == 0 )
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String toString()
	{
		return "Counter value is: " + this.count;
		
	}
}
