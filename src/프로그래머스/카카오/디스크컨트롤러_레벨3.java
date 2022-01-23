package 프로그래머스.카카오;

import java.util.*;

class Solution {
    HashMap<Long, Long> map = new HashMap<>();
    public long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            answer[i] = findEmptyRoom(room_number[i]);
        }
        return answer;
    }
    private long find(long room) {
        if (!map.containsKey(room)) {
            map.put(room, room + 1);
            return room;
        }
        long nextRoom = map.get(room);
        long emptyRoom = find(nextRoom);
        map.put(room, emptyRoom);
        return emptyRoom;
    }
}