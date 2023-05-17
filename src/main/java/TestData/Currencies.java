package TestData;

public enum Currencies {
    Kuwait ("KWD") , Saudi("SAR") , Bahrain("BHD");

    private String value;

    Currencies(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}
