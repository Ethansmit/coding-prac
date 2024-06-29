class GetEqualSubWithinBudg: 
    def equalSubstring(s, t, max_cost):
        sub_len = ptr1 = cost = 0
        
        for ptr2 in range(len(s)):
            cost += abs(ord(s[ptr2]) - ord(t[ptr2]))
            
            while cost > max_cost:
                cost -= abs(ord(s[ptr1]) - ord(t[ptr1]))
                ptr1 += 1
                
            sub_len = max(sub_len, ptr2 - ptr1 + 1)
        
        return sub_len

def testCommonChars(test_cases):

    for i, (s, t, max_cost, expected_output) in enumerate(test_cases):
        output = GetEqualSubWithinBudg.equalSubstring(s, t, max_cost)
        assert output == expected_output, f"Test case {i+1} failed: {output} != {expected_output}"
    
    print("All test cases passed.")

def main():
    test_cases = [
        ("abcd", "bcdf", 3, 3),
        ("abcd", "acde", 0, 1),
        ("w", "w", 0, 1),
        ("werfs", "wezft", 5, 2),
        ("abcd", "wwww", 1, 0),
        ("abcd", "bcdf", 0, 0),
        ("tw", "aa", 100, 2)
    ]
    
    testCommonChars(test_cases)

if __name__=="__main__":
    main()