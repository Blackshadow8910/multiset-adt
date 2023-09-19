import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public boolean contains(T value) {
        if (value == root) {
            return true;
        }

        for (Tree<T> subtree : subtrees) {
            if (subtree.contains(value)) {
                return true;
            }
        }
        return false;
    }

    public List<Tree<T>> getLeaves() {
        if (isEmpty()) {
            return List.of();
        } else if (subtrees.isEmpty()) {
            return List.of(this);
        } else {
            List<Tree<T>> result = new ArrayList<>();

            for (Tree<T> subtree : subtrees) {
                result.addAll(subtree.getLeaves());
            }
            return result;
        }
    }


    private void deleteRoot() {
        if (subtrees.isEmpty()) {
            root = null;
        } else {
            Tree<T> subtree = subtrees.remove(0);

            root = subtree.root;
            subtrees.addAll(subtree.subtrees);
        }
    }

    public boolean deleteItem(T value) {
        if (isEmpty()) {
            return false;
        } else if (root == value) {
            deleteRoot();
            return true;
        } else {
            for (Tree<T> subtree : subtrees) {
                boolean deleted = subtree.deleteItem(value);
                if (deleted) {
                    if (subtree.isEmpty()) {
                        subtrees.remove(subtree);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void insert(T value) {
        if (isEmpty()) {
            root = value;
        } else if (subtrees.isEmpty()) {
            subtrees.add(new Tree<T>(value));
        } else {
            Random rng = new Random();
            if (rng.nextInt(3) == 2) {
                subtrees.add(new Tree<T>(value));
            } else {
                int subtreeIndex = rng.nextInt(subtrees.size());
                subtrees.get(subtreeIndex).insert(value);
            }
        }
    }
}
