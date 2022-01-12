package SampleTest2; import java.util.ArrayList;
public class RMITLetterUltilty {
    ArrayList<RMITLetter> ls;
    public ArrayList<RMITLetter> scan(char[][] letters) {
        ArrayList<RMITLetter> res = new ArrayList<>();
        for(int r = 0; r < letters.length; r++) {
            for (int c = 0; c < letters[0].length; c++) {
                char tmp = letters[r][c];
                if(tmp == 'R' | tmp == 'M'| tmp == 'I' | tmp == 'T') {
                    res.add(new RMITLetter(tmp,r,c));
                }
            }
        }
        ls = res;
        return res;
    }

    public boolean canConnect(RMITLetter l1, RMITLetter l2) {
        if(l1.row > l2.row) return false;
        if(l1.col > l2.col) return false;
        if((l2.row - l1.row) + (l2.col - l1.col) > 4) return false;
        //Have to check the first letter if are RMI
        if(l1.letter != 'R' && l1.letter != 'M' && l1.letter != 'I') return false;
        if(l1.letter == 'R' && l2.letter != 'M') return false;
        if(l1.letter == 'M' && l2.letter != 'I') return false;
        if(l1.letter == 'I' && l2.letter != 'T') return false;
        return true;

    }

    public boolean canFindRMIT() {
        for(int i = 0; i < ls.size(); i ++) {
            if(ls.get(i).letter != 'R') continue;
            RMITLetter first = ls.get(i);
            for(int i2 = 0; i2 < ls.size(); i2 ++) {
                if(ls.get(i2).letter != 'M') continue;
                RMITLetter second = ls.get(i2);
                if(!canConnect(first,second)) continue;
                for(int i3 = 0; i3 < ls.size(); i3 ++) {
                    if(ls.get(i3).letter != 'I') continue;
                    RMITLetter thrd = ls.get(i3);
                    if(!canConnect(second,thrd)) continue;
                    for(int i4 = 0; i4 < ls.size(); i4 ++) {
                        if(ls.get(i4).letter != 'T') continue;
                        RMITLetter fourth = ls.get(i4);
                        if(!canConnect(thrd,fourth)) return true;
                    }
                }
            }
        }
        return false;
    }

    class RMITLetter {
        char letter;
        int row, col;

        public RMITLetter(char letter, int row, int col) {
            this.letter = letter;
            this.row = row;
            this.col = col; }
    }
}
