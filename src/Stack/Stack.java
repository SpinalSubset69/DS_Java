package Stack;

public class Stack<T> {
    private Node peek;

    public Stack(){
        this.peek = new Node();
        this.peek.setNext(null);
    }

    public boolean IsVoid(){
        return this.peek == null;
    }

    public void Push(T data){
        Node new_node = new Node();
        new_node.setData(data);
        new_node.setNext(this.peek);
        this.peek = new_node;
    }

    public T Peek(){
        return IsVoid() ? null : (T)this.peek.getData();
    }

    public void Pop(){
        if(IsVoid()){
            return;
        }
        this.peek = this.peek.getNext();
    }

    public void ShowStack(){
        if(IsVoid()){
            return;
        }
        Node aux = this.peek;

        while(aux.getNext() != null){
            System.out.print("{" + aux.getData() + "}, ");
            aux = aux.getNext();
        }
    }
}
