package AVLNode;
import java.util.LinkedList;
import java.util.Queue;

public class AVLTree<T extends Comparable<T>> {
    private AVLNode<T> root;
    private boolean status;

    private boolean isEmpty() {
        return root == null;
    }

    public void insert(T value) {
        if (this.isEmpty()) {
            this.root = new AVLNode<>(value);
            this.status = true;
        } else {
            this.root = insertNode(this.root, value);
        }
    }

    private AVLNode<T> insertNode(AVLNode<T> r, T value) {
        if (r == null) {
            r = new AVLNode<>(value);
            this.status = true;
        } else if (r.getInfo().compareTo(value) > 0) {
            r.setLeft(insertNode(r.getLeft(), value));
            if (this.status) {
                switch (r.getFatBal()) {
                    case 1:
                        r.setFatBal(0);
                        this.status = false;
                        break;
                    case 0:
                        r.setFatBal(-1);
                        break;
                    case -1:
                        r = this.rotateRight(r);
                        break;
                }
            }
        } else {
            r.setRight(insertNode(r.getRight(), value));
            if (this.status) {
                switch (r.getFatBal()) {
                    case -1:
                        r.setFatBal(0);
                        this.status = false;
                        break;
                    case 0:
                        r.setFatBal(1);
                        break;
                    case 1:
                        r = this.rotateLeft(r);
                        break;
                }
            }
        }
        return r;
    }

    private AVLNode<T> rotateRight(AVLNode<T> y) {
        AVLNode<T> x = y.getLeft();
        AVLNode<T> temp = x.getRight();

        x.setRight(y);
        y.setLeft(temp);

        y.setFatBal(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setFatBal(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        return x;
    }

    private AVLNode<T> rotateLeft(AVLNode<T> x) {
        AVLNode<T> y = x.getRight();
        AVLNode<T> temp = y.getLeft();

        y.setLeft(x);
        x.setRight(temp);

        x.setFatBal(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setFatBal(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
        
    }
    
    private int height(AVLNode<T> node) {
        if (node == null) {
            return 0;
        }
    
        return Math.max(height(node.getLeft()), height(node.getRight()));
        
    	}
    
    public void emOrdem () {
    	if (this.isEmpty() == true) {
    		System.out.println("Árvore vazia");
    		} else {
    			this.percorrerEmOrdem (root);}}
    
    private void percorrerEmOrdem (	AVLNode r) {
    	if (r != null) {
    		percorrerEmOrdem (r.getLeft());
    		System.out.println(r.getInfo());
    		percorrerEmOrdem (r.getRight());}}
    
    public void passeioPorNivel() {
        Queue<AVLNode<T>> fila;
        AVLNode<T> aux;

        if (this.isEmpty() == false) {
            fila = new LinkedList<>();
            fila.add(root);
            while (!fila.isEmpty()) {
                aux = fila.poll();
                if (aux.getLeft() != null) {
                    fila.add(aux.getLeft());
                }
                if (aux.getRight() != null) {
                    fila.add(aux.getRight());
                }
                System.out.println(aux.getInfo());
            }
        }
    }
}
