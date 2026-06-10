public class BlueQ2 {
    /**
     * Returns which has a higher range: a given linked list or a given tree.
     * The range of a data structure is the difference between its highest
     * value and its lowest value.
     * 
     * Returns "list" if the list has a higher range and "tree" if the tree has
     * a higher range. You can assume there will not be a tie, and neither head
     * nor root will be null.
     * 
     * Example:
     *   List:
     *      7 -> 8 -> -2 -> 9 -> 21
     *   Tree:
     *            12
     *          /    \
     *         6      18
     *        / \    /  
     *       4   8  16  
     *   Expected Answer: "list"
     * 
     * Explanation:
     *   The largest number in the list is 21 and -2 is the smallest.
     *   Thus the range of the list is 21 - -2 = 23
     *   The largest number in the tree is 18, and 4 is the smallest.
     *   Thus the range of the tree is 18 - 4 = 14
     *   23 is bigger than 14, so the list has the bigger range.
     *    
     * 
     * @param head the head of the list
     * @param root the root of the tree
     * @return "list" if the list has a bigger range, "tree" otherwise
     */
    public static String biggerRange(ListNode head, TreeNode root) {
        int high = highestInTree(root);
        int low = lowestInTree(root);

        int highList = Integer.MIN_VALUE;
        int lowList = Integer.MAX_VALUE;
        ListNode current = head;
        while (current != null) {
            if(current.data < lowList){
                lowList = current.data;
            }
            if(current.data > highList){
                highList = current.data;
            }
            current = current.next;
        }

        int difference = (high - low) - (highList - lowList);
        if(difference > 0 ){
            return "tree";
        }
        return "list";
    }

    public static int highestInTree(TreeNode root){
        int highest = Integer.MIN_VALUE;
        if(root == null) return highest;

        if(root.data > highest) highest = root.data;
        int left = highestInTree(root.left);
        int right = highestInTree(root.right);
        if(left >  highest) highest = left;
        if(right > highest) highest = right;

        return highest;
    }

    public static int lowestInTree(TreeNode root){
        int lowest = Integer.MAX_VALUE;
        if(root == null) return lowest;

        if(root.data < lowest) lowest = root.data;
        int left = lowestInTree(root.left);
        int right = lowestInTree(root.right);
        if(left <  lowest) lowest = left;
        if(right < lowest) lowest = right;

        return lowest;
    }


}
