package edu.sdsu.cs635.bst;

import java.util.Iterator;

public class Assignment1 {

	private BinarySearchTree bst = new BinarySearchTree();
	
	public void insert(String value){
		bst.insert(value);
	}

	public void printAlphabeticalOrder() {
		Iterator<String> iterator = bst.inOrderIterate();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public void printElementsStartingWithVowelsInReverseAlphabeticalOrder() {
		Iterator<String> iterator = bst.postOrderIterate();

		while (iterator.hasNext()) {
			String value = iterator.next();
			if(value.matches("[aeiouAEIOU].*")){
				System.out.println(value);	
			}
		}
	}
}
