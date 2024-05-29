class reduce_binary_rep_to_one:
    def numSteps(s):
        # Variables for steps and carry bit.
        steps = 0
        carry = 0
        
        # For loop starting at the least significant bit and moving left.
        for i in range(len(s) - 1, 0, -1):
            if int(s[i]) + carry == 1: #the bit is odd. 2 operations.
                carry = 1
                steps += 2
            else: #bit is even, 1 operation.
                steps += 1
        
        return steps + carry

# Example 1
s1 = "1101"

print(f'Example 1: {reduce_binary_rep_to_one.numSteps(s1)}')

# Example 2
s2 = "10"

print(f'Example 2: {reduce_binary_rep_to_one.numSteps(s2)}')
