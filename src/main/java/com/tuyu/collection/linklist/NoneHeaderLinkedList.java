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
 *
 * @author tuyu
 * @date 6/1/18
 * Stay Hungry, Stay Foolish.
 */
public class NoneHeaderLinkedList<E> implements MyList<E> {

    private static class Node<E> {
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

    private Node<E> head, tail;
    private int size;
    @Override
    public boolean add(E e) {
        return linkLast(e);
    }

    private boolean linkLast(E e){
        Node<E> newNode = new Node<>(e);
        if (tail == null) {
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        if (head == null){
            head = newNode;
        }
        size ++;
        return true;
    }

    @Override
    public boolean add(int index, E e) {
        checkPositionIndex(index);
        if (index == size) { // 加到末尾
            return linkLast(e);
        }
        if (index == 0) { // 加大头部
            Node<E> newNode = new Node<>(e);
            newNode.next = head;
            head = newNode;
            size ++;
            return true;
        }
        return linkBefore(e, node(index - 1)); // 加到中间
    }

    private Node<E> node(int index) {
//        checkElementIndex(index);
        Node<E> curr = head;
        for (int i = 0; i < index; i++){
            curr = curr.next;
        }
        return curr;
    }

    private void checkElementIndex(int index) {
        if (!isElemetIndex(index)) {
            throw new IndexOutOfBoundsException("no element of index " + index + ", size " + size);
        }
    }

    private boolean isElemetIndex(int index) {
        return index >= 0 && index < size;
    }
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("no element of position " + index + ", size " + size);
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private boolean linkBefore(E e, Node<E> preNode) {
        Node<E> newNode = new Node<>(e);
        Node<E> nextNode = preNode.next;
        preNode.next = newNode;
        newNode.next = nextNode;
        size ++;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(Object e) {
        if (!isElemetIndex(size - 1)) {
            return false;
        }
        Node<E> pre = null; // 父节点
        if (e == null) {
            if (head.el == null) {
                return unlinkFirst();
            }
            for (Node<E> x = head; x != null; x = x.next) {
                if (x.el == null) {
                    return pre == null ? false : unlink(pre);
                }
                pre = x;
            }
        } else {
            if (e.equals(head.el)) {
                return unlinkFirst();
            }
            for (Node<E> x = head; x != null; x = x.next) {
                if (e.equals(x.el)) {
                    return pre == null ? false : unlink(pre);
                }
                pre = x;
            }
        }
        return false;
    }

    private boolean unlink(Node<E> preNode) {
        Node<E> removeNode = preNode.next; // removeNode一定不为null
        if (tail == removeNode) { // 如果是尾节点被删除，需要移动尾指针
            tail = preNode;
        }
        Node<E> nextNode = removeNode.next;
        preNode.next = nextNode;
        removeNode.el = null;
        size --;
        return true;
    }

    private boolean unlinkFirst() {
        Node<E> nextNode = head.next;
        head.el = null; // help GC
        head = nextNode;
        size --;
        return true;
    }

    @Override
    public boolean remove(int index) {
        checkElementIndex(index);
        if (size == 1) {
            head.el = null; // help GC
            head = null;
            tail = null;
            size --;
            return true;
        } else {
            return unlink(node(index - 1)); // 把父节点传过去
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        if (size > 0) {
            Node<E> curr = head;
            for (int i = 0; i < size; i++){
                stringBuilder.append(curr.el)
                        .append(',');
                curr = curr.next;
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void display() {
        System.out.println(toString());
    }
}
