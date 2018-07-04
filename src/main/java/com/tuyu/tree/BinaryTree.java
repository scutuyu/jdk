package com.tuyu.tree;

import java.util.LinkedList;
import java.util.Queue;

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
public class BinaryTree {
    //二叉树通常用树结点结构存储，有时也包含指向唯一父节点的指针
    TreeNode root = null;

    //BinaryTree()该方法与类名字相同，所以是构造方法，被默认强制为void
    //初始化根
    public  BinaryTree(){
        root = new TreeNode(1,"A");
    }

    //创建二叉树bt，树由结点构成
    public void createBinTree(TreeNode root){
        TreeNode newNodeB = new TreeNode(2,"B");
        TreeNode newNodeC = new TreeNode(3,"C");
        TreeNode newNodeD = new TreeNode(4,"D");
        TreeNode newNodeE = new TreeNode(5,"E");
        TreeNode newNodeF = new TreeNode(6,"F");
        //填充它
        root.leftChild = newNodeB;
        root.rightChild = newNodeC;
        root.leftChild.leftChild = newNodeD;
        root.leftChild.rightChild = newNodeE;
        root.rightChild.rightChild = newNodeF;
    }

    //创建二叉树bt2，树由结点构成
    public void createBinTree2(TreeNode root){
        TreeNode newNodeB = new TreeNode(2,"B");
        TreeNode newNodeC = new TreeNode(3,"C");
        TreeNode newNodeD = new TreeNode(4,"D");
        TreeNode newNodeE = new TreeNode(5,"E");
        //填充它
        root.leftChild = newNodeB;
        root.rightChild = newNodeC;
        root.leftChild.leftChild = newNodeD;
        root.leftChild.rightChild = newNodeE;
    }


    //访问结点，输出结点，便于我们查看效果
    public void visitNode(TreeNode node){
        System.out.print(node.data+" ");
    }

    //1.获取结点个数
    //递归解法：
    //（1）如果二叉树为空，节点个数为0
    //（2）如果二叉树不为空，二叉树节点个数 = 左子树节点个数 + 右子树节点个数 + 1
    public int size(){
        return size(root);
    }
    //通过递归求size
    public int size(TreeNode subtree){
        if (subtree==null){
            return 0;
        }else {
            return 1+size(subtree.leftChild)+size(subtree.rightChild);
        }
    }

    //2.求深度
    //递归解法：
    //（1）如果二叉树为空，二叉树的深度为0
    //（2）如果二叉树不为空，二叉树的深度 = max(左子树深度， 右子树深度) + 1
    public int getDepth(TreeNode root){
        if (root==null){
            return 0;
        }else {
            int depthLeft = getDepth(root.leftChild);
            int depthRight = getDepth(root.rightChild);
            return depthLeft > depthRight ? (depthLeft+1) : (depthRight+1);
        }
    }


    //3. 前序遍历，中序遍历，后序遍历
    //a.前序遍历
    //前序遍历递归解法：
    //（1）如果二叉树为空，空操作
    //（2）如果二叉树不为空，访问根节点，前序遍历左子树，前序遍历右子树
    public void preOrderTraverse(TreeNode root){
        if (root!=null){
            visitNode(root);//此处访问根节点
            preOrderTraverse(root.leftChild);
            preOrderTraverse(root.rightChild);
        }
    }
    //b.中序遍历
    //中序遍历递归解法
    //（1）如果二叉树为空，空操作。
    //（2）如果二叉树不为空，中序遍历左子树，访问根节点，中序遍历右子树
    public void inOrderTraverse(TreeNode root){
        if (root!=null){
            inOrderTraverse(root.leftChild);
            visitNode(root);//此处访问根节点
            inOrderTraverse(root.rightChild);
        }
    }

    //c.后序遍历
    //后序遍历递归解法
    //（1）如果二叉树为空，空操作。
    //（2）如果二叉树不p为空，后序遍历左子树，后序遍历右子树，访问根节点，
    public void postOrderTraverse(TreeNode root){
        if (root!=null){
            postOrderTraverse(root.leftChild);
            postOrderTraverse(root.rightChild);
            visitNode(root);//此处访问根节点
        }
    }


    //4.分层遍历二叉树（按层次从上往下，从左往右）
    //相当于广度优先搜索，使用队列实现。队列初始化，将根节点压入队列。
    //当队列不为空，进行如下操作：弹出一个节点，访问，若左子节点或右子节点不为空，将其压入队列。
    public void levelTraverse(TreeNode root){
        if (root==null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //让根节点入队(队列：先进先出)
        queue.offer(root);
        while (!queue.isEmpty()){
            //让元素出队
            TreeNode node = queue.poll();
            //访问它 这里就是用visit方法输出看效果~~
            visitNode(node);
            if (node.leftChild!=null){
                queue.offer(node.leftChild);
            }
            if (node.rightChild!=null){
                queue.offer(node.rightChild);
            }
        }
        return;
    }

    //5.求二叉树第K层的节点个数
    //递归解法：
    //（1）如果二叉树为空或者k<1返回0
    //（2）如果二叉树不为空并且k==1，返回1
    //（3）如果二叉树不为空且k>1，返回左子树中k-1层的节点个数与右子树k-1层节点个数之和
    public int getNodeNumKthLevel(TreeNode root,int k){
        if (root==null||k<1){
            return 0;
        }else if (k==1){
            return 1;
        }else {
            int leftNum = getNodeNumKthLevel(root.leftChild,k-1);
            int rightNum = getNodeNumKthLevel(root.rightChild,k-1);
            return leftNum+rightNum;
        }
    }

    //6.求二叉树中叶子节点的个数
    // 递归解法：
    //（1）如果二叉树为空，返回0
    //（2）如果二叉树不为空且左右子树为空，返回1
    //（3）如果二叉树不为空，且左右子树不同时为空，返回左子树中叶子节点个数加上右子树中叶子节点个数
    public int getLeafNodeNum(TreeNode root){
        if (root==null){
            return 0;
        }else if (root.leftChild==null&&root.rightChild==null){
            return 1;
        }else {
            int leftNum = getLeafNodeNum(root.leftChild);
            int rightNum = getLeafNodeNum(root.rightChild);
            return leftNum+rightNum;
        }
    }

    //8. 判断两棵二叉树是否结构相同
    //不考虑数据内容。结构相同意味着对应的左子树和对应的右子树都结构相同。
    //递归解法：
    //（1）如果两棵二叉树都为空，返回真
    //（2）如果两棵二叉树一棵为空，另一棵不为空，返回假
    //（3）如果两棵二叉树都不为空，如果对应的左子树和右子树都同构返回真，其他返回假
    public boolean StructureCmp(TreeNode root1,TreeNode root2){
        if (root1==null&&root2==null){
            //都为空，返回真
            return true;
        }else if (root1==null||root2==null){
            //一个为空，一个不为空，返回假
            return false;
        }else {
            //都不为空
            boolean leftResult = StructureCmp(root1.leftChild,root2.leftChild);
            boolean rightResult = StructureCmp(root1.rightChild,root2.rightChild);
            //都同构则为真，否则为假
            return leftResult&&rightResult;
        }
    }
}

class TreeNode {
    int key = 0; //key 为层序编码
    String data = null; //data 为数据域
    boolean isVisited = false;
    /*树的每一个节点的数据结构都是TreeNode类型，
    createBinTree里定义的root为TreeNode类型，所以左右孩子也为TreeNode类型，
    加上二叉树的递归思想，所以所有节点都是TreeNode类型
     */
    TreeNode leftChild = null;
    TreeNode rightChild = null;

    public TreeNode(int key,String data){
        this.key = key;
        this.data = data;
        this.isVisited = false;
        this.leftChild = null;
        this.rightChild = null;
    }

}

