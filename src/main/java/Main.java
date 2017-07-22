import Model.Bucket;
import Model.User;
import Repository.RepoFactory;
import Service.ServiceFactory;

import java.util.Scanner;

/**
 * Created by pratyush.k on 22/07/17.
 */
public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.println("press -1 to exit or 1 to continue");
            int i = scanner.nextInt();

            if(i==-1)
                break;
            else{
                System.out.println("1. create bucket");
                System.out.println("2. add value to bucket");
                System.out.println("3. get value from bucket");
                System.out.println("4. Create user");
                System.out.println("5. Grant read permission to user");
                System.out.println("6. Grant write permission to user");
                System.out.println("7. Get Entire Bucket Values");
                System.out.println("8. Get bucket key as a user");
                System.out.println("9. Write bucket key as user");

                int input = scanner.nextInt();
                scanner.nextLine();
                switch (input){
                    case 1:
                        String bucketName = scanner.nextLine();
                        System.out.println(bucketName);
                        String inhertingFrom = scanner.nextLine();
                        System.out.println(inhertingFrom);

                        if(inhertingFrom.equals(""))
                            inhertingFrom = null;
                        ServiceFactory.getCreateBucketService().createBucket(bucketName,inhertingFrom);
                        break;
                    case 2:
                         bucketName = scanner.nextLine();
                        String key = scanner.nextLine();
                        String value = scanner.nextLine();
                        Bucket bucket = RepoFactory.getBucketContainer().getBucketMap().get(bucketName);
                        ServiceFactory.getBucketValuesService().addValueToBucket(bucket,key,value);
                        break;
                    case 3:
                        bucketName = scanner.nextLine();
                        key = scanner.nextLine();
                        bucket = RepoFactory.getBucketContainer().getBucketMap().get(bucketName);
                        System.out.println(ServiceFactory.getBucketValuesService().getBucketKey(bucket,key));
                        break;
                    case 4:
                        String userName = scanner.nextLine();
                        ServiceFactory.getAddUserService().addUser(userName);
                        break;
                    case 5:
                        userName = scanner.nextLine();
                        bucketName = scanner.nextLine();
                        User user = RepoFactory.getUserContainer().getUserMap().get(userName);
                        bucket = RepoFactory.getBucketContainer().getBucketMap().get(bucketName);
                        bucket.getHasReadPermissionsSet().add(user);
                        break;
                    case 6:
                        userName = scanner.nextLine();
                        bucketName = scanner.nextLine();
                        user = RepoFactory.getUserContainer().getUserMap().get(userName);
                        bucket = RepoFactory.getBucketContainer().getBucketMap().get(bucketName);
                        bucket.getHasWritePermissionsSet().add(user);
                        break;
                    case 7:
                        bucketName = scanner.nextLine();
                        bucket = RepoFactory.getBucketContainer().getBucketMap().get(bucketName);
                        System.out.println(ServiceFactory.getBucketValuesService().getWholeBucketValues(bucket));
                        break;
                    case 8:
                        userName = scanner.nextLine();
                        bucketName = scanner.nextLine();
                        key = scanner.nextLine();
                        user = RepoFactory.getUserContainer().getUserMap().get(userName);
                        bucket = RepoFactory.getBucketContainer().getBucketMap().get(bucketName);
                        System.out.println(ServiceFactory.getBucketValuesService().getBucketKeyForUser(bucket,key,user));
                        break;
                    case 9:
                        userName = scanner.nextLine();
                        bucketName = scanner.nextLine();
                        key = scanner.nextLine();
                        value = scanner.nextLine();
                        user = RepoFactory.getUserContainer().getUserMap().get(userName);
                        bucket = RepoFactory.getBucketContainer().getBucketMap().get(bucketName);
                        ServiceFactory.getBucketValuesService().addValueToBucket(bucket,key,value);
                        break;

                }


            }


        }
    }
}
