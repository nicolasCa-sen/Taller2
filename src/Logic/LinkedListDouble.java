package Logic;
/**
 * @author Nicolas Santiago Caceres
 * clase person
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LinkedListDouble <T>{
    /**
     *
     * atributo comparator
     */
    private Comparator<T> comparator;
    /**
     *
     * atributo nodo cabeza
     */
    private NodeDouble<T> head;
    /**
     *
     * atributo nodo final
     */
    private NodeDouble<T> last;


    /**
     *
     * constructor de la clase LinkedListDouble
     */

    public LinkedListDouble(Comparator<T> comparator) {
        this.comparator = comparator;
        head = last = null;
    }

    /**
     *
     * metodo vacio que regresa un boolean si la pila se encuentra vacia
     * @return boolean
     */

    public boolean isEmpty(){
        return head == null && last == null;
    }

    /**
     *
     * metodo que añade un nodo al principip
     *
     */

    public void addNodeFirst( T info){
        if( isEmpty()){
            head = last = new NodeDouble<>(info);
        }else{
            NodeDouble<T> nodeNew = new NodeDouble<>(info);
            head.setPrevious( nodeNew );
            nodeNew.setNext( head );
            head = nodeNew;
        }
    }
    /**
     *
     * metodo que añade un nodo al final
     *
     */
    public void addNodeLast(T info){

        if( isEmpty()){
            head = last = new NodeDouble<>(info);
        }else{
            NodeDouble<T> nodeNew = new NodeDouble<>(info);
            last.setNext( nodeNew );
            nodeNew.setPrevious(last);
            last = nodeNew;
        }
    }
    /**
     *
     * metodo que añade un nodo despues de otro
     *
     */
    public void addNodeAfterTo(NodeDouble<T> node, T info) {
        NodeDouble<T> newNode = new NodeDouble<>(info);
        if (!isEmpty()) {
            if (node == last) {
                node.setNext(newNode);
                newNode.setPrevious(node);
                last = newNode;
            } else {
                newNode.setNext(node.getNext());
                newNode.setPrevious(node);
                node.setNext(newNode);
                newNode.getNext().setPrevious(newNode);
            }
        } else {
            head = last = newNode;
        }
    }
    /**
     *
     * metodo que añade un nodo antes de otro
     *
     */
    public void addNodeBeforeTo(NodeDouble<T> node, T info) {
        NodeDouble<T> newNode = new NodeDouble<>(info);
        if (!isEmpty()) {
            if (node == head) {
                node.setPrevious(newNode);
                newNode.setPrevious(node);
                head = newNode;
            } else {
                newNode.setPrevious(node.getPrevious());
                newNode.setNext(node);
                newNode.getPrevious().setNext(newNode);
                node.setPrevious(newNode);
            }
        } else {
            head = last = newNode;
        }
    }
    /**
     *
     * metodo que añade un nodo de forma ordenada
     *
     *
     */
    public void addNodeSorted(T info) {

        NodeDouble<T> aux = head;
        while (aux != null && comparator.compare(info, aux.getInfo()) > 0) {
            aux = aux.getNext();
        }
        if (aux == null) {
            addNodeLast(info);
        } else if (aux == head) {
            addNodeFirst(info);
        } else {
            addNodeBeforeTo(aux, info);
        }
    }


    /**
     *
     * metodo que elimina un nodo
     * @return UN objeto de tipo generico
     *
     *
     */
    public T deleteNode( NodeDouble<T> node ){

        if( node == head ){
            head=node.getNext() ;
            node.getNext().setPrevious(null);
            node.setNext(null);
        }else{
            if (node == last){
                last=node.getPrevious();
                node.getPrevious().setNext(null);
                node.setPrevious(null);
            }else{
                node.getPrevious().setNext(node.getNext());
                node.getNext().setPrevious(node.getPrevious());
                node.setPrevious(null);
                node.setNext(null);
            }
        }
        return null;
    }


    /**
     *
     * metodo que muestra la lista de nodos
     * @return lista
     *
     */
    public List<T> getLinkedList( boolean back ){
        ArrayList<T> out = new ArrayList<>();
        NodeDouble<T> aux = !back ? head : last;
        while(aux != null){
            out.add( aux.getInfo());
            aux = !back ? aux.getNext() : aux.getPrevious();
        }
        return out;
    }
    /**
     *
     * metodo que muestra el tamaño de la lista
     * @return int
     *
     */

    public int getSize( ){
        boolean back=true;
        ArrayList<T> out = new ArrayList<>();
        NodeDouble<T> aux = !back ? head : last;
        while(aux != null){
            out.add( aux.getInfo());
            aux = !back ? aux.getNext() : aux.getPrevious();
        }
        return out.size();
    }
    /**
     *
     * metodo que busca un nodo
     * @return nodo de tipo generico
     *
     */
    public NodeDouble<T> findNode(T info) {
        NodeDouble<T> actual = head;
        while (actual != null) {
            if (comparator.compare(actual.getInfo(), info) == 0) {
                return actual;
            }
            actual = actual.getNext();
        }
        return null;
    }
    /**
     *
     * metodo que busca la informacion dentro de un nodo
     * @return objeto de tipo generico
     *
     */
    public T findInfo(T info) {
        NodeDouble<T> actual = head;
        while (actual != null) {
            if (comparator.compare(actual.getInfo(), info) == 0) {
                return actual.getInfo();
            }
            actual = actual.getNext();
        }
        return null;
    }
}
