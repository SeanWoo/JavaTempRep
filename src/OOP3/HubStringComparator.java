package OOP3;

import java.util.Comparator;

public class HubStringComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        for (int i = 0; i < o1.length(); i++)
        {
            var o1char = (int)o1.charAt(i);
            var o2char= (int)o2.charAt(i);
            if (o1char < o2char)
            {
                return -1;
            }
            else if (o1char > o2char)
            {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }
}