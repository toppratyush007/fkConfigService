package Service;

/**
 * Created by pratyush.k on 22/07/17.
 */
public class ServiceFactory {
    private static AddUserService addUserService;
    private static CreateBucketService createBucketService;
    private static BucketValuesService bucketValuesService;

    public static AddUserService getAddUserService(){
        if(addUserService == null)
            addUserService = new AddUserService();
        return addUserService;
    }

    public static CreateBucketService getCreateBucketService(){
        if(createBucketService == null)
            createBucketService = new CreateBucketService();
        return createBucketService;
    }

    public static BucketValuesService getBucketValuesService(){
        if(bucketValuesService == null)
            bucketValuesService = new BucketValuesService();
        return bucketValuesService;
    }
}
