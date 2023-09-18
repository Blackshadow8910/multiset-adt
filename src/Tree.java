import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * A recursive tree data structure, which provides services required of the
 * MultiSet ADT. See TreeMultiSet, which is the next class defined.
 * This is a simplified version of the Tree data structure
 * adapted from CSC148.
 */
public class Tree<T> {
    @Nullable
    private T root;

    private List<Tree<T>> subtrees;

    public Tree(@Nullable T root, List<Tree<T>> subtrees) {
        this.root = root;
        this.subtrees = subtrees;
    }

    public Tree (@Nullable T root) {
        this(root, List.of());
    }

    public Tree() {
        this(null);
    }


    public boolean isEmpty() {
        return this.root == null;
    }

    public int size() {
        int n = isEmpty() ? 0 : 1;

        for (Tree<T> subtree : subtrees) {
            n += subtree.size();
        }

        return n;
    }

    public int count(T value) {
        int n = (isEmpty() || root != value) ? 0 : 1;

        for (Tree<T> subtree : subtrees) {
            n += subtree.count(value);
        }

        return n;
    }

    @Override
    public String toString() {
        return toIndentedString(0);
    }

    private String toIndentedString(int depth) {
        if (isEmpty()) {
            return "";
        } else {
            String s = "  ".repeat(depth) + root.toString() + "\n";
            for (Tree<T> subtree : subtrees) {
                s += subtree.toIndentedString(depth + 1);
            }
            return s;
        }
    }

    public
}
