package cn.hellozepp.ssm.po;

/**
 * Created by hadoop on 2017/1/6.
 */
public class Notice {
    private int id;
    private String title;
    private String auther;
    private String community;
    private String content;
    private String time;
    private int click;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", auther='" + auther + '\'' +
                ", community='" + community + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", click=" + click +
                '}';
    }
}
