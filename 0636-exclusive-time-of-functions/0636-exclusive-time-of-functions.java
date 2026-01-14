class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
int[] result = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        int prevTime = 0; // last moment we accounted time from

        for (String log : logs) {
            String[] parts = log.split(":");  // ["id", "start/end", "time"]
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int time = Integer.parseInt(parts[2]);

            if (type.equals("start")) {
                // Before starting a new function, the current top one
                // has been running from prevTime up to (time - 1).
                if (!stack.isEmpty()) {
                    result[stack.peek()] += time - prevTime;
                }
                // Now this function becomes the current running one.
                stack.push(id);
                prevTime = time; // next time we count from this start time
            } else { // "end"
                // Current function (on top) finishes at the *end* of this time.
                // It has been running from prevTime to time (inclusive).
                int finishedId = stack.pop();
                result[finishedId] += time - prevTime + 1;

                // Next time unit (time + 1) is where the caller (if any) resumes.
                prevTime = time + 1;
            }
        }

        return result;
    }
}