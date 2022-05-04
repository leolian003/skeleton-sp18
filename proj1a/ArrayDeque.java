public class ArrayDeque <T> {
    private T[] item;
    private int size;
    private int nextFirst;
    private int nextLast;
    private static int EXPAND_FACTOR = 2;
    private static double SHRINK_FACTOR = 0.8;
    private static double USAGE_THRESHOLD = 0.5;
    public ArrayDeque(){
        item = (T[])new Object[8];
        size=0;
        nextFirst = 0;
        nextLast = 1;

    }
    public boolean isEmpty(){
        if(size == 0){return true;}
        else{return false;}
    }
    public void addFirst(T x){
        item[nextFirst]=x;
        size+=1;
        if (size == item.length) {
            resize(nextFirst,size*EXPAND_FACTOR);
        }
        else{
            nextFirst = stepBackward(nextFirst);
        }
    }
    public void addLast(T x){
        item[nextLast]=x;
        size+=1;
        if (size == item.length) {
            resize(nextFirst,size*EXPAND_FACTOR);
        }
        else {
            nextLast = stepForward(nextLast);
        }
    }
    /*
    * resize the array when usage is too high or too low.
    * */
    private void resize(int startPos,int newSize) {
        T[] tmp = (T[])new Object[newSize];
        //copy part of array starting from pos startPos to the extent of (item.length -1)
        int len = (item.length-startPos<=size)?item.length-startPos:size;
        System.arraycopy(item,startPos,tmp,0,len);
        //if necessary, copy the rest of array starting from pos 0.
        if(len<size) {
            System.arraycopy(item,0,tmp,len,size-len);
        }
        item = tmp;
        //the original array always start from pos 0 at new array, initiate the nF and nL accordingly.
        nextFirst = stepBackward(0);
        nextLast = size;
    }

    public T removeFirst(){
        T rem;
        int prevHead;
        int newHead;
        if(size==0) {
            return null;
        }
        else{
            prevHead = stepForward(nextFirst);
            newHead = stepForward(prevHead);
        }
        rem = item[prevHead];
        item[prevHead] = null;
        nextFirst = prevHead;
        size -=1;
        if( size < item.length * USAGE_THRESHOLD) { //reduce the size
            resize(newHead,(int)java.lang.Math.round(item.length*SHRINK_FACTOR));
        }
        return rem;
    }

    public T removeLast(){
        T rem;
        int prevTail;
        if(size==0) {
            return null;
        }
        else{
            prevTail = stepBackward(nextLast);
        }

        rem = item[prevTail];
        item[prevTail] = null;
        nextLast = prevTail;
        size -=1;
        if( size < item.length * USAGE_THRESHOLD) { //reduce the size
            resize(stepForward(nextFirst),(int)java.lang.Math.round(item.length*SHRINK_FACTOR));
        }
        return rem;
    }
    private int stepForward(int pos) {
        return (pos == item.length-1)?0:pos+1;
    }
    private int stepBackward(int pos) {
        return (pos == 0)?item.length-1:pos-1;
    }
    public T get(int index){
        int head = stepForward(nextFirst);
        int maxIndex = item.length-head-1;
        int retIndex = (maxIndex>=index)?(head+index):(index-maxIndex-1);
        return item[retIndex];
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        int head = stepForward(nextFirst);
        int pos = head;
        while(item[pos]!=null){
            System.out.print(item[pos]);
            pos = stepForward(pos);
        }
        System.out.println("");
    }






    public static void main(String[] args){


    }
}
