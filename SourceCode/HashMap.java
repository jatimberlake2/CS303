
public class HashMap{
  private int TABLE_SIZE;
  HashEntry[] table;

  HashMap(int size) {
	  TABLE_SIZE = size;
	  table = new HashEntry[size];
  }
  
  public String get(long key) {
	  long hash = key%TABLE_SIZE;
	  if (table[(int)hash] == null)
			 return "not here";
  	 while (table[(int)hash].getKey() != key)
   	{
   		if (table[(int)(7*hash+1)%TABLE_SIZE] != null)
   		   	hash = (7*hash+1)%TABLE_SIZE;
   		else
   			return "not here";
   	}
  	 return table[(int)hash].getValue();
  }

  public void put(long key, String value) {
      long hash = key % TABLE_SIZE;
      while (table[(int)hash] != null)
      {    	 
    	  if (table[(int)hash].getKey() != key)
    		      hash = (7*hash+1)%TABLE_SIZE;
    	  else
    	  {
    		  table[(int)hash].setValue(value);
    		  break;
    	  }

      }
          table[(int)hash] = new HashEntry(key, value);
  }

  public void printTable()
{
	for (long i = 0; i < TABLE_SIZE; i++)
	{
		if (table[(int)i] != null) {
			if (i > 9)
				System.out.println(i + " : " + table[(int)i].getValue());
			else
				System.out.println("0" + i + " : " + table[(int)i].getValue());
		}

		else
		{
			if (i > 9)
				System.out.println(i + " : [empty]");
			else
				System.out.println("0" + i + " : [empty]");
		}
	}
}
  
  public void linearProbe(long key, String value){
      long hash = key % TABLE_SIZE;
      while (table[(int)hash] != null)
      {
    	  if (table[(int)hash].getKey() != key)
    		      hash = (hash+1)%TABLE_SIZE;
    	  else
    	  {
    		  table[(int)hash].setValue(value);
    		  break;
    	  }
      }
          table[(int)hash] = new HashEntry(key, value);
  }
  
  public String getLinearProbe(long key) {
	  long hash = key%TABLE_SIZE;
	  if (table[(int)hash] == null)
			 return "not here";
  	 while (table[(int)hash].getKey() != key)
   	{
   		if (table[(int)(7*hash+1)%TABLE_SIZE] != null)
   		   	hash = (hash+1)%TABLE_SIZE;
   		else
   			return "not here";
   	}
  	 return table[(int)hash].getValue();
  }

  public void quadraticProbe(long key, String value){
      long hash = key % TABLE_SIZE;
      int square = 2;
      while (table[(int)hash] != null)
      {
    	  if (table[(int)hash].getKey() != key)
    		      hash = (hash+1)%TABLE_SIZE;
    	  else
    	  {
    		  hash = (hash+square*square)%TABLE_SIZE;
    		  break;
    	  }
    	  square++;
      }
          table[(int)hash] = new HashEntry(key, value);
  }
  
  public String getQuadraticProbe(long key) {
	  long hash = key%TABLE_SIZE;
      int square = 2;
	  if (table[(int)hash] == null)
			 return "not here";
  	 while (table[(int)hash].getKey() != key)
   	{
   		if (table[(int)(7*hash+1)%TABLE_SIZE] != null)
   			hash = (hash+square*square)%TABLE_SIZE;
   		else
   			return "not here";
   	}
  	 return table[(int)hash].getValue();
  }
  
}

