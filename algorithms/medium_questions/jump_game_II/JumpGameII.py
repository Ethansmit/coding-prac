class JumpGameII:
    def jump(self, nums):
        n = len(nums)
        i = max_reach = last_pos = jumps = 0
        
        while (last_pos < n - 1):
            max_reach = max(max_reach, i + nums[i])
            # Check if we have reached the max reach from selected position.
            if (i == last_pos):
                last_pos = max_reach
                jumps += 1
            i += 1
        return jumps


def testJump(testCases):
    obj = JumpGameII()
    
    for i, (testInput, testExpected) in enumerate(testCases):
        output = obj.jump(testInput)
        assert output == testExpected, f"Test case {i+1} failed: {output} != {testExpected}"
    
    print("All test cases passed.")

def main():
    testCases = [
    ([2, 3, 1, 1, 4], 2),
    ([4, 0, 0, 0, 1], 1),
    ([1,2,1,4,3,0,0,1,3,2,1], 5),
    ([1], 0),
    ([1,1,1,1,1,1,1,1,1,1,1,1], 11),
    ([2,3,0,1,4], 2),
    ([1,3,2,1,1,4,3,0,1,1], 4)
]
    
    testJump(testCases)

if __name__=="__main__":
    main()