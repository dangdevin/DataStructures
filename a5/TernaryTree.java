package cs445.a5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;

import cs445.a5.StackAndQueuePackage.*; // Needed by tree iterators

//Devin Dang
//PeopleSoft ID: 4059282
//CS 445

public class TernaryTree<T> implements TernaryTreeInterface<T> {

   private TernaryNode<T> root;
   
   public TernaryTree(){
      root = null;
   }
   
   /** Sets the ternary tree to a new one-node ternary tree with the given data
     *  @param rootData  The data for the new tree's root node
     */
   public TernaryTree(T rootData){
      root = new TernaryNode<>(rootData);
  }
  public void setTree(T rootData)
  {
      root = new TernaryNode<>(rootData);
  }
  
  /** Sets this ternary tree to a new ternary tree
     *  @param rootData  The data for the new tree's root node
     *  @param leftTree  The left subtree of the new tree
     *  @param middleTree  The middle subtree of the new tree
     *  @param rightTree  The right subtree of the new tree
     */
   public void setTree(T rootData, TernaryTreeInterface<T> leftTree,TernaryTreeInterface<T> middleTree, TernaryTreeInterface<T> rightTree)
   {
        privateSetTree(rootData, (TernaryTree<T>)leftTree, (TernaryTree<T>)middleTree,(TernaryTree<T>)rightTree);
    }
    
    private void privateSetTree(T rootData, TernaryTree<T> leftTree, TernaryTree<T> midTree,
                                TernaryTree<T> rightTree) {
        root = new TernaryNode<>(rootData);

        if ((leftTree != null) && !leftTree.isEmpty()) {
            root.setLeftChild(leftTree.root);
        }

        if ((midTree != null) && !midTree.isEmpty()) {
            if (midTree != leftTree) {
                root.setMidChild(rightTree.root);
            } else {
                root.setMidChild(rightTree.root.copy());
            }
        }

        if ((rightTree != null) && !rightTree.isEmpty()) {
            if ((rightTree != midTree) && (rightTree != leftTree)) {
                root.setRightChild(rightTree.root);
            } else {
                root.setRightChild(rightTree.root.copy());
            }
        }

        if ((leftTree != null) && (leftTree != this)) {
            leftTree.clear();
        }
        
        if ((midTree != null) && (midTree != this)) {
            midTree.clear();
        }


        if ((rightTree != null) && (rightTree != this)) {
            rightTree.clear();
        }
    }

   
   /** Gets the data in the root node
     *  @return  the data from the root node
     *  @throws EmptyTreeException  if the tree is empty */
    public T getRootData(){
      if (isEmpty()) {
            throw new EmptyTreeException();
        } else {
            return root.getData();
        } 
   }

    /** Gets the height of the tree (i.e., the maximum number of nodes passed
     *  through from root to leaf, inclusive)
     *  @return  the height of the tree */
    public int getHeight(){
      return root.getHeight();
    }

    /** Counts the total number of nodes in the tree
     *  @return  the number of nodes in the tree */
    public int getNumberOfNodes(){
      return root.getNumberOfNodes();
   }

    /** Determines whether the tree is empty (i.e., has no nodes)
     *  @return  true if the tree is empty, false otherwise */
    public boolean isEmpty(){
      return root == null;
    }

    /** Removes all data and nodes from the tree */
    public void clear(){
      root = null;
   }
   
   /** Creates an iterator to traverse the tree in preorder fashion
    *  @return  the iterator */
    public Iterator<T> getPreorderIterator()
    {
         return null;
    }

   /** Creates an iterator to traverse the tree in postorder fashion
    *  @return  the iterator */
    public Iterator<T> getPostorderIterator(){
         return new PostorderIterator();
    }

   /** Creates an iterator to traverse the tree in level-order fashion
    *  @return  the iterator */
    public Iterator<T> getLevelOrderIterator(){
         return new LevelOrderIterator();
   }
   
   private class PreorderIterator implements Iterator<T> {
        private StackInterface<TernaryNode<T>> nodeStack;

        public PreorderIterator() {
            nodeStack = new LinkedStack<>();
            if (root != null) {
                nodeStack.push(root);
            }
        }

        public boolean hasNext() {
            return !nodeStack.isEmpty();
        }

        public T next() {
            TernaryNode<T> nextNode;

            if (hasNext()) {
                nextNode = nodeStack.pop();
                TernaryNode<T> leftChild = nextNode.getLeftChild();
                TernaryNode<T> midChild = nextNode.getMidChild();
                TernaryNode<T> rightChild = nextNode.getRightChild();

                // Push into stack in reverse order of recursive calls
                if (rightChild != null) {
                    nodeStack.push(rightChild);
                }
                
                if (midChild != null) {
                    nodeStack.push(midChild);
                }

                if (leftChild != null) {
                    nodeStack.push(leftChild);
                }
            } else {
                throw new NoSuchElementException();
            }

            return nextNode.getData();
        }
        
        public void remove() {
        	throw new UnsupportedOperationException();
        }
   }
   
   public void iterativePreorderTraverse() {
        StackInterface<TernaryNode<T>> nodeStack = new LinkedStack<>();
        if (root != null) {
            nodeStack.push(root);
        }
        TernaryNode<T> nextNode;
        while (!nodeStack.isEmpty()) {
            nextNode = nodeStack.pop();
            TernaryNode<T> leftChild = nextNode.getLeftChild();
            TernaryNode<T> midChild = nextNode.getMidChild();
            TernaryNode<T> rightChild = nextNode.getRightChild();

            // Push into stack in reverse order of recursive calls
            if (rightChild != null) {
                nodeStack.push(rightChild);
            }
            
            if (midChild != null) {
                nodeStack.push(midChild);
            }

            if (leftChild != null) {
                nodeStack.push(leftChild);
            }

            System.out.print(nextNode.getData() + " ");
        }
    }

   public Iterator<T> getInorderIterator() {
	   throw new UnsupportedOperationException();
    }
   
   //In-order traversal is usually used only on binary trees. It works by moving Left Root Right. 
   //It doesn't work with TernaryTrees because it introduces a "mid" node. Once the "mid" is introduced, there is no way to tranverse.
   //It has to be traversed before or after the root which is not possible.

   
   private class PostorderIterator implements Iterator<T> {
       private StackInterface<TernaryNode<T>> nodeStack;
       private TernaryNode<T> currentNode;

       public PostorderIterator() {
           nodeStack = new LinkedStack<>();
           currentNode = root;
       }

       public boolean hasNext() {
           return !nodeStack.isEmpty() || (currentNode != null);
       }
       public T next() {
           boolean foundNext = false;
           TernaryNode<T> leftChild, midChild, rightChild, nextNode = null;

           // Find leftmost leaf
           while (currentNode != null) {
               nodeStack.push(currentNode);
               leftChild = currentNode.getLeftChild();
               midChild = currentNode.getMidChild();
               rightChild = currentNode.getRightChild();
               if (leftChild == null && midChild != null) {
                   currentNode = midChild;
               } 
               if (leftChild == null && midChild == null)
               {
            	   currentNode = rightChild;
               }
               else {
                   currentNode = leftChild;
               }
           }

           // Stack is not empty either because we just pushed a node, or
           // it wasn't empty to begin with since hasNext() is true.
           // But Iterator specifies an exception for next() in case
           // hasNext() is false.

           if (!nodeStack.isEmpty()) {
               nextNode = nodeStack.pop();
               // nextNode != null since stack was not empty before pop

               TernaryNode<T> parent = null;
               if (!nodeStack.isEmpty()) {
                   parent = nodeStack.peek();
                   if (nextNode == parent.getLeftChild()) {
                       currentNode = parent.getMidChild();
                   }
                   if (nextNode == parent.getMidChild())
                   {
                	   currentNode = parent.getRightChild();
                   }
                   else {
                       currentNode = null;
                   }
               } else {
                   currentNode = null;
               }
           } else {
               throw new NoSuchElementException();
           }

           return nextNode.getData();
       }


       public void remove() {
           throw new UnsupportedOperationException();
       }
   }

   private class LevelOrderIterator implements Iterator<T> {
       private QueueInterface<TernaryNode<T>> nodeQueue;

       public LevelOrderIterator() {
           nodeQueue = new LinkedQueue<>();
           if (root != null) {
               nodeQueue.enqueue(root);
           }
       }

       public boolean hasNext() {
           return !nodeQueue.isEmpty();
       }

       public T next() {
           TernaryNode<T> nextNode;

           if (hasNext()) {
               nextNode = nodeQueue.dequeue();
               TernaryNode<T> leftChild = nextNode.getLeftChild();
               TernaryNode<T> midChild = nextNode.getMidChild();
               TernaryNode<T> rightChild = nextNode.getRightChild();

               // Add to queue in order of recursive calls
               if (leftChild != null) {
                   nodeQueue.enqueue(leftChild);
               }
               
               if (midChild != null) {
                   nodeQueue.enqueue(midChild);
               }
               
               if (rightChild != null) {
                   nodeQueue.enqueue(rightChild);
               }
           } else {
               throw new NoSuchElementException();
           }

           return nextNode.getData();
       }

       public void remove() {
           throw new UnsupportedOperationException();
       }
   }
}



