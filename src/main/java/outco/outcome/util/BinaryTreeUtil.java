package outco.outcome.util;


import outco.outcome.question.model.TreeNode;

import static java.lang.Math.max;

public class BinaryTreeUtil {

    public static int maxLevel(TreeNode node) {

        if (node == null) {
            return 0;
        }

        return max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }
}
