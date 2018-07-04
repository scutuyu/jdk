package com.tuyu.tree;

import org.junit.Test;

import java.util.*;

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
 * tuyu于6/29/18祈祷...
 *
 * @author tuyu
 * @date 6/29/18
 * Stay Hungry, Stay Foolish.
 */
public class TreeTest {

    @Test
    public void testTree() {
        BinaryTree bt = new BinaryTree();
        BinaryTree bt2 = new BinaryTree();
        /*
            由初始化的时候可知：我创建了一个这样的树,供查看写的方法是否正确
            这棵树起名为bt:           这棵树起名为bt2 供比较
                      A                 A
                    /  \               / \
                   B   C              B  C
                  /\  /              /\
                 D E F              D E
        */
        bt.createBinTree(bt.root);
        bt2.createBinTree2(bt2.root);

        //1.看结点数
        System.out.println("1.树的结点个数为：" + bt.size(bt.root));
        //2.看深度
        System.out.println("2.树的深度为："+bt.getDepth(bt.root));
        //3. 前序遍历，中序遍历，后序遍历
        System.out.print("3-1.先序遍历：");
        bt.preOrderTraverse(bt.root);
        System.out.println();

        System.out.print("3-2.中序遍历：");
        bt.inOrderTraverse(bt.root);
        System.out.println();

        System.out.print("3-3.后序遍历：");
        bt.postOrderTraverse(bt.root);
        System.out.println();

        //4.将二叉树用层次遍历
        System.out.print("4.二叉树层次遍历：");
        bt.levelTraverse(bt.root);
        System.out.println();

        //5.二叉树K层有多少个结点：由上图绘制可知：0层没有，1层有一个根节点，第二层有俩，第三次有仨
        System.out.println("5.二叉树K层结点个数：");
        System.out.println("    当K=0时有"+bt.getNodeNumKthLevel(bt.root,0)+"个结点");
        System.out.println("    当K=1时有"+bt.getNodeNumKthLevel(bt.root,1)+"个结点");
        System.out.println("    当K=2时有"+bt.getNodeNumKthLevel(bt.root,2)+"个结点");
        System.out.println("    当K=3时有"+bt.getNodeNumKthLevel(bt.root,3)+"个结点");

        //6.求二叉树中叶子节点的个数
        System.out.print("6.二叉树叶子节点个数：");
        System.out.println(bt.getLeafNodeNum(bt.root));

        //7.比较两个二叉树相不相同
        System.out.println("7.测试两树结构是否相同：");
        System.out.println("    b1和b1："+bt.StructureCmp(bt.root,bt.root));
        System.out.println("    b1和b2："+bt.StructureCmp(bt.root,bt2.root));

    }

    @Test
    public void testTreeSet() {
        Integer[] nums={2,4,1,6,3,7,9,5};
        SortedSet tree=new TreeSet<>(Arrays.asList(nums));

        // Print first and last element
        System.out.println(tree.first());
        System.out.println(tree.last());

        printAll(tree);
        // False. Set does not allow duplicates,
        // so this will not be added.
        System.out.println(tree.add(1));

        // But, this will be added because 11 is not a duplicate
        System.out.println(tree.add(11));
        printAll(tree);

        printAll(tree.headSet(7));
    }

    public static void printAll(SortedSet<Integer> tree){
        for(int s: tree){
            System.out.println(s);
        }
        System.out.println();
    }

    @Test
    public void testTreeMap() {
        TreeMap treeMap=new TreeMap<>();

        treeMap.put("Paradise Lost", 23.56);
        treeMap.put("Golden Treasury", 12.47);
        treeMap.put("Moon and the Sixpence", 65.28);
        treeMap.put("Holinshed", 7.68);
        treeMap.put("Ancient Mariner", 45.36);

        printAll(treeMap);

        // Keys cannot be duplicates. This will not be stored.
        treeMap.put("Paradise Lost", 23.56);
        printAll(treeMap);

        // Values may be duplicates. This will be stored.
        treeMap.put("Paradise Regained", 23.56);
        printAll(treeMap);
    }

    public static void printAll(TreeMap<String , Object> treeMap){
        for(Map.Entry<String, Object> et:treeMap.entrySet()){
            System.out.println(et.getKey()+": "+et.getValue());
        }
        System.out.println();
    }
}
