#include <iostream>
#include <map>
#include <vector>

class hand_of_straights {
    public:
        bool isNStraightHand(std::vector<int> &hand, int groupSize) {
            // Quick check if hand is not divisble by 'groupSize'.
            if (hand.size() % groupSize != 0) {
                return false;
            }

            // Count the frequency of cards in hand.
            std::map<int, int> cardCount;
            for (int card : hand) {
                cardCount[card]++;
            }

            // Form groups, starting with the first card each time.
            for (auto it = cardCount.begin(); it != cardCount.end(); ++it) {
                int card = it->first;
                int count = it->second;
                
                if (count > 0) {
                    // Try to form a group starting with this card
                    for (int i = 0; i < groupSize; ++i) {
                        if (cardCount[card + i] < count) {
                            return false;
                        }
                        cardCount[card + i] -= count;
                    }
                }
            }

            return true;
        }
};

void runTests(std::vector<std::pair<std::vector<int>, int>> inputs, std::vector<bool> expectedOutputs) {
    hand_of_straights obj = hand_of_straights();

    int correct = 1;
    for (size_t i = 0; i < inputs.size(); ++i) {
        bool result = obj.isNStraightHand(inputs[i].first, inputs[i].second);
        if (result != expectedOutputs[i]) {
            std::cout << "Test case " << i + 1 << " failed!" << std::endl;
            std::cout << "Expected: " << (expectedOutputs[i] ? "true" : "false") << std::endl;
            std::cout << "Got: " << (result ? "true" : "false") << std::endl;
            correct = 0;
        } 
    }
    if (correct) {
        std::cout << "All test cases passed." << std::endl;
    }
}

int main() {
    std::vector<std::pair<std::vector<int>, int>> inputs = {
        {{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3},
        {{1, 2, 3, 4, 5}, 4},
        {{1, 2, 3, 4, 5, 6}, 2},
        {{1, 2, 3, 4, 5, 6, 7, 8}, 4},
        {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 3},
        {{1, 1, 2, 2, 3, 3}, 3},
        {{1, 2, 3, 4, 4, 5, 6, 7, 8}, 3},
        {{8, 7, 6, 5, 4, 3, 2, 1}, 4},
        {{8, 7, 6, 5, 4, 3, 2, 1}, 3}
    };
    
    std::vector<bool> expectedOutputs = {
        true,
        false,
        true,
        true,
        true,
        true,
        false,
        true,
        false
    };

    runTests(inputs, expectedOutputs);

    return 0;
}