```java
public class Solution {
    public int solution(String s) {
      int min = s.length();
      for (int i = 1; i <= s.length() / 2; i++) {
        int compLeng = compression(s, i).length();
        min = Math.min(min, compLeng);
      }
      return min;
    }
    private String compression(String s, int i) {
      int count = 1;
      String unit = "";
      String pattern = "";
      for (int j = 0; j <= s.length() + i; j += i) {
        String now;
          
        if (j >= s.length()) now = "";
        else if (s.length() < j + i) now = s.substring(j);
        else now = s.substring(j, j + i);
          
        if (j != 0) {
          if (now.equals(pattern)) count++;
          else if (count >= 2) {
            unit += count + pattern;
            count = 1;
          } 
          else unit += pattern;
        }
        pattern = now;
      }
      return unit;
    }
}
```
