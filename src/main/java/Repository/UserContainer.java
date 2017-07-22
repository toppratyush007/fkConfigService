package Repository;

import Model.Bucket;
import Model.User;
import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by pratyush.k on 22/07/17.
 */
@Data
public class UserContainer {
    public Map<String,User> userMap;

    //public Map<User,Set<Bucket> > writePermissionsOn;
    //public Map<User,Set<Bucket> > readPermissionsOn;

    public UserContainer(){
        userMap = new HashMap<String, User>();
        //writePermissionsOn = new HashMap<User, Set<Bucket>>();
        //readPermissionsOn = new HashMap<User, Set<Bucket>>();
    }

}
