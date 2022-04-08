```java
class Solution {
    public static boolean check(String str) {
        if (str.charAt(0) == ')') return false;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') count++;
            else {
                count--;
                if (count < 0) return false;
            }
        }
        return true;
    }

    public static String delReverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == '(') sb.append(")");
            else sb.append("(");
        }
        return sb.toString();
    }

    public String solution(String p) {
        if (check(p)) return p;
        return split(p);
    }

    public String split(String str) {
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        if (str.length() == 0) return "";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') count++;
            else count--;
            if (count == 0) {
                u.append(str.substring(0, i + 1));
                v.append(str.substring(i + 1, str.length()));

                if (check(u.toString())) {
                    u.append(split(v.toString()));
                } else {
                    StringBuilder now = new StringBuilder();
                    now.append("(");
                    now.append(split(v.toString()));
                    now.append(")");
                    now.append(delReverse(u.toString()));
                    return now.toString();
                }
                break;
            }
        }
        return u.toString();
    }
}
```
