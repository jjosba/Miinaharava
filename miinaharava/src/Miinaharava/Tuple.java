package Miinaharava;

public class Tuple {
	public final Integer rivi;
    public final Integer solu;
	
    public Tuple(Integer rivi, Integer solu) {
    	this.rivi = rivi;
		this.solu = solu;
	}

	public Integer getRivi() {
		return rivi;
	}

	public Integer getSolu() {
		return solu;
	}
    
    @Override
    public String toString() {
    	return this.rivi + " " + this.solu;
    }
    
	
	  @Override
	  public boolean equals(Object obj) {
		  if (this == obj) { 
			  return true;
		  } 
		  
		  if (obj == null) { 
			  return false; 
		  }
	  
		  if (obj.getClass() != Tuple.class) {
			  return false; 
		  }
	  
		  Tuple toinen = (Tuple) obj;
	  
		  return (rivi == toinen.rivi && solu == toinen.solu);
	  
	  }
	 
   	
    }

