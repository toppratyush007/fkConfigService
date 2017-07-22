package Service;

import Model.Bucket;
import Model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pratyush.k on 22/07/17.
 */
public class BucketValuesService {

    public Map<String,String> getWholeBucketValues(Bucket bucket){
        Map<String,String> wholeBucketValues = new HashMap<String, String>();

        while(bucket != null){

            for(Map.Entry<String,String> bucketValuesEntry : bucket.getBucketValues().entrySet()){
                String key = bucketValuesEntry.getKey();
                String value = bucketValuesEntry.getValue();

                if(wholeBucketValues.containsKey(key)){
                    continue;
                }
                else{
                    wholeBucketValues.put(key,value);
                }
            }

            bucket = bucket.getPrevBucket();
        }

        return wholeBucketValues;

    }

    public String getBucketKey(Bucket bucket, String key){

        while(bucket != null){

            for(Map.Entry<String,String> bucketValuesEntry : bucket.getBucketValues().entrySet()){
                String bucketEntryKey = bucketValuesEntry.getKey();
                String bucketEntryValue = bucketValuesEntry.getValue();

                if (bucketEntryKey.equals(key))
                    return bucketEntryValue;
            }

            bucket = bucket.getPrevBucket();
        }

        return "not found";
    }

    public Map<String,String> getWholeBucketValuesForUser(Bucket bucket, User user){
        Bucket tempBucket = bucket;
        while(tempBucket != null){

            if(tempBucket.getHasReadPermissionsSet().contains(user))
            {
                return getWholeBucketValues(bucket);
            }

            tempBucket = tempBucket.getPrevBucket();
        }
        return new HashMap<String, String>();
    }

    public String getBucketKeyForUser(Bucket bucket,String key,User user){
        Bucket tempBucket = bucket;
        while(tempBucket != null){

            if(tempBucket.getHasReadPermissionsSet().contains(user))
            {
                return getBucketKey(bucket, key);
            }

            tempBucket = tempBucket.getPrevBucket();
        }

        return "not allowed";
    }

    public void addValueToBucket(Bucket bucket, String key, String value){
        bucket.addValueToBucket(key,value);
    }

    public void addValueToBucketAsAUser(Bucket bucket,String key,String value,User user){

        Bucket tempBucket = bucket;
        while(tempBucket != null){

            if(tempBucket.getHasWritePermissionsSet().contains(user))
            {
                addValueToBucket(bucket,key,value);
            }

            tempBucket = tempBucket.getPrevBucket();
        }

    }
}
