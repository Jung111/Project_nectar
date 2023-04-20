package project.nectar.domain;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Objects;

public class BrowserHistoryDto {
    private Integer browserHistory_NUM;
    private String JSESSIONID;
    private String user_email;
    private String searchKeyword;
    private Integer restr_NUM;
    private Integer hotdeal_NUM;
    private Date browserHistory_regdate;



    public BrowserHistoryDto(){this("","",null,null   , null);}

    public BrowserHistoryDto(String JSESSIONID, String user_email){this(JSESSIONID,user_email,null,null,null);}
    public BrowserHistoryDto(String JSESSIONID, String user_email, String searchKeyword){this(JSESSIONID,user_email,searchKeyword,null,null);}
    public BrowserHistoryDto(String JSESSIONID, String user_email, Integer restr_NUM){this(JSESSIONID,user_email,null,restr_NUM,null);}
//    public BrowserHistoryDto(String JSESSIONID, String user_email, Integer hotdeal_NUM){this(JSESSIONID,user_email,null,null,hotdeal_NUM);}

    public BrowserHistoryDto(String JSESSIONID, String user_email, String searchKeyword, Integer restr_NUM, Integer hotdeal_NUM) {
        this.JSESSIONID = JSESSIONID;
        this.user_email = user_email;
        this.searchKeyword = searchKeyword;
        this.restr_NUM = restr_NUM;
        this.hotdeal_NUM=hotdeal_NUM;
    }

    public Integer getBrowserHistory_NUM() {
        return browserHistory_NUM;
    }

    public void setBrowserHistory_NUM(Integer browserHistory_NUM) {
        this.browserHistory_NUM = browserHistory_NUM;
    }

    public String getJSESSIONID() {
        return JSESSIONID;
    }

    public void setJSESSIONID(String JSESSIONID) {
        this.JSESSIONID = JSESSIONID;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public Integer getRestr_NUM() {
        return restr_NUM;
    }

    public void setRestr_NUM(Integer restr_NUM) {
        this.restr_NUM = restr_NUM;
    }

    public Integer getHotdeal_NUM() {
        return hotdeal_NUM;
    }

    public void setHotdeal_NUM(Integer hotdeal_NUM) {
        this.hotdeal_NUM = hotdeal_NUM;
    }

    public Date getBrowserHistory_regdate() {
        return browserHistory_regdate;
    }

    public void setBrowserHistory_regdate(Date browserHistory_regdate) {
        this.browserHistory_regdate = browserHistory_regdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrowserHistoryDto that = (BrowserHistoryDto) o;
        return Objects.equals(browserHistory_NUM, that.browserHistory_NUM) && Objects.equals(JSESSIONID, that.JSESSIONID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(browserHistory_NUM, JSESSIONID);
    }

    @Override
    public String toString() {
        return "BrowserHistoryDto{" +
                "browserHistory_NUM=" + browserHistory_NUM +
                ", JSESSIONID='" + JSESSIONID + '\'' +
                ", user_email='" + user_email + '\'' +
                ", searchKeyword='" + searchKeyword + '\'' +
                ", restr_NUM=" + restr_NUM +
                ", hotdeal_NUM=" + hotdeal_NUM +
                ", browserHistory_regdate=" + browserHistory_regdate +
                '}';
    }
}
