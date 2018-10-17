package com.tuyu.collection.linklist;

import java.io.IOException;
import java.util.Random;
import java.util.Stack;

/**
 * 单链表操作
 *
 * @author tuyu
 * @date 10/11/18
 * Talk is cheap, show me the code.
 */
public class LinkOp {
    static class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /** 获取一个单链表，10个元素 */
    private static Node getSingleNode() {
        return getSingleNode(10);
    }

    private static Node getSingleNode(int num) {
        Node node = new Node(0);
        Node point = node;
        for (int i = 1; i <= num; i++) {
            point.next = new Node(i);
            point = point.next;
        }
        return node.next;
    }

    /** 打印单链表 */
    private static void printNode(Node node) {
        Node point = node;
        while (point != null) {
            System.out.print(point.value + " -> ");
            point = point.next;
        }
        System.out.println("null");
    }

    /** 计算单链表的长度 */
    private static int getLength(Node node) {
        Node point = node;
        int i = 0;
        while (point != null) {
            i++;
            point = point.next;
        }
        return i;
    }

    /** 将单链表反转 迭代*/
    private static Node reverse(Node node) {
        if (node == null) {
            return node;
        }
        Node tail = node;
        Node head = node;
        while (tail.next != null) {
            Node tmp = tail.next;
            tail.next = tmp.next;
            tmp.next = head;
            head = tmp;
        }
        return head;
    }

    /** 将单链表反转 递归 */
    private static Node reverseRecursion(Node node) {
        // 返回头结点
        if (node == null || node.next == null) {
            return node;
        }
        // 找到最后一个节点，并将它返回
        Node head = reverseRecursion(node.next);
        node.next.next = node;
        node.next = null;
        return head;
    }

    /** 单链表反向打印 栈 */
    private static void printNodeStack(Node node) {
        Node point = node;
        Stack<Node> stack = new Stack<>();
        while (point != null) {
            stack.push(point);
            point = point.next;
        }
        while (!stack.empty())
            System.out.print(stack.pop().value + " -> ");
        System.out.println("null");
    }

    /** 单链表反向打印 递归 */
    private static void printNodeRecursion(Node node) {
        if (node == null) {
            System.out.println("null");
            return;
        }
        if (node.next == null) {
            System.out.print(node.value + " -> ");
            return;
        }
        printNodeRecursion(node.next);
        System.out.print(node.value + " -> ");
    }

    private static Node getKthNode(Node node, int k) {
        int length = getLength(node);
        if (k < 0 || k > length) {
            return null;
        }
        Node kth = node;
        for (int i = length; i > k; i--) {
            kth = kth.next;
        }
        return kth;
    }

    private static Node getMiddleNode(Node node) {
        if (node == null || node.next == null || node.next.next == null) {
            return node;
        }
        Node point = node;
        Node point2 = node.next;
        while (point2 != null && point2.next != null) {
            point = point.next;
            point2 = point2.next.next;
        }
        return point;
    }

    /** 两个有序单链表合并为一个有序单链表 循环*/
    private static Node merge(Node a, Node b) {
        Node pa = a;
        Node pb = b;
        Node head = new Node(0);
        Node point = head;
        while (pa != null && pb != null) {
            if (pa.value < pb.value) {
                point.next = pa;
                pa = pa.next;
            } else {
                point.next = pb;
                pb = pb.next;
            }
            point = point.next;
        }
        if (pa != null) {
            point.next = pa;
        }
        if (pb != null) {
            point.next = pb;
        }
        return head.next;
    }

    private static Node mergeRecursion(Node a, Node b) {
        if (a == null && b == null) {
            return null;
        }
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.value < b.value) {
            Node node = mergeRecursion(a.next, b);
            a.next = node;
            return a;
        } else {
            Node node = mergeRecursion(a, b.next);
            b.next = node;
            return b;
        }
    }

    /** 单链表归并排序 */
    private static Node mergeSort(Node node) {
        Node subNode = null;
        if (node == null || node.next == null) {
            return node;
        } else {
            Node mid = getMiddleNode(node);
            subNode = mid.next;
            // 将原始链表拆成两段，第二段的头节点是subNode
            mid.next = null;
        }
        // 将两段链表分别递归拆分，再合并两个有序链表
        return merge(mergeSort(node), mergeSort(subNode));
    }

    public static void main(String[] args) throws IOException {
        Node node = getSingleNode();
//        printNode(node);
//        System.out.println("单链表的长度为：" + getLength(node));
//        System.out.println("将单链表反转：");
//        printNode((node = reverse(node)));
//        System.out.println("将单链表反转（递归）：");
//        printNode((node = reverseRecursion(node)));
//        System.out.println("反向打印（栈）:");
//        printNodeStack(node);
//        System.out.println("反向打印（递归）：");
//        printNodeRecursion(node);
//        System.out.println();
//        testGetKthNode(node);
//        testMiddleNode();
//        System.out.println("合并两个单链表（循环）：");
//        printNode(merge(getSingleNode(), getSingleNode()));
//        System.out.println("合并两个单链表（递归）：");
//        printNode(mergeRecursion(getSingleNode(12), getSingleNode()));
        System.out.println("乱序：");
        printNode((node = rambLinkedList(node)));
        System.out.println("归并排序后（递归）：");
        printNode(mergeSort(node));
//        System.in.read();
    }

    private static void testGetKthNode(Node node) {
        int length = getLength(node);
        for (int i = 1; i <= length; i++) {
            System.out.printf("获取倒数第%d个节点：%d\n", i, getKthNode(node, i).value);
        }
    }

    private static void testMiddleNode() {
        for (int i = 1; i <= 11; i++) {
            System.out.println("获取" + i + "个节点的中间节点：" + getMiddleNode(getSingleNode(i)).value);
        }
    }

    private static Node rambLinkedList(Node node) {
        int length = getLength(node);
        Random random = new Random();
        for (int i = 1; i <= length; i++) {
            Node k = getKthNode(node, random.nextInt(length) + 1);
            if (k.next != null && k.next.next != null) {
                Node first = k.next;
                Node second = k.next.next;
                Node tail = second.next;
                k.next = second;
                second.next = first;
                first.next = tail;
            }
        }
        return node;
    }


}
