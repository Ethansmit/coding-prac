import collections

class replace_words(object):
    def replaceWords(self, dictionary, sentence):
        # Create trie object.
        _trie = lambda: collections.defaultdict(_trie)
        trie = _trie()
        END = True # Unique marker for end of root.
        # Build Trie from roots.
        for root in dictionary:
            cur = trie
            for letter in root:
                cur = cur[letter]
            cur[END] = root
            
        # Replace words in sentence using trie.
        def replace(word):
            cur = trie
            for letter in word:
                if letter not in cur: break
                cur = cur[letter]
                if END in cur:
                    return cur[END]
            return word
        
        # Split sentence into words, replace words, join sentence back together.
        return " ".join(map(replace, sentence.split()))
    
def test_common_chars(test_cases):
    obj = replace_words
    
    for i, (input_dict, input_str, expected_output) in enumerate(test_cases):
        output = obj.replaceWords(obj, input_dict, input_str)
        assert sorted(output) == sorted(expected_output), f"Test case {i+1} failed: {output} != {expected_output}"
    
    print("All test cases passed.")

def main():
    test_cases = [
        (["cat", "bat", "rat"], 
         str("the cattle was rattled by the battery"), 
         str("the cat was rat by the bat")),
        (["a", "b", "c"], str("aadsfasf absbs bbab cadsfafs"), 
         str("a a b c")),
        (["cat", "bat", "rat"], str("the dog was barking at the moon"), 
         str("the dog was barking at the moon")),
        (["the", "cat", "was", "by", "bat"], str("the cat was by the bat"), 
         str("the cat was by the bat")),
        (["cat", "bat", "rat"], str("concatenate tebatries ioratnally"), 
         str("concatenate tebatries ioratnally")),
        (["supercalifragilisticexpialidocious"], 
         str("a supercalifragilisticexpialidocious day"), 
         str("a supercalifragilisticexpialidocious day")),
        (["int", "inter", "international"], str("internationally intertwined"), 
         str("int int")) 
    ]
    
    test_common_chars(test_cases)

if __name__=="__main__":
    main()