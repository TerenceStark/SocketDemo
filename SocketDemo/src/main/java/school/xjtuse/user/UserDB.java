package school.xjtuse.user;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    private static List<User> users=new ArrayList<User>();

    static{
        users.add(new User("terence","xjtuse"));
        users.add(new User("hjg","xjtuse"));
        users.add(new User("root","xjtuse"));
    }

    public static List<User> getUsers() {
        return users;
    }
}

