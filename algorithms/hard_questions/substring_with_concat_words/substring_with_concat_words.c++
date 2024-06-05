#include <algorithm>
#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>
#include <map>

class substring_with_concat_wrds {
    public:
        std::vector<int> findSubstring(std::string s, std::vector<std::string> &words) {
            std::vector<int> result;

            // Two maps to store the frequency of words found in the window.
            std::map<std::string,int> word_freq,record;
            for(auto i:words) { word_freq[i]++;}

            // Variables for usage later.
            int word_length = words[0].size();
            int word_count = words.size();
            int s_len = s.size();

            // Sliding window
            for (int i = 0; i < word_length; i++) {
                // Left window and total words.
                int window_left = i;
                int substr_words = 0;
                // Clear record for each window analysis.
                record.clear();
                // Look at current window.
                for (int j = i; j <= s_len - word_length; j += word_length) {
                    // current word
                    std::string temp = s.substr(j,word_length);
                    // Check if current word is in 'words'
                    if (word_freq.find(temp) != word_freq.end()) {
                        // add to record map and substring count.
                        record[temp]++;
                        substr_words++;
                        // Check if frequency of word is not too big.
                        while (record[temp] > word_freq[temp]) {
                            record[s.substr(window_left,word_length)]--;
                            window_left+=word_length;
                            substr_words--;
                        }
                        // If the substring words is equal to word count
                        // without failing the above cases, then we have a
                        // correct concatenation.
                        if (substr_words == word_count) {
                            result.push_back(window_left);
                        }
                    }
                    // If the word is not in word_freq, reset the window.
                    else{
                        record.clear();
                        substr_words=0;
                        window_left=j+word_length;
                    }

                }
            }
            return result;
        }
};

void runTests(std::vector<std::pair<std::string, std::vector<std::string>>> inputs, std::vector<std::vector<int>> expectedOutputs) {
    substring_with_concat_wrds solution;
    int correct = 1;
    for (size_t i = 0; i < inputs.size(); ++i) {
        std::vector<int> result = solution.findSubstring(inputs[i].first, inputs[i].second);
        std::sort(result.begin(), result.end());
        std::sort(expectedOutputs[i].begin(), expectedOutputs[i].end());
        if (result != expectedOutputs[i]) {
            std::cout << "Test case " << i + 1 << " failed!" << std::endl;
            std::cout << "Expected: ";
            for (int index : expectedOutputs[i]) {
                std::cout << index << " ";
            }
            std::cout << "\nGot: ";
            for (int index : result) {
                std::cout << index << " ";
            }
            std::cout << std::endl;
            correct = 0;
        } 
    }
    if (correct) {std::cout << "All test cases passed.";}
}

int main() {
    std::vector<std::pair<std::string, std::vector<std::string>>> inputs = {
        {"barfoothefoobarman", {"foo", "bar"}},
        {"wordgoodgoodgoodbestword", {"word", "good", "best", "word"}},
        {"barfoofoobarthefoobarman", {"bar", "foo", "the"}},
        {"lingmindraboofooowingdingbarrwingmonkeypoundcake", {"fooo", "barr", "wing", "ding", "wing"}},
        {"catbatatecatatebat", {"cat", "bat", "ate"}},
        {"aaa", {"a", "a"}},
        {"foobarfoobar", {"foo", "bar"}},
        {"abababab", {"ab", "ba"}}
    };
    
    std::vector<std::vector<int>> expectedOutputs = {
        {0, 9},
        {},
        {6, 9, 12},
        {13},
        {0, 3, 9},
        {0, 1},
        {0, 3, 6},
        {}
    };

    runTests(inputs, expectedOutputs);

    return 0;
}