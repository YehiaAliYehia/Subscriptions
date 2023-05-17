package TestData;

public enum Kuwait_Prices {
    Lite ("1.2") , Classic("2.5") , Premium("4.8 ");

    private String value;
    Kuwait_Prices(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}
