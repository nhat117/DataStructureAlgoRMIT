package SampleTest;

public class PeopleQueue {
    //Queue variable
    int front, rear,size, capacity;
    People arr[];
    static class People {
        private String ID;
        private int age;
        //Constructor
        public People(String ID, int age) {
            this.ID = ID;
            this.age = age;
        }
    }
    //Queue implementation
    public PeopleQueue(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity -1;
        arr = new People[this.capacity];
    }
    boolean chckFull() {
        if(this.size == capacity) return true;
        return false;
    }
    private int chckID(String ID) {


        int i=this.front;
        int c=this.size;
        while (c>0){
            System.out.println(this.arr[i].ID+" "+ID);
            if (this.arr[i].ID.equals(ID)) return i;
            i=(i+1)%this.capacity;
            c-=1;
        }
        return  -1;
    }
    public void joinQueue(People people) {
        if(chckFull()) return;
        //TODO: Make id not duplicate

        if (this.size > 1) {
            if(this.chckID(people.ID) != -1){
//                System.out.println("Duplicate");
                return;
            }
        }

//        System.out.println(this.chckID(people.ID));
        this.arr[(this.front+this.size)%this.capacity] = people;
//        if(this.chckID(people.ID) != -1) System.out.println("Duplicate");
        this.size ++;
    }
    public int checkAge() {
        for(int i = 0; i < arr.length; i ++) {
            if(arr[i].age >= 65) return i;
        }
        return -1;
    }
    public People getVaccine() {
        if (this.size == 0) return null;
//        System.out.println("dkjashdkjsadsa");
        //check for over 65
        int index = checkAge();
//        System.out.println(index+'d');
        if(index!= -1) {
//            System.out.println('c');
            People tmp = arr[index];
            for(int i = index; i < size - 1; i ++) {
                arr[i] = arr[i +1];
            }
            this.size -=1;
            return  tmp;
        }
        //Normal queue

        int tmp = this.front;
        this.front = (this.front + 1) % this.capacity;
        this.size -=1;

        return  arr[tmp];
    }
    public void giveUp(String ID) {
        if (this.size == 0) return;
        int tmp = chckID(ID);
        if(tmp == -1) return;
        size -=1;
        for(int i = tmp; i < arr.length - 1; i ++) {
            arr[i] = arr[i +1];
        }
    }
    public void queryQueue() {
        int i=this.front;
        int c=this.size;
        while (c>0){
            System.out.println("ID: " + arr[i].ID +" Age" + arr[i].age);
            i=(i+1)%this.capacity;
            c-=1;
        }


    }
    //Driver code
    public static void main(String[] args) {
        PeopleQueue queue = new PeopleQueue(4);
        queue.joinQueue(new People("s1",15));
        queue.joinQueue(new People("s2",19));
        queue.joinQueue(new People("s3",70));
        queue.joinQueue(new People("s4",63));
        System.out.println("Test input");
        queue.queryQueue();
        System.out.println("Test Vaccine Over 65");
        queue.getVaccine();
        queue.queryQueue();
        System.out.println("Test Vaccine");
        queue.getVaccine();
        queue.queryQueue();
        System.out.println("Test join");
        queue.joinQueue(new People("s5",19));
        queue.queryQueue();
        System.out.println("Test GiveUp");
        queue.giveUp("s5");
        queue.queryQueue();
        queue.getVaccine();
        System.out.println("Test last");
        queue.queryQueue();
        queue.getVaccine();
        queue.queryQueue();
    }
}