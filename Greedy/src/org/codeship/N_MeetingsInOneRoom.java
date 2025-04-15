package org.codeship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TC: O(2n) + O(logn)
//SC: O(3n)
public class N_MeetingsInOneRoom {
	
	class Data {
        int start, end, pos;
        public Data(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }
    
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        int n = start.length;
        //copy the start, end & pos into data array from sorting purpose
        Data[] data = new Data[n];
        for(int i = 0; i < n; i++) {
            data[i] = new Data(start[i], end[i], i+1); 
        }
        //sort the array based on end time in ascending order to pick up the shorter duration meeting greedily
        Arrays.sort(data, (a, b) -> a.end - b.end);
        int cnt = 1;
        int freeTime = data[0].end;
        List<Integer> position = new ArrayList<>();
        position.add(data[0].pos);
        
        for(int i = 1; i < n; i++) {
            if(data[i].start > freeTime) { //meeting can be held in a single room
                cnt += 1;
                freeTime = data[i].end;
                position.add(data[i].pos);
            }
        }
        return cnt;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
