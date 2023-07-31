import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    // Helper method to insert a value into the binary tree
    public void insert(int val) {
        root = insertRec(root, val);
    }

    private TreeNode insertRec(TreeNode current, int val) {
        if (current == null) {
            return new TreeNode(val);
        }

        if (val < current.val) {
            current.left = insertRec(current.left, val);
        } else if (val > current.val) {
            current.right = insertRec(current.right, val);
        }

        return current;
    }

    // Helper method to perform an inorder traversal of the binary tree
    public void inorderTraversal() {
        inorderTraversalRec(root);
    }

    private void inorderTraversalRec(TreeNode current) {
        if (current != null) {
            inorderTraversalRec(current.left);
            System.out.print(current.val + " ");
            inorderTraversalRec(current.right);
        }
    }
    
    public static boolean helper(TreeNode root)
    {
        if(root==null) return true;
        boolean l = helper(root.left);
        boolean r = helper(root.right);
        
        if(root.left==null && root.right==null) return true;
        if(root.left==null || root.right==null) return false;
        
        return l&&r;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        {
            int n = in.nextInt();
            BinaryTree tree = new BinaryTree();
            for(int i = 0 ;i<n;i++)
                tree.insert(in.nextInt());
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(tree.root);
            while(!q.isEmpty())
            {
                int levelNum = q.size();
                int lvalue = 0;
                boolean flag = false;
                for(int i= 0 ;i<levelNum ;i++)
                {
                    if(q.peek().left!=null) q.offer(q.peek().left);
                    if(q.peek().right!=null)q.offer(q.peek().right);
                    int x = q.poll().val;
                    if(!flag)
                    {
                        lvalue = x;
                        flag = true;
                    }
                    
                }
                System.out.print(lvalue+" ");
                
            }
            System.out.println();
        }
//         BinaryTree tree = new BinaryTree();

//         System.out.println("Inorder Traversal:");
//         tree.inorderTraversal();
    }
}
