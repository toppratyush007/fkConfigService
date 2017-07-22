package Service;

import Model.Bucket;
import Model.User;
import Repository.BucketContainer;
import Repository.RepoFactory;

/**
 * Created by pratyush.k on 22/07/17.
 */
public class AddUserService {


    public void addUser(String userName){
        User user = new User(userName);
        RepoFactory.getUserContainer().getUserMap().put(userName, user);
    }

    public void giveWritePermissions(String userName, String bucketName ){
        User user = RepoFactory.getUserContainer().getUserMap().get(userName);
        Bucket bucket = RepoFactory.getBucketContainer().getBucketMap().get(bucketName);

        bucket.getHasWritePermissionsSet().add(user);

    }

    public void giveReadPermissions(String userName, String bucketName){

        User user = RepoFactory.getUserContainer().getUserMap().get(userName);
        Bucket bucket = RepoFactory.getBucketContainer().getBucketMap().get(bucketName);

        bucket.getHasReadPermissionsSet().add(user);

    }
}
