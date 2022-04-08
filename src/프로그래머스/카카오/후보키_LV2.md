```java
import java.util.*;

class Solution {
    List<String> candidates = new ArrayList<>();
    boolean[] visited;
    public int solution(String[][] relation) {
        int length = relation[0].length;
        for (int i = 0; i < relation[0].length; i++) {
            visited = new boolean[length];
            //1개부터 length까지 모든 조합을 찾는다.
            dfs(0, i + 1, relation);
        }
        return candidates.size();
    }

    public void dfs(int depth, int end, String[][] relation) {
        if (depth == end) {
            //방문 표시 리스트
            List<Integer> list = new ArrayList<>();
            String key = "";
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    key += String.valueOf(i);
                    list.add(i);
                }
            }
            Map<String, Integer> map = new HashMap<>();
            //유일성 체크
            for (int i = 0; i < relation.length; i++) {
                String s = "";
                for (Integer j : list) {
                    s += relation[i][j];
                }
                if (map.containsKey(s)) return;
                else map.put(s, -1);
            }
            for (String candidate : candidates) { 
                int count = 0;
                //기존 후보키들과 비교
                for(int i = 0; i < key.length(); i++){
                    String sub = String.valueOf(key.charAt(i));
                    if(candidate.contains(sub)) count++;
                }
                if (count == candidate.length()) return;
            }
            candidates.add(key);
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            //방문체크
            if (visited[i]) continue;
            visited[i] = true;
            dfs(depth + 1, end, relation);
            visited[i] = false;
        }

    }
}
```
