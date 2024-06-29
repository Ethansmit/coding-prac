#include <iostream>
#include <string>
#include <vector>

class IntegerToRoman {
    public:
        static std::string intToRoman(int num) {
            std::string symbols[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            
            std::string roman = "";
            
            for (int i = 0; num != 0; i++) {
                // Append current symbol while num is larger than current value[i].
                while (num >= values[i]) {
                    roman += symbols[i];
                    num -= values[i];
                }
            }
            
            return roman;
        }
};

void runTests(const std::vector<int>& inputs, const std::vector<std::string>& expectedOutputs) {
    IntegerToRoman obj;

    int correct = 1;
    for (size_t i = 0; i < inputs.size(); ++i) {

        std::string result = obj.intToRoman(inputs[i]);
        if (result != expectedOutputs[i]) {
            std::cout << "Test case " << i + 1 << " failed!" << std::endl;
            std::cout << "Expected: " << expectedOutputs[i] << std::endl;
            std::cout << "Got: " << result << std::endl;
            correct = 0;
        } 
    }
    if (correct) {
        std::cout << "All test cases passed." << std::endl;
    }
}

int main() {
    std::vector<int> inputs = {
        58,
        3749,
        1994,
        10,
        1,
        324,
        92,
        5325,
        490,
        1230
    };
    
    std::vector<std::string> expectedOutputs = {
        "LVIII",
        "MMMDCCXLIX",
        "MCMXCIV",
        "X",
        "I",
        "CCCXXIV",
        "XCII",
        "MMMMMCCCXXV",
        "CDXC",
        "MCCXXX"
    };

    runTests(inputs, expectedOutputs);

    return 0;
}