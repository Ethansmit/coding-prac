class longest_common_prefix:
    def longestCommonPrefix(self, strs):
        # Find the shortest string in the array.
        shortest_str = min(strs, key=len)
        
        # Returned result. We will reduce the word until we obtain the longest prefix
        # with every word in strs.
        prefix = shortest_str
        
        # loop through the strings in strs.
        for word in strs:
            # Compare the prefix with the string until we have the longest prefix for a word.
            while not word.startswith(prefix):
                # Reduce the prefix by one character at at ime.
                prefix = prefix[:-1]
                if not prefix:
                    # If preix is empty, then return empty.
                    return ""
        
        return prefix

def main():
    obj = longest_common_prefix()
    # Example 1, answer "fl"
    strs1 = ["flower","flow","flight"]
    print(f'Example 1: {obj.longestCommonPrefix(strs1)}')

    # Example 2, answer ""
    strs2 = ["dog","racecar","car"]
    print(f'Example 2: {obj.longestCommonPrefix(strs2)}')

    # Example 3, answer "inter"
    strs3 = ["interspecies", "interstate", "interstellar", "interdimension", "intergalactic", "interinter"]
    print(f'Example 3: {obj.longestCommonPrefix(strs3)}')

    # Example 4, answer "throne"
    strs4 = ["throne", "throne", "throne"]
    print(f'Example 4: {obj.longestCommonPrefix(strs4)}')

    # Example 5, answer "Hello"
    strs5 = ["Hello"]
    print(f'Example 5: {obj.longestCommonPrefix(strs5)}')

if __name__=="__main__":
    main()