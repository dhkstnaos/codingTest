```java
class Solution {
    static int count;
    static char[] character = {'A','C','F','J','M','N','R','T'};
    static boolean[] visited = new boolean[8];
    static char[] member = new char[8];
    static String[] rule;
    public int solution(int n, String[] data) {
        count=0;
        rule= data;
        permutation(0);
        return count;
    }
    public void permutation(int cnt) {
        if (cnt == 8) {
            StringBuilder sb = new StringBuilder();
            for (char ch : member) sb.append(ch);
            if(checkOption(sb.toString())) count++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            member[cnt] = character[i];
            permutation(cnt + 1);
            visited[i] = false;
        }
    }
    public boolean checkOption(String str) {
        for(int i=0;i<rule.length;i++) {
            int a=str.indexOf(rule[i].charAt(0));
            int b=str.indexOf(rule[i].charAt(2));
            char sign = rule[i].charAt(3);
            int length = rule[i].charAt(4)-'0';
            if(a==-1 || b==-1) return false;
            if(sign=='=' && Math.abs(a-b) != length+1) {
                return false;
            }
            else if(sign=='>' && Math.abs(a-b) <= length+1) {
                return false;
            }
            else if(sign=='<' && Math.abs(a-b) >= length+1) {
                return false;
            }
        }
        return true;
    }
}
```
