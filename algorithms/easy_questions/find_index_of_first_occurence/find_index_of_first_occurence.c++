#include <string>
#include <vector>

class find_index_of_first_occurence {
    public:
        static int strStr(std::string haystack, std::string needle) {
            // Store the lengths of 'needle' and 'haystack'.
            int h_len = haystack.size();
            int n_len  = needle.size();

            // Compute the lps array.
            std::vector<int> lps = computeLPSArray(needle);

            // Note that i is the current index in 'haystack' and j
            // is the index of 'needle'
            for (int i = 0, j = 0; i < h_len;) {
                // Iterate i and j if we the same character.
                if (haystack[i] == needle[j]) { 
                    i++, j++;
                }
                // This indicates we have a match, return index of first char.
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
            // Store length of 'needle'
            int n_len = needle.size();
            // lps array for the failure function.
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

int main() {
    // Example 1
    std::string haystack1 = "happyandglad", needle1 = "happy";
    printf("Example 1: %d\n", find_index_of_first_occurence::strStr(haystack1, needle1));

    // Example 1
    std::string haystack1 = "happyandglad", needle1 = "happy";
    printf("Example 1: %d\n", find_index_of_first_occurence::strStr(haystack1, needle1));

    // Example 1
    std::string haystack1 = "happyandglad", needle1 = "happy";
    printf("Example 1: %d\n", find_index_of_first_occurence::strStr(haystack1, needle1));

    // Example 1
    std::string haystack1 = "happyandglad", needle1 = "happy";
    printf("Example 1: %d\n", find_index_of_first_occurence::strStr(haystack1, needle1));

    // Example 1
    std::string haystack1 = "happyandglad", needle1 = "happy";
    printf("Example 1: %d\n", find_index_of_first_occurence::strStr(haystack1, needle1));

    // Example 1
    std::string haystack1 = "happyandglad", needle1 = "happy";
    printf("Example 1: %d\n", find_index_of_first_occurence::strStr(haystack1, needle1));

    // Example 1
    std::string haystack1 = "happyandglad", needle1 = "happy";
    printf("Example 1: %d\n", find_index_of_first_occurence::strStr(haystack1, needle1));

}