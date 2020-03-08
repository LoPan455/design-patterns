package info.tjohander.singleton;

import java.time.Instant;

public class Main {

    public static void main(String[] args) {
        ServiceConnection connection1 = ServiceConnection.getInstance();
        System.out.println(connection1.getConnectionDetails());
        ServiceConnection connection2 = ServiceConnection.getInstance();
        System.out.println(connection2.toString());
        if (connection1 == connection2) {
            System.out.println("They are the same object.");
        }
    }
}

class ServiceConnection {

    // A static method to to generate _the only_ instance that will ever be created
    private static ServiceConnection instance = new ServiceConnection();

    // 1. The singleton needs a private, no args constructor.  Args means we need to use
    // a factory creational pattern.
    private ServiceConnection() {}

    // naming this public getter method 'getInstance' is not a requirement but it's customary.
    // This is not clear why it will only return a single instance.  Doesn't it call a private method that
    // generates a new instance?
    public static ServiceConnection getInstance() {
        return instance;
    }

    public String getConnectionDetails() {
        return this.toString();

    }
}
