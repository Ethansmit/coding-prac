#include <iostream>
#include <string>
#include <vector>

class IntegerToRoman {
    public:
        static int intToRoman(std::string haystack, std::string needle) {
            int h_len = haystack.size();
            int n_len  = needle.size();

            std::vector<int> lps = computeLPSArray(needle);

            // i is index of haystack, j is index of needle.
            for (int i = 0, j = 0; i < h_len;) {
                if (haystack[i] == needle[j]) { 
                    i++, j++;
                }
                // If true we have match
                if (j == n_len) {
                    return i - j;
                }
                // Update indexes using lps when failing
                if (i < h_len && haystack[i] != needle[j]) {
                    if (j != 0) {
                        j = lps[j - 1];
                    } else {
                        i++;
                    }
                }
            }
            return -1;
        }
    private:
        static std::vector<int> computeLPSArray(std::string needle) {
            int n_len = needle.size();

            std::vector<int> lps(n_len, 0);

            // Populate lps.
            for (int i = 1, len = 0; i < n_len;) {
                if (needle[i] == needle[len]) {
                    lps[i++] = ++len;
                } else if (len) {
                    len = lps[len - 1];
                } else {
                    lps[i++] = 0;
                }
            }
            return lps;
        }
};

void runTests(const std::vector<std::pair<std::string, std::string>>& inputs, const std::vector<int>& expectedOutputs) {
    IntegerToRoman obj;

    int correct = 1;
    for (size_t i = 0; i < inputs.size(); ++i) {
        int result = obj.intToRoman(inputs[i].first, inputs[i].second);
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
    std::vector<std::pair<std::string, std::string>> inputs = {
        {"happyandglad", "happy"},
        {"hello", "ll"},
        {"aaaaa", "b"},
        {"abc", "c"},
        {"same", "same"},
        {"short", "longerthan"},
        {"mississippi", "issi"}
    };
    
    std::vector<int> expectedOutputs = {
        0,
        2,
        -1,
        2,
        0,
        -1,
        1
    };

    runTests(inputs, expectedOutputs);

    return 0;
}