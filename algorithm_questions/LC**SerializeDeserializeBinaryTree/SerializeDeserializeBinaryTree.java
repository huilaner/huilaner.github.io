/**
 * difficulty: medium
 * url: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * tag: tree, design
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 //StringBuilder really important, otherwise will time out...
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String s = "";
        if(root == null) return "null";
        LinkedList<TreeNode> currList = new LinkedList<>();
        LinkedList<TreeNode> nextList = new LinkedList<>();
        currList.add(root);
        StringBuilder sb = new StringBuilder();

        while(!currList.isEmpty()){
            TreeNode curr = currList.remove();
            String r = curr == null ? "null," : curr.val + ",";
            sb.append(r);
            if(curr != null){
                nextList.add(curr.left);
                nextList.add(curr.right);
            }
            if(currList.isEmpty()){
                currList = nextList;
                nextList = new LinkedList<TreeNode>();
            }
        }
        s = sb.toString();
        s = s.substring(0, s.length()-1);//remove the last ","
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty() || data.equals("null")) return null;
        String[] ary = data.split(",");
        LinkedList<TreeNode> currList = new LinkedList<>();
        LinkedList<TreeNode> nextList = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(ary[0]));
        currList.add(root);

        int i = 1;
        int level = 0;
        while(i < ary.length){
            while(!currList.isEmpty()){
                TreeNode node = currList.remove();
                if(node != null){
                    node.left = ary[i].equals("null") ? null : new TreeNode(Integer.parseInt(ary[i]));
                    i++;
                    node.right = ary[i].equals("null") ? null : new TreeNode(Integer.parseInt(ary[i]));
                    i++;
                    nextList.add(node.left); nextList.add(node.right); 
                }
                
            }
            currList = nextList;
            nextList = new LinkedList<TreeNode>();
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
