package utilities;

import java.io.Serializable;

/**
 * A node class for a binary search tree.
 *
 * @param <E> The type of data stored in the node.
 */
public class BSTreeNode<E> implements Serializable {
    private static final long serialVersionUID = 5946579676861487139L;

    /**
     * The data stored in the node.
     */
    private E data;

    /**
     * The left child of the node.
     */
    private BSTreeNode<E> left;

    /**
     * The right child of the node.
     */
    private BSTreeNode<E> right;

    /**
     * Constructs a BSTreeNode with the given data.
     *
     * @param data The data to be stored in the node.
     */
    public BSTreeNode(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    /**
     * Constructs a BSTreeNode with the given data, left child, and right child.
     *
     * @param data The data to be stored in the node.
     * @param l    The left child of the node.
     * @param r    The right child of the node.
     */
    public BSTreeNode(E data, BSTreeNode<E> l, BSTreeNode<E> r) {
        this.data = data;
        this.left = l;
        this.right = r;
    }

    /**
     * Gets the data stored in the node.
     *
     * @return The data stored in the node.
     */
    public E getElement() {
        return data;
    }

    /**
     * Sets the data stored in the node.
     *
     * @param data The data to be stored in the node.
     */
    public void setElement(E data) {
        this.data = data;
    }

    /**
     * Gets the left child of the node.
     *
     * @return The left child of the node.
     */
    public BSTreeNode<E> getLeft() {
        return left;
    }

    /**
     * Sets the left child of the node.
     *
     * @param left The left child of the node.
     */
    public void setLeft(BSTreeNode<E> left) {
        this.left = left;
    }

    /**
     * Gets the right child of the node.
     *
     * @return The right child of the node.
     */
    public BSTreeNode<E> getRight() {
        return right;
    }

    /**
     * Sets the right child of the node.
     *
     * @param right The right child of the node.
     * @return The right child.
     */
    public BSTreeNode<E> setRight(BSTreeNode<E> right) {
        this.right = right;
        return right;
    }
}
