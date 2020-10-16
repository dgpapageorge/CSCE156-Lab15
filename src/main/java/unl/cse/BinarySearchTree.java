package unl.cse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
import java.util.List;

public class BinarySearchTree<T> {

	private TreeNode<T> root;
	private final Comparator<T> comparator;

	public BinarySearchTree(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public boolean containsElement(T item) {
		return (this.findElement(item) != null);
	}

	public int getMaxDepth() {
		if (root == null || (root.getLeftChild() == null && root.getRightChild() == null)) {
			return 0;
		}

		// this method uses a "tree-walk" algorithm
		TreeNode<T> curr = root;
		TreeNode<T> prev = null;
		int depth = 0;
		int maxDepth = depth;
		while (curr != null) {
			if (curr.getParent() == prev) {
				if (curr.getLeftChild() != null) {
					prev = curr;
					curr = curr.getLeftChild();
					depth++;
					maxDepth = Math.max(maxDepth, depth);
				} else if (curr.getRightChild() != null) {
					prev = curr;
					curr = curr.getRightChild();
					depth++;
					maxDepth = Math.max(maxDepth, depth);
				} else {
					prev = curr;
					curr = curr.getParent();
					depth--;
				}
			} else if (curr.getLeftChild() == prev) {
				if (curr.getRightChild() != null) {
					prev = curr;
					curr = curr.getRightChild();
					depth++;
					maxDepth = Math.max(maxDepth, depth);
				} else {
					prev = curr;
					curr = curr.getParent();
					depth--;
				}
			} else if (curr.getRightChild() == prev) {
				prev = curr;
				curr = curr.getParent();
				depth--;
			} else {
				throw new IllegalStateException("Current/Previous: " + curr.getValue() + ", " + prev.getValue());
			}
		}
		return maxDepth;
	}

	private int getDepth(TreeNode<T> node) {
		int depth = 0;
		TreeNode<T> curr = node;
		while (curr != root) {
			curr = curr.getParent();
			depth++;
		}
		return depth;
	}

	public int getNumNodes() {

		int count = 0;

		if (root == null)
			return count;
		// this method uses a stack-based preorder traversal
		Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
		TreeNode<T> curr = root;
		while (curr != null) {
			if (curr.getRightChild() != null)
				s.push(curr.getRightChild());
			if (curr.getLeftChild() != null)
				s.push(curr.getLeftChild());

			count++;
			if (s.isEmpty())
				curr = null;
			else
				curr = s.pop();
		}
		return count;
	}

	public void addElement(T item) {
		if (item == null)
			throw new IllegalArgumentException("BinarySearchTree does not allow null elements");
		if (containsElement(item))
			throw new IllegalStateException("BinarySearchTree does not allow duplicate elements");
		TreeNode<T> newNode = new TreeNode<T>(item);
		if (root == null) {
			root = newNode;
			return;
		}
		TreeNode<T> curr = root;
		TreeNode<T> prev = null;
		while (curr != null) {
			if (this.comparator.compare(curr.getValue(), item) > 0) {
				prev = curr;
				curr = curr.getLeftChild();
			} else {
				prev = curr;
				curr = curr.getRightChild();
			}
		}
		if (this.comparator.compare(prev.getValue(), item) > 0) {
			prev.setLeftChild(newNode);
			newNode.setParent(prev);
		} else {
			prev.setRightChild(newNode);
			newNode.setParent(prev);
		}
	}

	@Override
	public String toString() {
		if (root == null)
			return "[empty]";

		StringBuilder sb = new StringBuilder();
		Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
		TreeNode<T> curr = root;
		while (curr != null) {
			if (curr.getRightChild() != null)
				s.push(curr.getRightChild());
			if (curr.getLeftChild() != null)
				s.push(curr.getLeftChild());

			for (int i = 0; i < getDepth(curr); i++)
				sb.append(" ");
			sb.append("|-" + curr.getValue() + "\n");
			if (s.isEmpty())
				curr = null;
			else
				curr = s.pop();
		}
		return sb.toString();
	}

	public T findElement(T item) {
		if (root == null)
			return null;

		T result = null;
		// TODO: implement this
		return result;
	}

	public int getNumLeaves() {
		// TODO: implement this
		return 0;
	}

	public List<T> preOrderTraverse() {
		List<T> elements = new ArrayList<>();
		// TODO: implement this

		return elements;
	}

	public List<T> inOrderTraverse() {
		List<T> elements = new ArrayList<>();
		// TODO: implement this

		return elements;
	}

	public List<T> postOrderTraverse() {
		List<T> elements = new ArrayList<>();
		// TODO: implement this

		return elements;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		BinarySearchTree other = (BinarySearchTree) obj;

		Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
		Stack<TreeNode<T>> t = new Stack<TreeNode<T>>();

		TreeNode<T> sCurr = this.root;
		TreeNode<T> tCurr = other.root;
		while (sCurr != null && tCurr != null) {

			if (sCurr.getRightChild() != null)
				s.push(sCurr.getRightChild());
			if (tCurr.getRightChild() != null)
				t.push(tCurr.getRightChild());

			if (sCurr.getLeftChild() != null)
				s.push(sCurr.getLeftChild());
			if (tCurr.getLeftChild() != null)
				t.push(tCurr.getLeftChild());

			if (!sCurr.equals(tCurr)) {
				return false;
			}
			if (s.isEmpty())
				sCurr = null;
			else
				sCurr = s.pop();
			if (t.isEmpty())
				tCurr = null;
			else
				tCurr = t.pop();
		}

		if (sCurr != null || tCurr != null) {
			return false;
		}
		return true;
	}

}
