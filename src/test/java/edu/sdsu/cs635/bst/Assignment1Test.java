package edu.sdsu.cs635.bst;

import org.junit.Before;
import org.junit.Test;

public class Assignment1Test {

	private Assignment1 assignment1 = new Assignment1();

	@Before
	public void setup(){
		assignment1.insert("mango");
		assignment1.insert("apple");
		assignment1.insert("pineapple");
		assignment1.insert("grapes");
		assignment1.insert("pear");
		assignment1.insert("orange");
		assignment1.insert("banana");
	}

	@Test
	public void testPrintAlphabeticalOrder() {
		assignment1.printAlphabeticalOrder();
	}

	@Test
	public void testPrintElementsStartingWithVowelsInReverseAlphabeticalOrder() {
		assignment1.printElementsStartingWithVowelsInReverseAlphabeticalOrder();
	}
}
