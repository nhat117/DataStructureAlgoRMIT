package W4;

public class QueueApplication {
    static class Event {
        int arrival;
        int duration;
        public Event(int arrival, int duration) {
            this.arrival = arrival;
            this.duration = duration;
        }
    }

    public static void main(String[] args) {
        ArrayQueue <Event> events = new ArrayQueue<>();

        //Add person to a queue
        events.enQueue(new Event(0, 5));
        events.enQueue(new Event(3, 3));
        events.enQueue(new Event(4, 4));
        events.enQueue(new Event(100, 4));

        int n = events.getSize();
        int nextAval = 0;
        int total = 0;
        //Check the total waiting and avg waiting time
        while (!events.isEmpty()) {
            Event tmp = events.peekFront();
            events.deQueue();
            nextAval = Math.max(nextAval, tmp.arrival);
            total += (nextAval - tmp.arrival);
            nextAval = nextAval + tmp.duration;
        }

        System.out.printf("Total waiting time %d and average waiting time %.2f\n", total, 1.0 * total / n);
    }


}
