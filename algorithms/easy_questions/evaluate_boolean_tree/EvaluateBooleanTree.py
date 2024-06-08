class TreeNode(object):
    def __init__(self, val=0, left=None, right=None) -> None:
        self.val = val
        self.left = left
        self.right = right

class EvaluateBooleanTree(object):
    def evaluateTree(self, root) -> bool:
        return self.traverse(self, root)
    
    def traverse(self, root):
        # Leaf node Case
        if root.val == 0 or root.val == 1:
            return root.val == 1
        # OR node Case
        elif root.val == 2:
            return self.traverse(self, root.left) or self.traverse(self, root.right)
        # AND node Case
        elif root.val == 3:
            return self.traverse(self, root.left) and self.traverse(self, root.right)
        
        return False

def buildTreeFromList(lst):
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

def test_common_chars(test_cases):
    obj = EvaluateBooleanTree
    
    for i, (input_tree, boolean_output) in enumerate(test_cases):
        tree = buildTreeFromList(input_tree)
        output = obj.evaluateTree(obj, tree)
        assert output == boolean_output, f"Test case {i+1} failed: {output} != {boolean_output}"
    
    print("All test cases passed.")

def main():
    test_cases = [
        ([3,2,3,0,1,1,1], True),
        ([0], False),
        ([3,2,2,0,1,0,0], False),              
        ([2,1,3,None, None,0,1], True)
    ]
    
    test_common_chars(test_cases)

if __name__=="__main__":
    main()