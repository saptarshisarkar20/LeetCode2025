class Solution {
 public int countStudents(int[] st, int[] sd) {
        int no_1 = 0, no_0 = 0;
        Queue<Integer> q = new ArrayDeque<>();

        for (Integer it : st) {
            q.add(it);
            if (it == 0)
                no_0++;
            else
                no_1++;
        }

        int ind = 0;

        while (!q.isEmpty() && no_1 != 0 && no_0 != 0) {
            int temp = q.peek();
            q.remove();
            // System.out.print("curr-> " + temp + " | sandwich->" + sd[ind]);
            if (sd[ind] == temp) {
                if (temp == 0)
                    no_0--;
                else
                    no_1--;
                ind++;
                // System.out.println("  + kha liya!");
            } else {
                q.add(temp);
                // System.out.println("  X Nahi khaya!");
            }
        }
        // for (int i = ind; i < sd.length; i++) {
        //     // System.out.print(" | " + sd[i]);
        // }
        // System.out.println();

        // System.out.println("0-> " + no_0 + " | 1-> " + no_1);

        if (no_1 == 0) {
            int sd_0 = 0;
            for (int i = ind; i < sd.length; i++) {
                if (sd[i] == 0)
                    sd_0++;
                else
                    break;
            }
            // System.out.println("no-0-> " + no_0 + " | sd-0-> " + sd_0);
            if ((no_0 - sd_0) > 0)
                return no_0 - sd_0;
        }

        if (no_0 == 0) {
            int sd_1 = 0;
            for (int i = ind; i < sd.length; i++) {
                if (sd[i] == 1)
                    sd_1++;
                else
                    break;
            }
            // System.out.println("no-1-> " + no_1 + " | sd-1-> " + sd_1);
            if ((no_1 - sd_1) > 0) {
                // System.out.println("HERE %%%");
                return (no_1 - sd_1);
            }
        }
        return 0;
    }
}