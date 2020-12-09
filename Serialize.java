import java.util.LinkedList;
import java.util.Queue;

public class Serialize {
	
	public static String serialize(TreeNode root) {
        // write your code here
        if (root == null){
            String temp = "#";
            return temp;
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                sb.append(cur.val);
                if (cur.left != null){
                    q.offer(cur.left);
                }
                if (cur.left == null){
                    sb.append("#");
                }
                if (cur.right != null){
                    q.offer(cur.right);
                }
                if (cur.right == null){
                    //sb.append("#");
                }
            }
        }
        return sb.toString();
        
    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = null;
		String res = new String();
		res = serialize(root);
		System.out.println(res);
	}
}
