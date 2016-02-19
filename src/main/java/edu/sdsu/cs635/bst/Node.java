package edu.sdsu.cs635.bst;

/**
 * This class represent a node in BST. It holds pointers to the parent, left and
 * right nodes. It holds the value of the node.
 *
 * @param <T>
 *            The generic type indicating the type of value
 */
public class Node<T extends Comparable<T>> {

	private T value;

	private Node<T> parent;
	private Node<T> left;
	private Node<T> right;

	public Node(T value) {
		this.value = value;
	}

	public Node(T value, Node<T> parent) {
		this.value = value;
		this.parent = parent;
	}

	public void insert(T valueToInsert) {
		if (value.compareTo(valueToInsert) > 0) {
			if (left == null) {
				left = new Node<T>(valueToInsert, this);
			} else {
				left.insert(valueToInsert);
			}
		} else {
			if (right == null) {
				right = new Node<T>(valueToInsert, this);
			} else {
				right.insert(valueToInsert);
			}
		}
	}

	public Node<T> getParent() {
		return parent;
	}

	public Node<T> getLeft() {
		return left;
	}

	public Node<T> getRight() {
		return right;
	}

	public T getValue() {
		return value;
	}
}
