from collections import Counter

class FindCommonCharacters(object):
    def commonChars(self, words):
        if not words:
            return []
        
        # Initialize the counter with the first word's character counts
        common_count = Counter(words[0])
        
        # Intersect the counter with counts from the rest of the words
        for word in words[1:]:
            common_count &= Counter(word)
        
        # Expand the counter to the result list
        result = list(common_count.elements())
        
        return result
    
def testCommonChars(test_cases):

    for i, (input_words, expected_output) in enumerate(test_cases):
        output = FindCommonCharacters.commonChars(FindCommonCharacters, input_words)
        assert sorted(output) == sorted(expected_output), f"Test case {i+1} failed: {output} != {expected_output}"
    
    print("All test cases passed.")

def main():
    test_cases = [
        (["bella", "label", "roller"], ["e", "l", "l"]),  # Common characters
        (["cool", "lock", "cook"], ["c", "o"]),           # Common characters with varying frequencies
        (["abc", "def", "ghi"], []),                      # No common characters
        (["aaa", "aaa", "aaa"], ["a", "a", "a"]),         # All identical words
        (["abcdef", "abc", "ab"], ["a", "b"]),            # Subset words
        (["", "a", "b"], []),                             # Edge case with empty string
        (["abcd"], ["a", "b", "c", "d"]),                 # Single word
        ([], []),                                         # No words
    ]
    
    testCommonChars(test_cases)

if __name__=="__main__":
    main()