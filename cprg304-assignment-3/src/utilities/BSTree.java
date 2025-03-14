package utilities;

import exceptions.TreeException;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * A binary search tree implementation.
 *
 * @param <E> The type of elements in the tree, must be comparable.
 */
public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E> {

    /**
     * Serial version UID for serialization.
     */
    private static final long serialVersionUID = 5946579676861487139L;

    /**
     * The root node of the binary search tree.
     */
    private BSTreeNode<E> root;

    /**
     * The size of the binary search tree.
     */
    private int size;

    /**
     * Constructs an empty binary search tree.
     */
    public BSTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Constructs a binary search tree with a given root element.
     *
     * @param element The root element of the tree.
     */
    public BSTree(E element) {
        this.root = new BSTreeNode<E>(element);
        this.size = 1;
    }

    @Override
    public BSTreeNode<E> getRoot() throws TreeException {
        if (this.root == null) {
            throw new TreeException("Tree is empty");
        }
        return this.root;
    }

    @Override
    public int getHeight() {
        return getHeight(this.root);
    }

    private int getHeight(BSTreeNode<?> tree) {
        if (tree == null) {
            return 0;
        } else {
            int maxHeight = Math.max(getHeight(tree.getLeft()), getHeight(tree.getRight()));
            return maxHeight + 1;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void clear() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public boolean contains(E entry) throws TreeException {
        if (root == null) {
            throw new TreeException("Tree is empty");
        }

        BSTreeNode<E> current = this.root;
        while (current != null) {
            if (entry.compareTo(current.getElement()) == 0) {
                return true;
            } else {
                if (entry.compareTo(current.getElement()) > 0) {
                    current = current.getRight();
                } else {
                    current = current.getLeft();
                }
            }
        }
        return false;
    }

    @Override
    public BSTreeNode<E> search(E entry) throws TreeException {
        if (root == null) {
            throw new TreeException("Tree is empty");
        }

        BSTreeNode<E> current = this.root;
        while (current != null) {
            if (entry.compareTo(current.getElement()) == 0) {
                return current;
            } else {
                if (entry.compareTo(current.getElement()) > 0) {
                    current = current.getRight();
                } else {
                    current = current.getLeft();
                }
            }
        }
        return null;
    }

    @Override
    public boolean add(E newEntry) throws NullPointerException {
        if (newEntry == null) {
            throw new NullPointerException();
        }

        if (this.root == null) {
            this.root = new BSTreeNode<E>(newEntry);
            this.size++;
            return true;
        }

        BSTreeNode<E> current = this.root;
        while (true) {
            if (newEntry.compareTo(current.getElement()) == 0) {
                return false; // Element already exists
            } else if (newEntry.compareTo(current.getElement()) > 0) {
                if (current.getRight() == null) {
                    current.setRight(new BSTreeNode<E>(newEntry));
                    this.size++;
                    return true;
                } else {
                    current = current.getRight();
                }
            } else {
                if (current.getLeft() == null) {
                    current.setLeft(new BSTreeNode<E>(newEntry));
                    this.size++;
                    return true;
                } else {
                    current = current.getLeft();
                }
            }
        }
    }

    @Override
    public Iterator<E> inorderIterator() {
        return new BSTreeIterator(root, "inorder");
    }

    @Override
    public Iterator<E> preorderIterator() {
        return new BSTreeIterator(root, "preorder");
    }

    @Override
    public Iterator<E> postorderIterator() {
        return new BSTreeIterator(root, "postorder");
    }

    private class BSTreeIterator implements Iterator<E> {

        private BSTreeNode<E> current;
        private Stack<E> stack;

        public BSTreeIterator(BSTreeNode<E> root, String order) {
            this.current = root;
            if (order.equals("inorder")) {
                this.stack = new Stack<E>();
                inorder(current);
            } else if (order.equals("preorder")) {
                this.stack = new Stack<E>();
                preorder(current);
            } else if (order.equals("postorder")) {
                this.stack = new Stack<E>();
                postorder(current);
            }
        }

        private void inorder(BSTreeNode<E> root) {
            if (root != null) {
                inorder(root.getRight());
                this.stack.push(root.getElement());
                inorder(root.getLeft());
            }
        }

        private void preorder(BSTreeNode<E> root) {
            if (root != null) {
                preorder(root.getRight());
                preorder(root.getLeft());
                this.stack.push(root.getElement());
            }
        }

        private void postorder(BSTreeNode<E> root) {
            if (root != null) {
                this.stack.push(root.getElement());
                postorder(root.getRight());
                postorder(root.getLeft());
            }
        }

        @Override
        public boolean hasNext() {
            return !this.stack.isEmpty();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return this.stack.pop();
        }
    }
}
