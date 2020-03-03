package outco.outcome.util;

import outco.outcome.question.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ArrayToBinaryTreeConverter {


    public static TreeNode<Integer> deserialize(int[] arr, int nullValue) {

        if (arr == null || arr.length == 0) {
            return null;
        }

        TreeNode<Integer> root = new TreeNode<>(arr[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for (int i = 1; i < arr.length; i += 2) {

            if (!queue.isEmpty()) {
                TreeNode current = queue.poll();

                if (arr[i] != nullValue) {
                    current.left = new TreeNode<>(arr[i]);
                    queue.add(current.left);
                }

                if (i + 1 <= arr.length - 1 && arr[i + 1] != nullValue) {
                    current.right = new TreeNode<>(arr[i + 1]);
                    queue.add(current.right);
                }
            }

        }
        return root;
    }
}
