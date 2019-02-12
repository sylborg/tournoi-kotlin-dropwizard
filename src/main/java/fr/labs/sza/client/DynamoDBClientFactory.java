//package fr.labs.sza.client;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import io.dropwizard.lifecycle.Managed;
//import io.dropwizard.setup.Environment;
//
//public class DynamoDBClientFactory {
//
//    private Boolean local = true;
//    private String endpoint = "http://localhost:8000";
//    private String region = "eu-west-1";
//    private String tablePrefix = "";
//
//    @JsonProperty
//    public Boolean getLocal() {
//        return local;
//    }
//
//    @JsonProperty
//    public void setLocal(Boolean local) {
//        this.local = local;
//    }
//
//    @JsonProperty
//    public String getEndpoint() {
//        return endpoint;
//    }
//
//    @JsonProperty
//    public void setEndpoint(String endpoint) {
//        this.endpoint = endpoint;
//    }
//
//    @JsonProperty
//    public String getRegion() {
//        return region;
//    }
//
//    @JsonProperty
//    public void setRegion(String region) {
//        this.region = region;
//    }
//
//    @JsonProperty
//    public String getTablePrefix() {
//        return tablePrefix;
//    }
//
//    @JsonProperty
//    public void setTablePrefix(String tablePrefix) {
//        this.tablePrefix = tablePrefix;
//    }
//
//    public DynamoDBClient build(Environment environment){
//        final DynamoDBClient dynamoDBClient = new DynamoDBClient(local, endpoint, region, tablePrefix);
//        environment.lifecycle().manage(new Managed() {
//
//            public void start() {
//                dynamoDBClient.start();
//            }
//
//            public void stop() {
//
//            }
//        });
//        return dynamoDBClient;
//    }
//
//}
