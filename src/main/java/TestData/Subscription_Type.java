package TestData;

public enum Subscription_Type {
    Lite ("LITE") , Classic("CLASSIC") , Premium("PREMIUM");

    private String value;

    Subscription_Type(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}
