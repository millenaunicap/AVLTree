package AVLNode;
import java.util.Queue;
import java.util.LinkedList;



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

    private AVLNode<T> rotateRight(AVLNode<T> a) {
    	AVLNode<T> b, c;
    	b = a.getLeft();
    	if(b.getFatBal()== -1) {
    		a.setLeft(b.getRight());
    		b.setRight(a);
    		a.setFatBal(0);
    		a = b;
    		
    		}else {
    			
    			c = b.getRight();
    			b.setRight(c.getLeft());
    			c.setLeft(b);
    			a.setLeft(c.getRight());
    			c.setRight(a);
    			
    			if(c.getFatBal()== -1) {
    				a.setFatBal(1);
    			} else {
    				a.setFatBal(1);
    			} if(c.getFatBal()==1) {
    				b.setFatBal(-1);
    			} else {
    				b.setFatBal(0);
    			}
    			a = c;
    	}
    	a.setFatBal(0);
    	this.status = false;
    	return a;
    		
    	
    }

    private AVLNode<T> rotateLeft(AVLNode<T> a) {
    	
    	AVLNode<T> b, c;
    	b = a.getRight();
    	if(b.getFatBal()== 1) {
    		a.setRight(b.getLeft());
    		b.setLeft(a);
    		a.setFatBal(0);
    		a = b;
    		
    		} else {
    			
    			c = b.getLeft();
    			b.setLeft(c.getRight());
    			c.setRight(b);
    			a.setRight(c.getRight());
    			c.setLeft(a);
    			
    			if(c.getFatBal()== 1) {
    				a.setFatBal(-1);
    			} else {
    				a.setFatBal(0);
    			} if(c.getFatBal()==-1) {
    				b.setFatBal(1);
    			} else {
    				b.setFatBal(0);
    			}
    			a = c;
        
    		}
    	a.setFatBal(0);
    	this.status = false;
    	return a;
    
 
    }
    
    public void emOrdem () {
    	if (this.isEmpty() == true) {
    		System.out.println("Árvore vazia");
    		} else {
    			this.percorrerEmOrdem (root);}}
    
    private void percorrerEmOrdem(AVLNode<T> r) {
        if (r != null) {
            percorrerEmOrdem(r.getLeft());
            System.out.println(r.getInfo());
            percorrerEmOrdem(r.getRight());
        }
    }
    
    
    	public void passeioPorNivel() {
    	    Queue<AVLNode<T>> fila = new LinkedList<>();
    	    AVLNode<T> aux;

    	    if (!this.isEmpty()) {
    	        fila.offer(root);

    	        while (!fila.isEmpty()) {
    	            aux = fila.poll();

    	            if (aux.getLeft() != null) {
    	                fila.offer(aux.getLeft());
    	            }
    	            if (aux.getRight() != null) {
    	                fila.offer(aux.getRight());
    	            }

    	            System.out.println(aux.getInfo());
    	        }
    	    }
    	}
    
}  
        
  

