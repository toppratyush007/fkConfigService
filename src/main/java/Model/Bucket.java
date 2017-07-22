package Model;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by pratyush.k on 22/07/17.
 */
@Data
public class Bucket {

    String name;
    boolean isDirty;
    Bucket rootBucket;
    Bucket prevBucket;
    Set<User> hasWritePermissionsSet ;
    Set<User> hasReadPermissionsSet ;

    HashMap<String,String> bucketValues;

    public Bucket(){
        bucketValues = new HashMap<String, String>();
    }

    public Bucket(String bucketName, Bucket parentBucket) {
        this.name = bucketName;
        this.prevBucket = parentBucket;

        if(this.prevBucket == null)
            rootBucket = this;
        else{
            rootBucket = this.prevBucket;
        }
        bucketValues = new HashMap<String, String>();
        hasReadPermissionsSet = new HashSet<User>();
        hasWritePermissionsSet = new HashSet<User>();

    }

    public void addValueToBucket(String key,String value){
        bucketValues.put(key,value);
    }
}
