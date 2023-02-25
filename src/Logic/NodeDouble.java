package Logic;

public class NodeDouble <T>{
    private T info;

    private NodeDouble<T> next;
    private NodeDouble<T> previous;

    public NodeDouble(T info) {
        this.info = info;

        next = previous = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NodeDouble<T> getNext() {
        return next;
    }

    public void setNext(NodeDouble<T> next) {
        this.next = next;
    }

    public NodeDouble<T> getPrevious() {
        return previous;
    }

    public void setPrevious(NodeDouble<T> previous) {
        this.previous = previous;
    }
}
