package Service;

import Model.Bucket;
import Repository.BucketContainer;
import Repository.RepoFactory;

/**
 * Created by pratyush.k on 22/07/17.
 */
public class CreateBucketService {

    BucketContainer bucketContainer ;


    public Bucket createBucket(String bucketName, String inhertingFromBucket){

            Bucket parentBucket = RepoFactory.getBucketContainer().getBucketMap().get(inhertingFromBucket);
            Bucket bucket = new Bucket(bucketName, parentBucket);

            RepoFactory.getBucketContainer().getBucketMap().put(bucketName,bucket);

            return  bucket;
    }
}
