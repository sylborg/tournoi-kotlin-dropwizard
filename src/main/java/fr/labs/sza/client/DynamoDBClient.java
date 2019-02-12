//package fr.labs.sza.client;
//
//import com.amazonaws.regions.Regions;
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class DynamoDBClient {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(DynamoDBClient.class);
//    private AmazonDynamoDBClient client;
//    private DynamoDBMapper dynamoDBMapper;
//    private Boolean local;
//    private String endpoint;
//    private String region;
//    private String tablePrefix;
//
//    public DynamoDBClient(Boolean local, String endpoint, String region, String tablePrefix) {
//        this.local = local;
//        this.endpoint = endpoint;
//        this.region = region;
//        this.tablePrefix = tablePrefix;
//    }
//
//    public void start() {
//        if (local) {
//            this.client = new AmazonDynamoDBClient().withEndpoint(endpoint);
//        } else {
//            this.client = new AmazonDynamoDBClient().withRegion(Regions.fromName(region));
//        }
//        this.dynamoDBMapper = new DynamoDBMapper(client);
//    }
//
//}
