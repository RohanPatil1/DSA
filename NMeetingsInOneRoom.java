import java.util.Arrays;
import java.util.Comparator;

class Meeting {
    int start; int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class MeetingComparator implements Comparator<Meeting> {

    @Override
    public int compare(Meeting o1, Meeting o2) {

        if (o1.end == o2.end)
            return o1.start - o2.start;
        return o1.end - o2.end;
    }
}

public class NMeetingsInOneRoom {

    public static int nMeetings(int[] start, int[] end) {
        int meetingCount = 1;
        int n = start.length;
        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], end[i]);
        }
        Arrays.sort(meetings, new MeetingComparator());

        int dest = meetings[0].end;
        for (int i = 1; i < n; i++) {
            if (meetings[i].start > dest) {
                meetingCount++;
                dest = meetings[i].end;
            }
        }


        return meetingCount;
    }


}
