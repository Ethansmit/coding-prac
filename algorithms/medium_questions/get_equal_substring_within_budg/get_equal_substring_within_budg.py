class get_equal_sub_within_budg: 
    def equalSubstring(s, t, maxCost):
        sub_len = ptr1 = cost = 0
        
        for ptr2 in range(len(s)):
            cost += abs(ord(s[ptr2]) - ord(t[ptr2]))
            
            while cost > maxCost:
                cost -= abs(ord(s[ptr1]) - ord(t[ptr1]))
                ptr1 += 1
                
            sub_len = max(sub_len, ptr2 - ptr1 + 1)
        
        return sub_len


# Example 1
s1 = "abcd"
t1 = "bcdf"
maxCost = 3
print(f'Example 1: {get_equal_sub_within_budg.equalSubstring(s1, t1, maxCost)}')

# Example 2
s2 = "abcd"
t2 = "acde"
maxCost = 0
print(f'Example 2: {get_equal_sub_within_budg.equalSubstring(s2, t2, maxCost)}')