class Solution:
    """
    By: Ethan Smith
    Date: 2/11/2026

    Description:
    Here are two solutions to the two sum problem. The Bruteforce is two for loops which compares
    all possible solutions. The Complements method creates a hash table which then stores the
    complementary value of each value in the input list, and if a given value in the input 
    list has a complement which is in the dictionary, then the two solution problem has been
    solved. Complements method solves the issue in O(n) time.
    """
    def bruteForce(nums: list[int], target: int) -> list[int]:
        """
        Brute force approach of two sum.

        input:
        @list[int] nums: input list.
        @int target: given summed value.
        """

        # length of nums
        length = len(nums)

        # Loops for finding target
        for i in range(length - 1):
            for j in range(i + 1, length):
                if nums[i] + nums[j] == target:
                    return [i, j]
        return []
    
    def complements(nums: list[int], target: int) -> list[int]:
        """
        Brute force approach of two sum.

        input:
        @list[int] nums: input list.
        @int target: given summed value.
        """

        # hash table
        numDict = {}
        # length of nums
        length = len(nums)
        
        for i in range(length):
            complement = target - nums[i]
            if complement in numDict:
                return [numDict[complement], i]
            numDict[nums[i]] = i

test1 = [5,6,12,9,13]
target1 = 14
test2 = [1,2,3,4,5]
target2 = 7

print (Solution.complements(test1, target1))
print (Solution.complements(test2, target2))