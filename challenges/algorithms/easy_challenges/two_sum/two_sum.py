class Solution:
    def bruteForce(nums: list[int], target: int) -> list[int]:
        # length of nums
        length = len(nums)
        # Loops for finding target
        for i in range(length - 1):
            for j in range(i + 1, length):
                if nums[i] + nums[j] == target:
                    return [i, j]
        return []
    
    def complements(nums: list[int], target: int) -> list[int]:
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