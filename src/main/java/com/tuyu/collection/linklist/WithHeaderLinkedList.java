package com.tuyu.collection.linklist;

import java.util.NoSuchElementException;

/**
 * <pre>
 * ////////////////////////////////////////////////////////////////////
 * //                          _ooOoo_                               //
 * //                         o8888888o                              //
 * //                         88" . "88                              //
 * //                         (| ^_^ |)                              //
 * //                         O\  =  /O                              //
 * //                      ____/`---'\____                           //
 * //                    .'  \\|     |//  `.                         //
 * //                   /  \\|||  :  |||//  \                        //
 * //                  /  _||||| -:- |||||-  \                       //
 * //                  |   | \\\  -  /// |   |                       //
 * //                  | \_|  ''\---/''  |   |                       //
 * //                  \  .-\__  `-`  ___/-. /                       //
 * //                ___`. .'  /--.--\  `. . ___                     //
 * //              ."" '<  `.___\_<|>_/___.'  >'"".                  //
 * //            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
 * //            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
 * //      ========`-.____`-.___\_____/___.-`____.-'========         //
 * //                           `=---='                              //
 * //      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
 * //             佛祖保佑       永无BUG     永不修改                   //
 * ////////////////////////////////////////////////////////////////////
 * </pre>
 * <p>
 * tuyu于6/1/18祈祷...
 * 带头结点的单链表
 * @author tuyu
 * @date 6/1/18
 * Stay Hungry, Stay Foolish.
 */
public class WithHeaderLinkedList<E> implements MyList<E> {


    private static class Node<E>{
        private E el;
        private Node<E> next;

        public Node() {
        }

        public Node(E el) {
            this.el = el;
        }

        public Node(E el, Node<E> next) {
            this.el = el;
            this.next = next;
        }
    }

    private Node<E> head, tail;
    private volatile int size;

    public WithHeaderLinkedList() {
        head = tail = new Node<>();
    }

    @Override
    public boolean add(E e) {
        return linkLast(e);
    }

    private boolean linkLast(E e){
        Node<E> newNode = new Node<E>(e);
        Node<E> l = tail;
        l.next = newNode;
        tail = newNode;
        size ++;
        return true;
    }

    @Override
    public boolean add(int index, E e) {
        if (index == size) {
            return linkLast(e);
        }else {
            return linkBefore(e, previous(index));
        }
    }

    @Override
    public int size() {
        return size;
    }

    private boolean linkBefore(E e, Node<E> node) {
        Node<E> next = node.next;
        Node<E> newNode = new Node<>(e);
        node.next = newNode;
        newNode.next = next;
        size ++;
        return true;
    }

    private Node<E> node(int index){
        checkElementIndex(index);
        Node<E> curr = head.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    private Node<E> previous(int index) {
        checkElementIndex(index);
        Node<E> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    private void checkElementIndex(int index){
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("index out of bounds, no element of position " + index + ", size " + size);
        }
    }

    private boolean isElementIndex(int index){
        return index >= 0 && index < size;
    }

    @Override
    public boolean remove(Object obj) {
        Node<E> pre = head;

        if (obj == null) {
            for (Node<E> x = head.next; x != null; x = x.next) {
                if (x.el == null) {
                    return unlink(pre);
                }
                pre = x;
            }
        } else {
            for (Node<E> x = head.next; x != null; x = x.next) {
                if (obj.equals(x.el)) {
                    return unlink(pre);
                }
                pre = x;
            }
        }
        return false;
    }

    private boolean unlink(Node<E> preNode){
        Node<E> removeNode = preNode.next;
        if (removeNode == tail) {
            tail = preNode;
        }
        preNode.next = removeNode.next;
        removeNode.el = null; // help GC
        size --;
        return true;
    }

    @Override
    public boolean remove(int index) {
        return unlink(previous(index));
    }

    @Override
    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        if (size > 0) {
            Node<E> curr = head;
            for (int i = 0; i < size; i++){
                curr = curr.next;
                stringBuilder.append(curr.el)
                        .append(',');
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
