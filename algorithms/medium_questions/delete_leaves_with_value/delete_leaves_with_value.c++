#include <vector>
#include <queue>
#include <iostream>

struct  TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class delete_leaves_with_value {
    public:
        static TreeNode* removeLeafNodes(TreeNode* root, int target, TreeNode *parent = NULL) {
            // Check if root is null.
            if (!root) return NULL;

            // Postorder traversal call. This is to ensure that we only need
            // one sweep through the tree to delete all required nodes.
            root->left = removeLeafNodes(root->left, target, root);
            root->right = removeLeafNodes(root->right, target, root);

            // Check if leaf node and val is the target. If so, delete node.
            if (!root->left && !root->right && root->val == target) {
                if (parent) delete root;
                return NULL;
            }

            return root;
        }

        // Function to convert an input vector into a tree.
        static TreeNode* build_tree_from_list(const std::vector<int> &list) {
            if (list.empty()) return nullptr;

            TreeNode *root = new TreeNode(list[0]);
            std::queue<TreeNode*> nodeQueue;
            nodeQueue.push(root);

            int i = 1;
            while (i < list.size()) {
                TreeNode *curr = nodeQueue.front();
                nodeQueue.pop();

                if (i < list.size() && list[i] != -1) {
                    curr->left = new TreeNode(list[i]);
                    nodeQueue.push(curr->left);
                }
                i++;

                if (i < list.size() && list[i] != -1) {
                    curr->right = new TreeNode(list[i]);
                    nodeQueue.push(curr->right);
                }
                i++;
            }

            return root;
        }

        // Function to print tree.
        static void print_tree(TreeNode *root) {
            if (!root) return;

            std::queue<TreeNode*> q;
            q.push(root);

            while (!q.empty()) {
                TreeNode* node = q.front();
                q.pop();

                if (node) {
                    std::cout << node->val << " ";
                    q.push(node->left);
                    q.push(node->right);
                } else {
                    std::cout << "null ";
                }
            }
            std::cout << std::endl;
        }
};

int main() {
    // Example 1
    std::vector<int> test1 = {1,3,3,2,NULL,2,4};
    int target = 2;

    TreeNode *root1 = delete_leaves_with_value::build_tree_from_list(test1);
    root1 = delete_leaves_with_value::removeLeafNodes(root1, target);
    delete_leaves_with_value::print_tree(root1);

    // Example 2
    std::vector<int> test2 = {1,3,3,3,2};
    target = 3;

    TreeNode *root2 = delete_leaves_with_value::build_tree_from_list(test2);
    root2 = delete_leaves_with_value::removeLeafNodes(root2, target);
    delete_leaves_with_value::print_tree(root2);

}