package AVLNode;

public class Main {
	
	
	    public static void main(String[] args) {
	        AVLTree<Integer> avlTree = new AVLTree<>();

	      
	        avlTree.insert(10);
	        avlTree.insert(5);
	        avlTree.insert(15);
	        avlTree.insert(3);
	        avlTree.insert(7);
	        avlTree.insert(12);
	        avlTree.insert(18);

	       
	        System.out.println("Travessia em ordem");
	        avlTree.emOrdem();
	        System.out.println("Travessia em ordem");
	        avlTree.passeioPorNivel();


	    }
	


}
