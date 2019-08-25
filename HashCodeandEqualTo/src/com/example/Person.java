package com.example;

import java.util.Date;

public class Person implements Comparable<Person>{
	   private String name;
	   private int id;
	   private Date dob;

	    public Person(String name, int id, Date dob) {
	        this.name = name;
	        this.id = id;
	        this.dob = dob;
	    }

	    
	    
		@Override
		public boolean equals(Object obj) {
			if(this == obj )  return true;
			
			if(obj == null || (this.getClass()!=obj.getClass())) 
			{
				return false;
			}
			
			Person guest = (Person) obj;
			return (this.id == guest.id)&&
					(this.name!=null && name.equals(guest.name))&&
					(this.dob !=null && dob.equals(guest.dob));
			
		}



		@Override
		public int hashCode() {
			
			int result = 0;
			result = result * 31 + id;
			result = result * 31 + (name !=null ? name.hashCode() : 0);
			result = result * 31 + (dob != null ? dob.hashCode(): 0);
		return result;
		}



		@Override
		public int compareTo(Person p) {
			return this.id - p.id;
		}
	    
	    
}    
