package TestData;

public enum Country_ID {
    Kuwait ("kw") , Saudi("sa") , Bahrain("bh");

    private String value;

    Country_ID(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}
