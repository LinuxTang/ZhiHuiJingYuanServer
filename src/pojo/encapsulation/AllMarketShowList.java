package pojo.encapsulation;

public class AllMarketShowList {
    private String mkid;
    private String mkTitle;
    private String mkPrice;
    private String mkImg;

    public AllMarketShowList() {
    }

    public String getMkid() {
        return mkid;
    }

    public void setMkid(String mkid) {
        this.mkid = mkid;
    }

    public String getMkTitle() {
        return mkTitle;
    }

    public void setMkTitle(String mkTitle) {
        this.mkTitle = mkTitle;
    }

    public String getMkPrice() {
        return mkPrice;
    }

    public void setMkPrice(String mkPrice) {
        this.mkPrice = mkPrice;
    }

    public String getMkImg() {
        return mkImg;
    }

    public void setMkImg(String mkImg) {
        this.mkImg = mkImg;
    }

    @Override
    public String toString() {
        return "AllMarketShowList{" +
                "mkid='" + mkid + '\'' +
                ", mkTitle='" + mkTitle + '\'' +
                ", mkPrice='" + mkPrice + '\'' +
                ", mkImg='" + mkImg + '\'' +
                '}';
    }
}
