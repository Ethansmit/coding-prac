class majority_element(object):
    def majorityElement(self, nums):
        count = 0 
        candidate = 0
        
        for num in nums:
            if num == candidate:
                count += 1
            else:
                count -= 1
                if count <= 0:
                    candidate = num
                    count = 1
        
        return candidate

majElem = majority_element

# Example 1
nums1 = [3,2,3,3]
print(f'Example 1: {majority_element.majorityElement(majElem, nums1)}')

# Example 2
nums2 = [2,2,1,1,1,2,2]
print(f'Example 2: {majority_element.majorityElement(majElem, nums2)}')
