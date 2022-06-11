package tree;

import java.security.PublicKey;

public class BinaryTreeIntData {

    public Integer vue;

    public BinaryTreeIntData left;
    public BinaryTreeIntData right;

    public BinaryTreeIntData(Integer vue) {
        this.vue = vue;
        this.left = null;
        this.left = null;
    }

    public BinaryTreeIntData(Integer vue, BinaryTreeIntData left, BinaryTreeIntData right) {
        this.vue = vue;
        this.left = left;
        this.right = right;
    }
}
