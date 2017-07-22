package Model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by pratyush.k on 22/07/17.
 */
public class User {
    String name;
    Set<Bucket> hasReadPermissions;
    Set<Bucket> hasWritePermissions;

    public User(String name){
        this.name = name;
        this.hasReadPermissions = new HashSet<Bucket>();
        this.hasWritePermissions = new HashSet<Bucket>();
    }
}
