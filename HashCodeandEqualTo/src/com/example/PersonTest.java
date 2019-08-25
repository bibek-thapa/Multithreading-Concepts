package com.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class PersonTest {

	@Test
	   public void testEquals(){
	       Person james = new Person("James", 21, new Date(1980,12, 1));
	       Person same = new Person("James", 21, new Date(1980,12, 1));
	       Person similar = new Person("Harry", 21, new Date(1981,12,1));
	       
	assertTrue(james.equals(same));
	assertTrue(james.hashCode() == same.hashCode());
	
	assertFalse(james.equals(null));
	assertFalse(james.equals(similar));
	
	assertTrue(james.hashCode() != similar.hashCode() );
	
	}    
	
}
