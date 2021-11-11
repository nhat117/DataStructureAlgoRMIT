package SampleTest;

public class PPQSolution {

    static class Person {
        String ID;
        int age;

        public Person(String ID, int age) {
            this.ID = ID;
            this.age = age;
        }
    }

    static class PeopleQ{
        Person[] arr;
        int size; //Number of people in queue
        int MAX_SIZE = 100;

        public PeopleQ() {
            arr = new Person[MAX_SIZE];
            size = 0;
        }

        public void joinQueue(Person p ) {
            // if this person age >= 65
            // and the preceding person age < 65, move the preceding people to next next slot
            // until there is another person >= 65 or the first position reached
            if(p.age < 65) {
                arr[size] = p;
                size ++;
                return ;
            }

            int pos = size;
            while(pos > 0) {
                if(arr[pos -1].age < 65) {
                    arr[pos] = arr[pos - 1];
                    pos --;
                } else {
                        break;
                }
            }
            arr[pos] = p;
            size ++;
        }

        public Person getVaccine() {
            if(size == 0) return null;
            //Return the first person and step other forward
            Person p  = arr[0]; //save the first person
            for(int i = 0; i < size - 1 ; i++) {
                arr[i] = arr[i + 1];
            }
            size --;
            return p;
        }

        //Give up
        public void giveUp(String ID) {
            if(size == 0) return;
            //Find the position of ID
            int pos = 0;
            while(pos < size) {
                if(arr[pos].ID.equals(ID)) {
                    break;
                }
                pos ++;
            }
            //Not found
            if(pos == size) { return;}
            //Shift forward
            for(int i = pos; i < size ; i ++) {
                arr[i] = arr[i+1];
            }
            size --;
        }
    }

    public static void main(String[] args) {
        PeopleQ queue = new PeopleQ();
        // enqueue one person whose age = 20 and another whose age = 70
        // the person whose age = 70 should get vaccine first
        queue.joinQueue(new PPQSolution.Person("001",20));
        queue.joinQueue(new PPQSolution.Person("002", 70));
        Person p = queue.getVaccine();
        System.out.printf("%s %d\n", p.ID, p.age);

        // enqueue another person whose age = 50
        // the person whose age = 20 should get vaccine now
        queue.joinQueue(new Person("003", 50));
        p = queue.getVaccine();
        System.out.printf("%s %d\n", p.ID, p.age);

        // enqueue one person whose age = 80 and another whose age = 72
        queue.joinQueue(new Person("004", 80));
        queue.joinQueue(new Person("005", 72));

        // the person whose age = 80 should get vaccine now
        p = queue.getVaccine();
        System.out.printf("%s %d\n", p.ID, p.age);

        // the person whose age = 72 giveUp
        // so, the person whose age = 50 should get vaccine now
        queue.giveUp("005");
        p = queue.getVaccine();
        System.out.printf("%s %d\n", p.ID, p.age);
    }
}
