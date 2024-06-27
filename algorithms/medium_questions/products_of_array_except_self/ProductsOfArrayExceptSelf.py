from collections import Counter

class ProductsOfArrayExceptSelf(object):
    def product_except_self(self, nums):
        n = len(nums)
        output = [1] * n
        
        for i in range(1, n):
            output[i] = output[i - 1] * nums[i - 1]

        right = nums[n - 1]
        for i in range(n - 2, -1, -1):
            output[i] *= right
            right *= nums[i]
        
        return output
    
def test_common_chars(test_cases):
    for i, (input_words, expected_output) in enumerate(test_cases):
        output = ProductsOfArrayExceptSelf.product_except_self(ProductsOfArrayExceptSelf, input_words)
        assert sorted(output) == sorted(expected_output), f"Test case {i+1} failed: {output} != {expected_output}"
    
    print("All test cases passed.")

def main():
    test_cases = [
        ([1, 2, 3, 4], [24, 12, 8, 6]),
        ([-1, 1, 0, -3, 3], [0, 0, 9, 0, 0]),
        ([1, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]),
        ([1, 5, 3, 9, 2], [270, 54, 90, 30, 135]),
        ([9, 9, 9, 9], [729, 729, 729, 729]),
        ([1], [1]),
        ([0, 0, 0, 0, 0], [0, 0, 0, 0, 0]),
        ([32, 1, 3, 2, 22, 10], [1320, 42240, 14080, 21120, 1920, 4224])
        
    ]
    
    test_common_chars(test_cases)

if __name__=="__main__":
    main()