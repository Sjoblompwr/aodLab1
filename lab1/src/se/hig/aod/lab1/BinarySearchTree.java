package se.hig.aod.lab1;

public class BinarySearchTree<T extends Comparable<? super T>> implements SearchableDataStructure<T> {

    int size = 0;
    TreeNode root;
    private class TreeNode{
        T data;
        TreeNode left;
        TreeNode right;

        TreeNode(T element){
            data = element;
        }
    }

    @Override
    public int size() {
        return size;
    }

    //rewrite this abomination.
    @Override
    public void addElement(T newElement) {
        if(newElement == null)
            throw new IllegalArgumentException("Element cannot be null");
        if(size == 0){
            root = new TreeNode(newElement);
            size++;
        }
        else{
        //if new element smaller than current go left otherwise go rigtt.
        //go until data == null then set this to new.
            if(addElementRecursively(root, newElement))
                size++;
        }
    }

    private boolean addElementRecursively(TreeNode currentNode, T newElement){
        if(currentNode.data.compareTo(newElement) > 0){
            //new element smaller go left.
            if(currentNode.left == null){
                currentNode.left = new TreeNode(newElement);
                return true;
            }
            else
                return addElementRecursively(currentNode.left, newElement);
        }
        else if(currentNode.data.compareTo(newElement) < 0){
            //Go right
            if(currentNode.right == null){
                currentNode.right = new TreeNode(newElement);
                return true;
            }
            else
                return addElementRecursively(currentNode.right, newElement);
        }
        else{
            //Element already exist, so we skip it.
            return false;
        }
    }

    @Override
    public T searchElement(T elementToFind) {
        if(elementToFind == null)
            throw new IllegalArgumentException("Element cannot be null");
        if(size == 0)
            return null;
        return searchElementRecursively(root, elementToFind);
    }

    private T searchElementRecursively(TreeNode currentNode,T elementToFind){
        if(currentNode == null)
            return null;
        if(currentNode.data.compareTo(elementToFind) == 0)
            return currentNode.data;
        else if(currentNode.data.compareTo(elementToFind) > 0)
            return searchElementRecursively(currentNode.left, elementToFind);
        else
            return searchElementRecursively(currentNode.right, elementToFind);
    }


    @Override
    public String toString(){
        String result = "";
        return inOrder(root,result);
    }

    private String inOrder(TreeNode node, String result) {
        if(node == null)
            return result;
        result = inOrder(node.left, result);
        result += node.data;
        result = inOrder(node.right, result);
        return result;
    }


}
