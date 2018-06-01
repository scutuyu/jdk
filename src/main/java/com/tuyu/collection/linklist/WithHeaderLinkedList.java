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

        public Node(E el) {
            this.el = el;
        }

        public Node(E el, Node<E> next) {
            this.el = el;
            this.next = next;
        }
    }

    private Node<E> head = new Node<E>(null); // 带头结点的头指针初始化
    private Node<E> tail = head; // 带头结点的尾指针初始化
    private volatile int size;


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
            return linkBefore(e, node(index - 1));
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
        Node<E> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    private void checkElementIndex(int index){
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
    }

    private boolean isElementIndex(int index){
        return index >= 0 && index < size;
    }

    @Override
    public boolean remove(Object e) {
        Node<E> pre = null;
        Node<E> x = head.next;
        for (int i = 0; i < size; i++) {
            if (e == null) {
                if (x.el == null) {
                    return unlink(pre);
                }
            } else {
                if (e.equals(x.el)) {
                    return unlink(pre);
                }
            }
            pre = x;
            x = x.next;
        }
        return false;
    }

    private boolean unlink(Node<E> node){
        if (size == 0){
            throw new NoSuchElementException("the list is empty");
        }
        Node<E> curr = node.next;
        node.next = curr.next;
        // help GC
        curr.el = null;
        curr.next = null;
        size --;
        return true;
    }

    @Override
    public boolean remove(int index) {
        return unlink(node(index - 1));
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
