public class LinkedListDeque <T> {
    /** An SLList is a list of integers, which hides the terrible truth
     * of the nakedness within. */

    /** An SLList is a list of integers, which hides the terrible truth
     * of the nakedness within. */

        public class IntNode{
            public T item;
            public IntNode next;
            public IntNode before;

            public IntNode(T i,IntNode n,IntNode b){
                item = i;
                next = n;
                before = b;

            }
        }
        private IntNode sentinel;
        private int size;
        public LinkedListDeque(){
            sentinel = new IntNode(null,null,null);
            sentinel.next = sentinel;
            sentinel.before = sentinel;
            size=0;
        }

        public LinkedListDeque(T x){
            sentinel = new IntNode(null,null,null);
            IntNode newNode = new IntNode(x,sentinel,sentinel);
            sentinel.next = newNode;
            sentinel.before = newNode;
            size=1;
        }

        //Todo implement function

        public boolean isEmpty(){
            if(size == 0){return true;}
            else{return false;}
        }


        public void addFirst(T x){

            IntNode newNode = new IntNode(x,sentinel.next,sentinel);
            sentinel.next.before = newNode;
            sentinel.next = newNode;
            if(size==0){
                sentinel.before = newNode;
            }

            size+=1;
        }

        public void addLast(T x) {
            IntNode newNode = new IntNode(x,sentinel,sentinel.before);
            sentinel.before.next = newNode;
            sentinel.before = newNode;
            if(size==0){
                sentinel.next = newNode;
            }

            size+=1;
        }

        public T removeFirst(){
            if(size==0){
                return null;
            }

            IntNode curr;
            curr = sentinel.next;
            sentinel.next = sentinel.next.next;
            sentinel.next.before = sentinel;
            size-=1;
            return curr.item;
        }

        public T removeLast(){
            if(size==0){
                return null;
            }

            IntNode curr;
            curr = sentinel.before;
            sentinel.before = sentinel.before.before;
            sentinel.before.next = sentinel;
            size-=1;
            return curr.item;
        }

        public T get(int index){
            if(size==0| index+1>size){
                return null;
            }
            IntNode curr=sentinel.next;
            while(index!=0){
                curr=curr.next;
                index-=1;
            }
            return curr.item;
        }

        public int size(){

            return size;
        }

        public void printDeque(){
            int s = size;
            IntNode curr=sentinel.next;
            while(s!=0){
                System.out.print(curr.item);
                curr=curr.next;
                s-=1;
            }
            System.out.println("");
        }


        public T getRecursive(int index){
            if(size==0 | index+1>size){
                return null;
            }
            return getRecursiveHelper(sentinel.next,index);
        }

        private T getRecursiveHelper(IntNode curr,int index){
            if(index==0){return curr.item;}

            return getRecursiveHelper(curr.next,index-1);
        }


        public static void main(String[] args){
            LinkedListDeque L2 = new LinkedListDeque(5);
            L2.addFirst(10);
            L2.addFirst(5);

        }
    }
