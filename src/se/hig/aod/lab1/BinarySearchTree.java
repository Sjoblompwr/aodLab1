package se.hig.aod.lab1;

public class BinarySearchTree<T extends Comparable<? super T>> implements SearchableDataStructure {

    int size = 0;
    TreeNode root;
    private class TreeNode{
        Comparable data;
        TreeNode left;
        TreeNode right;

        TreeNode(Comparable element){
            data = element;
            size++;
        }
        Boolean hasNext(){return left != null || right != null;}
    }

    @Override
    public int size() {
        return size;
    }

    //rewrite this abomination.
    @Override
    public void addElement(Comparable newElement) {
        if(size == 0){
            root = new TreeNode(newElement);
        }
        //if new element smaller than current go left otherwise go rigtt.
        //go until data == null then set this to new.
        TreeNode currentNode = root;
        do{
            if(currentNode.data.compareTo(newElement) <= 0)
                currentNode = currentNode.left; 
            else
                currentNode = currentNode.right;

            if(currentNode.data == null){
                currentNode.data = newElement;
                size++;
                break;
            }
            }while(true);
    }

    @Override
    public Comparable searchElement(Comparable elementToFind) {
        if(size == 0)
            return null;
        TreeNode currentNode = root;
        while(currentNode.hasNext()){

        }
        return null;
    }

}
