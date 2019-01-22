package pojo.encapsulation;

import java.util.Date;

/**
 * 根据页面的显示信息，来封装，没必要将所有的数据都查出来，保存在前端
 */
public class AllItemsShowList {

    private String pid; //捡到人或丢到人的id
    private String gid; //捡到物品或丢失物品的id
    private String name; //人名
    private String photo_url; // 头像
    private String content; //内容
    private String img_url; // 图片
    private String place; //地点
    private String date; //时间
    private Integer status;//状态

    public AllItemsShowList() {
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AllItemsShowList{" +
                "pid='" + pid + '\'' +
                ", gid='" + gid + '\'' +
                ", name='" + name + '\'' +
                ", photo_url='" + photo_url + '\'' +
                ", content='" + content + '\'' +
                ", img_url='" + img_url + '\'' +
                ", place='" + place + '\'' +
                ", date='" + date + '\'' +
                ", status=" + status +
                '}';
    }
}
