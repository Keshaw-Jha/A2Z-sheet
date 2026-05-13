import java.util.*;
class Main {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList(
                                "hot","dot","dog","lot","log","cog"
                                );
                                
        int ans = new Solution().ladderLength(beginWord, endWord, wordList);
        System.out.print(ans);
    }
    
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord))
            return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                String currentWord = q.poll();
                if (currentWord.equals(endWord)) {
                    return level;
                }

                char[] arr = currentWord.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];
                    for( char ch = 'a';ch<='z';ch++){
                        arr[i]=ch;
                        String nextWord = new String(arr);
                        if(dict.contains(nextWord)){
                            q.add(nextWord);
                            dict.remove(nextWord);
                        }
                    }
                    arr[i] = original;
                }
            }
            level++;
        }

        return 0;
    }
}