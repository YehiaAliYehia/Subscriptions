package TestData;

public enum Bahrain_Prices {
    Lite ("2") , Classic("3") , Premium("6 ");

    private String value;
    Bahrain_Prices(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}
