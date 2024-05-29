class reg_expression_matching:
    def isMatch(s,p):
        # Helper function call with empty cache to store intermediate results.
        return reg_expression_matching.backtrack({}, s, p, len(s) - 1, len(p) - 1)

    def backtrack(cache, s, p, i, j):
        key = (i, j)
        
        # Question already computed, return result.
        if key in cache:
            return cache[key]

        # Base Case 1: Both strings exhausted, match.
        if i == -1 and j == -1:
            cache[key] = True
            return True

        # Base Case 2: Pattern exhausted but not string, not a match.
        if i != -1 and j == -1:
            cache[key] = False
            return cache[key]

        # Base Case 3: If string exhausted and pattern contains '*', check for match.
        if i == -1 and p[j] == '*':
            k = j
            # Traverse back in pattern to find match or ensure all are '*'.
            while k != -1 and p[k] == '*':
                k -= 2
            
            # If reached start of pattern and all are '*', match.
            if k == -1:
                cache[key] = True
                return cache[key]
            
            # Otherwise not match.
            cache[key] = False
            return cache[key]
        
        # Base Case 4: If string exhausted and current pattern is not '*', not match.
        if i == -1 and p[j] != '*':
            cache[key] = False
            return cache[key]

        # If Current pattern '*' check following options.
        if p[j] == '*':
            
            # Option 1: Ignore '*' and preceding character in pattern.
            if reg_expression_matching.backtrack(cache, s, p, i, j - 2):
                cache[key] = True
                return cache[key]
            
            # Option 2: Match preceding character with current string character.
            if p[j - 1] == s[i] or p[j - 1] == '.':
                if reg_expression_matching.backtrack(cache, s, p, i - 1, j):
                    cache[key] = True
                    return cache[key]
        
        # If current pattern char matches current string or is '.'
        if p[j] == '.' or s[i] == p[j]:
            if reg_expression_matching.backtrack(cache, s, p, i - 1, j - 1):
                cache[key] = True
                return cache[key]

        # If none of the cases above, store as false.
        cache[key] = False
        return cache[key]

# Example 1
string1 = "aa"
pattern1 = "a"
print(f'Example 1: {reg_expression_matching.isMatch(string1, pattern1)}')

# Example 2
string2 = "ab"
pattern2 = ".*"
print(f'Example 2: {reg_expression_matching.isMatch(string2, pattern2)}')