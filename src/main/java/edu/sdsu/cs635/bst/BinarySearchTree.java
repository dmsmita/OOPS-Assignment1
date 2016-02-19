package edu.sdsu.cs635.bst;

import java.util.Iterator;
import java.util.Stack;

/**
 * Binary Search Tree class implements the insert operation and iteration using
 * in-order and post-order traversal.
 *
 */
public class BinarySearchTree {

	private Node<String> root;

	/**
	 * If the BST is empty i.e., root is null, then the insertion operation
	 * results in creating a new node which will be the root node.
	 * 
	 * If the BST is not empty, Let the root decide where to place the new
	 * element.
	 * 
	 */
	public void insert(String value) {

		if (value == null) {
			throw new IllegalArgumentException("Value cannot be null");
		}

		if (root == null) {
			root = new Node<String>(value);
		} else {
			root.insert(value);
		}
	}

	/**
	 * The iterator uses a stack to implement in order traversal.
	 */
	private class BSTInOrderIterator implements Iterator<String> {

		private Stack<Node<String>> stack = new Stack<Node<String>>();

		/**
		 * On initialization of the Iterator, each element starting from the
		 * root, all the left nodes till the left most node of the tree is
		 * pushed to stack.
		 */
		public BSTInOrderIterator() {
			if (root != null) {
				Node<String> cur = root;
				while (cur != null) {
					stack.push(cur);
					cur = cur.getLeft();
				}
			}
		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}

		/**
		 * The next element is the top of the stack. if there is a right node
		 * available for the current node on the top of the stack, again push
		 * all the left nodes to the stack.
		 **/
		public String next() {
			Node<String> node = stack.pop();
			String returnVal = node.getValue();
			if (node.getRight() != null) {
				node = node.getRight();
				while (node != null) {
					stack.push(node);
					node = node.getLeft();
				}
			}
			return returnVal;
		}

		public void remove() {
			throw new UnsupportedOperationException("Yet to implement");
		}
	}

	/**
	 * The iterator uses a stack to implement post order traversal.
	 */
	private class BSTPostOrderIterator implements Iterator<String> {

		private Stack<Node<String>> stack = new Stack<Node<String>>();

		/**
		 * On initialization of the Iterator, each element starting from the
		 * root all the right nodes, till the right most node of the tree is
		 * pushed to stack.
		 */
		public BSTPostOrderIterator() {
			if (root != null) {
				Node<String> cur = root;
				while (cur != null) {
					stack.push(cur);
					cur = cur.getRight();
				}
			}
		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}

		/**
		 * The next element is the top of the stack. if there is a left node
		 * available for the current node on the top of the stack, again push
		 * all the right nodes to the stack.
		 **/
		public String next() {
			Node<String> node = stack.pop();
			String returnVal = node.getValue();
			if (node.getLeft() != null) {
				node = node.getLeft();
				while (node != null) {
					stack.push(node);
					node = node.getRight();
				}
			}
			return returnVal;
		}

		public void remove() {
			throw new UnsupportedOperationException("Yet to implement");
		}
	}

	/**
	 * Returns an iterator over the elements in this list in order sequence.
	 *
	 * @return an iterator over the elements in this list in in-order sequence
	 */
	public Iterator<String> inOrderIterate() {
		return new BSTInOrderIterator();
	}

	/**
	 * Returns an iterator over the elements in this list post-order sequence.
	 *
	 * @return an iterator over the elements in this list in post-order sequence
	 */
	public Iterator<String> postOrderIterate() {
		return new BSTPostOrderIterator();
	}
}