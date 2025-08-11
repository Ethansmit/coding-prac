#include <iostream>
#include <string>
#include <vector>

class LengthOfLastWord {
    public:
        static int lengthOfLastWord(std::string s) {
            int tail = s.size() - 1;
            int length = 0;

            // Remove spaces.
            while (tail && s[tail] == ' ') { tail--;}

            // Count length until space.
            while (tail >= 0 && s[tail--] != ' ') { length++; }

            return length;
        }
};


void runTests(const std::vector<std::string> &inputs, const std::vector<int> &expectedOutputs) {
    LengthOfLastWord obj;

    int correct = 1;
    for (size_t i = 0; i < inputs.size(); ++i) {
        int result = obj.lengthOfLastWord(inputs[i]);
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
    std::vector<std::string> inputs = {
        {"Hello World"},
        {"George is the coolest"},
        {"Goodbye    to     you   "},
        {"Coding"},
        {"a                         "},
        {"                          a"}
    };
    
    std::vector<int> expectedOutputs = {
        5,
        7,
        3,
        6,
        1,
        1
    };

    runTests(inputs, expectedOutputs);

    return 0;
}