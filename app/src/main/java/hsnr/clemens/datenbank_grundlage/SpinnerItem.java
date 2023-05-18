package hsnr.clemens.datenbank_grundlage;

public class SpinnerItem {
    public int key;
    public String value;

    public  SpinnerItem(int key, String value){
        this.key = key;
        this.value = value;
    }

    public int getKey(){
        return key;
    }

    @Override
    public String toString() {
        return value;
    }
}