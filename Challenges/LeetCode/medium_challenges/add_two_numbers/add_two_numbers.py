from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def addNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        # This is the header value of the return list.
        returnList = ListNode(0)

        # Temp Node to move through return list for results.
        currentNode = returnList

        # Carry value to add to next node in the list.
        carryVal = 0

        
        while l1 != None or l2 != None or carryVal != 0:
            # Set Values and Add
            l1Num = l1.val if l1 else 0
            l2Num = l2.val if l2 else 0
            currentSum = l1Num + l2Num + carryVal

            # Perform carry calculation for next operation and create Node
            carryVal = currentSum // 10
            newNode = ListNode(currentSum % 10)
            currentNode.next = newNode
            currentNode = newNode

            # Move the lists forward.
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
        return returnList.next

# --- Helper functions ---
def list_to_linkedlist(nums):
    """Convert a list into a linked list."""
    dummy = ListNode(0)
    curr = dummy
    for n in nums:
        curr.next = ListNode(n)
        curr = curr.next
    return dummy.next

def linkedlist_to_list(node):
    """Convert a linked list back into a Python list."""
    result = []
    while node:
        result.append(node.val)
        node = node.next
    return result


# --- Test Cases ---
tests = [
    {"l1": [2,4,3], "l2": [5,6,4], "expected": [7,0,8]},
    {"l1": [0], "l2": [0], "expected": [0]},
    {"l1": [9,9,9,9,9,9,9], "l2": [9,9,9,9], "expected": [8,9,9,9,0,0,0,1]},
    {"l1": [5], "l2": [5], "expected": [0,1]},
    {"l1": [1,2,3], "l2": [7], "expected": [8,2,3]},
    {"l1": [9,9], "l2": [1], "expected": [0,0,1]},
    {"l1": [1], "l2": [9,9,9,9,9], "expected": [0,0,0,0,0,1]},
    {"l1": [9,8,7,6,5,4,3,2,1], "l2": [1,2,3,4,5,6,7,8,9], "expected": [0,1,1,1,1,1,1,1,1,1]},
    {"l1": [], "l2": [1,2,3], "expected": [1,2,3]},
    {"l1": [0,0,1], "l2": [0,0,9], "expected": [0,0,0,1]},
]


# --- Run Tests ---
solver = Solution()
for i, t in enumerate(tests, 1):
    l1 = list_to_linkedlist(t["l1"])
    l2 = list_to_linkedlist(t["l2"])
    result = solver.addNumbers(l1, l2)
    result_list = linkedlist_to_list(result)
    print(f"Test {i} {'PASS' if result_list == t['expected'] else 'FAIL'}")