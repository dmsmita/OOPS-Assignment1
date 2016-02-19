package edu.sdsu.cs635.bst;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

	private BinarySearchTree bst;

	@Before
	public void setup() {
		bst = new BinarySearchTree();
	}

	@Test
	public void testInsert() {

		setupTestData();

		Iterator<String> iterator = bst.inOrderIterate();
		int count = countElements(iterator);

		Assert.assertEquals(7, count);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInsertWithNullValue() {
		bst.insert(null);
	}

	@Test
	public void testInOrderIterate() {
		setupTestData();

		List<String> expectedList = Arrays.asList("apple", "banana", "grapes", "mango", "orange", "pear", "pineapple");

		Iterator<String> iterator = bst.inOrderIterate();
		assertExpectedListFromIterator(expectedList, iterator);
	}

	@Test
	public void testInOrderIterateWithEmptyBST() {

		Iterator<String> iterator = bst.inOrderIterate();
		int count = countElements(iterator);

		Assert.assertEquals(0, count);
	}

	@Test
	public void testPostOrderIterate() {
		setupTestData();

		List<String> expectedList = Arrays.asList("pineapple", "pear", "orange", "mango", "grapes", "banana", "apple");

		Iterator<String> iterator = bst.postOrderIterate();
		assertExpectedListFromIterator(expectedList, iterator);
	}

	@Test
	public void testPostOrderIterateWithEmptyBST() {

		Iterator<String> iterator = bst.postOrderIterate();
		int count = countElements(iterator);

		Assert.assertEquals(0, count);
	}

	private int countElements(Iterator<String> iterator) {
		int count = 0;
		while (iterator.hasNext()) {
			count++;
			iterator.next();
		}
		return count;
	}

	private void setupTestData() {
		bst.insert("mango");
		bst.insert("apple");
		bst.insert("pineapple");
		bst.insert("grapes");
		bst.insert("pear");
		bst.insert("orange");
		bst.insert("banana");
	}

	private void assertExpectedListFromIterator(List<String> expectedList, Iterator<String> iterator) {
		int index = 0;
		while (iterator.hasNext()) {
			String value = iterator.next();
			Assert.assertEquals(expectedList.get(index), value);

			index++;
		}
	}
}