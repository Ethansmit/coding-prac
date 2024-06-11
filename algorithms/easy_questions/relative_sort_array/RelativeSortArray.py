import collections

class RelativeSortArray(object):
    def relativeSortArray(self, arr1, arr2):
        sortArr = []
        elemCount = collections.Counter(arr1)
        
        # Put elements of arr2 in result.
        for i in arr2:
            for _ in range(elemCount.pop(i)):
                sortArr.append(i)
        
        # Put rest of elements in.
        for i in range(min(arr1), max(arr1) + 1):
            for _ in range(elemCount.pop(i, 0)):
                sortArr.append(i)
        
        return sortArr


def testRelativeSortArray(testCases):
    obj = RelativeSortArray
    
    for i, (testArr1, testArr2, testExpected) in enumerate(testCases):
        output = obj.relativeSortArray(obj, testArr1, testArr2)
        assert output == testExpected, f"Test case {i+1} failed: {output} != {testExpected}"
    
    print("All test cases passed.")

def main():
    testCases = [
         ([2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19], [2, 1, 4, 3, 9, 6], 
          [2,2,2,1,4,3,3,9,6,7,19]),
         ([28, 6, 22, 8, 44, 17], [22, 28, 8, 6], 
          [22, 28, 8, 6, 17, 44]),
         ([0, 0, 1, 0, 0, 0, 0], [0], 
          [0, 0, 0, 0, 0, 0, 1]),
         ([2, 3, 1, 4, 7, 6, 5], [3, 7, 4, 1], 
          [3, 7, 4, 1, 2, 5, 6]),
         ([1, 2, 3, 4, 5], [1, 2, 3, 4, 5], 
          [1, 2, 3, 4, 5]),
         ([5, 5, 5, 1, 1, 1, 2, 2, 3, 3, 4, 4], [5, 1, 2], 
          [5, 5, 5, 1, 1, 1, 2, 2, 3, 3, 4, 4])
    ]
    testRelativeSortArray(testCases)

if __name__=="__main__":
    main()