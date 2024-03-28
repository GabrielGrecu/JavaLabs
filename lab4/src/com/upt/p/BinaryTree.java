package com.upt.p;

class Nod {
    int cheie;
    Nod left, right;

    Nod(int item) {
        cheie = item;
        left = right = null;
    }
}

class BinaryTree {
    Nod root;

    BinaryTree() {
        root = null;
    }

    Nod insert(Nod nod, int cheie) {
        if (nod == null) {
            return new Nod(cheie);
        }
        if (cheie < nod.cheie) {
            nod.left = insert(nod.left, cheie);
        } else if (cheie > nod.cheie) {
            nod.right = insert(nod.right, cheie);
        }
        return nod;
    }

    boolean isAVL(Nod nod) {
        if (nod == null) {
            return true;
        }
        int leftHeight = getHeight(nod.left);
        int rightHeight = getHeight(nod.right);
        if (Math.abs(leftHeight - rightHeight) <= 1 && isAVL(nod.left) && isAVL(nod.right)) {
            return true;
        }
        return false;
    }

    int getHeight(Nod nod) {
        if (nod == null) {
            return 0;
        }
        int leftHeight = getHeight(nod.left);
        int rightHeight = getHeight(nod.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    void inorderTraversal(Nod nod) {
        if (nod != null) {
            inorderTraversal(nod.left);
            System.out.print(nod.cheie + " ");
            inorderTraversal(nod.right);
        }
    }



    Nod findMin(Nod nod) {
        while (nod.left != null) {
            nod = nod.left;
        }
        return nod;
    }

    Nod removeNode(Nod root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.cheie) {
            root.left = removeNode(root.left, key);
        } else if (key > root.cheie) {
            root.right = removeNode(root.right, key);
        } else {
            if (root.left == null) {
                Nod temp = root.right;
                root = null;
                return temp;
            } else if (root.right == null) {
                Nod temp = root.left;
                root = null;
                return temp;
            }
            Nod temp = findMin(root.right);
            root.cheie = temp.cheie;
            root.right = removeNode(root.right, temp.cheie);
        }
        return root;
    }

    Nod removeEven(Nod root) {
        if (root == null) {
            return null;
        }
        root.left = removeEven(root.left);
        root.right = removeEven(root.right);
        if (root.cheie % 2 == 0) {
            root = removeNode(root, root.cheie);
        }
        return root;
    }

    boolean isPerfectlyBalanced(Nod root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight != rightHeight) {
            return false;
        }
        return isPerfectlyBalanced(root.left) && isPerfectlyBalanced(root.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] keys = { 12, -7, 45, 32, 2, 22, 1, 2, 3, 4, 9, 90, 89, 225, 0 };
        for (int key : keys) {
            tree.root = tree.insert(tree.root, key);
        }

        System.out.print("Arbore in ordine: ");
        tree.inorderTraversal(tree.root);
        System.out.println();
        if (tree.isAVL(tree.root)) {
            System.out.println("Arborele este echilibrat in sens AVL.");
        } else {
            System.out.println("Arborele NU este echilibrat in sens AVL.");
        }
        tree.root = tree.removeEven(tree.root);
        System.out.print("Arbore inordine dupa eliminarea numerelor pare: ");
        tree.inorderTraversal(tree.root);
        System.out.println();
        if (tree.isPerfectlyBalanced(tree.root)) {
            System.out.println("Arborele este perfect echilibrat.");
        } else {
            System.out.println("Arborele NU este perfect echilibrat.");
        }
    }
}
