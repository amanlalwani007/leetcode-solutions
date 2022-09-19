import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class meeting {
    int start;
    int end;
    int pos;

    meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class meetingComparator implements Comparator<meeting> {

    @Override
    public int compare(meeting a1, meeting a2) {
        if (a1.end < a2.end) {
            return -1;
        } else if (a1.end > a2.end) {
            return 1;
        } else if (a1.pos < a2.pos) {
            return -1;
        }
        return 1;
    }
}

class Meeting {

    static void maxMeetings(int start[], int end[], int n) {
        ArrayList<meeting> meet = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            meet.add(new meeting(start[i], end[i], i + 1));
        }

        meetingComparator mc = new meetingComparator();
        Collections.sort(meet, mc);
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(meet.get(0).pos);
        int limit = meet.get(0).end;
        for (int i = 1; i < start.length; i++) {
            if (meet.get(i).start > limit) {
                limit = meet.get(i).end;
                answer.add(meet.get(i).pos);
            }
        }
        for(int i=0;i< answer.size();i++){
            System.out.println(answer.get(i)+" ");
        }

    }
}
