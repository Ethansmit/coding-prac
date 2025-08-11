class LongestCommonPrefix:
    def longestCommonPrefix(self, strs):
        shortestStr = min(strs, key=len)
        
        prefix = shortestStr
        
        for word in strs:
            while not word.startswith(prefix):
                # Reduce the prefix by one character at at ime.
                prefix = prefix[:-1]
                # Return empty if no prefix left.
                if not prefix:
                    return ""
        
        return prefix

def testLongestCommonPrefix(testCases):
    obj = LongestCommonPrefix()
    
    for i, (testInput, testExpected) in enumerate(testCases):
        output = obj.longestCommonPrefix(testInput)
        assert output == testExpected, f"Test case {i+1} failed: {output} != {testExpected}"
    
    print("All test cases passed.")

def main():
    testCases = [
    (["flower", "flow", "flight"], "fl"),
    (["dog", "racecar", "car"], ""),
    (["interspecies", "interstellar", "interstate"], "inters"),
    (["throne", "throne"], "throne"),
    (["throne", "throne", "throne"], "throne"),
    (["throne", "dungeon"], ""),
    (["prefix", "pretest", "preliminary"], "pre"),
    (["Hello"], "Hello")
]
    
    testLongestCommonPrefix(testCases)

if __name__=="__main__":
    main()