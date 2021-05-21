import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable{

    private String title;
    private String content;
    private Date date;

    public Note(String t,String cont , Date d){
        title = t;
        content = cont;
        date = d;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
