# Class for the binary tree data structure.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None) -> None:
        self.val = val
        self.left = left
        self.right = right

# Class for the solution functions.
class Solution(object):
    # Function to return the result of the evaluation.
    def evaluateTree(self, root) -> bool:
        return self.traverse(root)
    
    # Function to traverse through the tree recursively.
    def traverse(self, root):
        # If Val is True(1) or False(0)
        if root.val == 0 or root.val == 1:
            return root.val == 1
        # If val is OR boolean function.
        elif root.val == 2:
            return self.traverse(root.left) or self.traverse(root.right)
        # If val is AND boolean function.
        elif root.val == 3:
            return self.traverse(root.left) and self.traverse(root.right)
        # end case.
        return False

# function to build tree from a given list.
def build_tree_from_list(lst):
    if not lst:
        return None
    nodes = [TreeNode(val=x) if x is not None else None for x in lst]
    kids = nodes[::-1]
    root = kids.pop()
    for node in nodes:
        if node:
            if kids: node.left = kids.pop()
            if kids: node.right = kids.pop()
    return root

# Test cases. 
test1 = [3,2,3,0,1,1,1]
test2 = [0]
test3 = [3,2,2,0,1,0,0]
test4 = [2,1,3,None, None,0,1]

root1 = build_tree_from_list(test1)
root2 = build_tree_from_list(test2)
root3 = build_tree_from_list(test3)
root4 = build_tree_from_list(test4)

solution = Solution()

result1 = solution.evaluateTree(root1)
result2 = solution.evaluateTree(root2)
result3 = solution.evaluateTree(root3)
result4 = solution.evaluateTree(root4)

print(result1)
print(result2)
print(result3)
print(result4)