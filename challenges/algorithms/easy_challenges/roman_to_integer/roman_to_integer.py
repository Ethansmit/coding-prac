class roman_to_int(object):
    def romanToInt(self, s):
        result = 0
        
        # Dictionary for Roman numerals.
        m = {
            'I': 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000
        }
        
        for i in range(len(s)):
            # Check for subtraction character.
            if i < len(s) - 1 and m[s[i]] < m[s[i + 1]]:
                result -= m[s[i]]
            else: #Else normal character.
                result += m[s[i]]
        
        return result
        


rome_to_int = roman_to_int
# Example 1
s1 = "III"
print(f'Example 1: {roman_to_int.romanToInt(rome_to_int,s1)}')

# Example 2
s2 = "MCMXCIV"
print(f'Example 2: {roman_to_int.romanToInt(rome_to_int,s2)}')