package ctci.chapter4;


interface Tree {

    void inOrderTreeWalk();

    void add(Integer element);

    Integer findMinimum();

    Integer findMaximum();

    void remove(Integer data);

    BST.Node getRoot();
}
