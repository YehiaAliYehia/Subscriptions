package TestData;

public enum Saudi_Prices {
    Lite ("15") , Classic("25") , Premium("60 ");

    private String value;
    Saudi_Prices(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}
