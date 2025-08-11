#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>

class RandomizedSet {
    public:
        RandomizedSet() {}
        bool insert(int val) {
            if (valMap.find(val) != valMap.end())
                return false;

            // Element doesn't exist, add.
            nums.emplace_back(val);
            valMap[val] = nums.size() - 1;
            return true;
        }
        bool remove(int val) {
            if (valMap.find(val) == valMap.end())
                return false;
            
            // Element exists, remove.
            int last = nums.back();
            valMap[last] = valMap[val];
            nums[valMap[val]] = last;
            nums.pop_back();
            valMap.erase(val);
            return true;
        }
        int getRandom() {
            return nums[rand() % nums.size()];
        }
    private:
        std::vector<int> nums;
        std::unordered_map<int, int> valMap;
};

void runTests(const std::vector<std::string>& commands, const std::vector<std::vector<int>>& inputs, const std::vector<std::string>& expectedOutputs) {
    RandomizedSet* obj = nullptr;
    std::vector<std::string> results;
    bool correct = true;

    for (size_t i = 0; i < commands.size(); ++i) {
        if (commands[i] == "RandomizedSet") {
            obj = new RandomizedSet();
            results.push_back("null");
        } else if (commands[i] == "insert") {
            bool result = obj->insert(inputs[i][0]);
            results.push_back(result ? "true" : "false");
        } else if (commands[i] == "remove") {
            bool result = obj->remove(inputs[i][0]);
            results.push_back(result ? "true" : "false");
        } else if (commands[i] == "getRandom") {
            int result = obj->getRandom();
            results.push_back(std::to_string(result));
        }
    }

    for (size_t i = 0; i < results.size(); ++i) {
        if (results[i] != expectedOutputs[i]) {
            std::cout << "Test case " << i + 1 << " failed!" << std::endl;
            std::cout << "Expected: " << expectedOutputs[i] << std::endl;
            std::cout << "Got: " << results[i] << std::endl;
            correct = false;
        }
    }
    if (correct) {
        std::cout << "All test cases passed." << std::endl;
    }

    if (obj != nullptr) {
        delete obj;
    }
}

int main() {
    std::vector<std::string> commands = {"RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"};
    std::vector<std::vector<int>> inputs = {{}, {1}, {2}, {2}, {}, {1}, {2}, {}};
    std::vector<std::string> expectedOutputs = {"null", "true", "false", "true", "2", "true", "false", "2"};

    runTests(commands, inputs, expectedOutputs);

    return 0;
}