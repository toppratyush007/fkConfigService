package Repository;

import Repository.BucketContainer;
import Repository.UserContainer;

/**
 * Created by pratyush.k on 22/07/17.
 */
public class RepoFactory {
    private static BucketContainer bucketContainer;
    private static UserContainer userContainer;

    public static BucketContainer getBucketContainer(){
        if(bucketContainer == null)
            bucketContainer = new BucketContainer();
        return bucketContainer;
    }

    public static UserContainer getUserContainer(){
        if(userContainer == null)
            userContainer = new UserContainer();
        return userContainer;
    }
}
