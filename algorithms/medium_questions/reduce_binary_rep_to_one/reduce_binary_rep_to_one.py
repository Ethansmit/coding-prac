class reduce_binary_rep_to_one:
    def numSteps(s):
        steps = 0
        carry = 0
        
        for i in range(len(s) - 1, 0, -1):
            if int(s[i]) + carry == 1:
                carry = 1
                steps += 2
            else:
                steps += 1
        
        return steps + carry

# Example 1
s1 = "1101"

print(f'Example 1: {reduce_binary_rep_to_one.numSteps(s1)}')

# Example 2
s2 = "10"

print(f'Example 2: {reduce_binary_rep_to_one.numSteps(s2)}')
