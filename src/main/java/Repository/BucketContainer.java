package Repository;

import Model.Bucket;
import lombok.Data;

import java.util.HashMap;

/**
 * Created by pratyush.k on 22/07/17.
 */
@Data
public class BucketContainer {

    HashMap<String, Bucket> bucketMap;


    public BucketContainer(){
        bucketMap = new HashMap<String, Bucket>();
    }
    public void addBucket(String bucketName, Bucket bucket){
        bucketMap.put(bucketName,bucket);
    }

}
