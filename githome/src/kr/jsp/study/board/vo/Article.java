package kr.jsp.study.board.vo;

import java.util.Date;

public class Article {

    private int id;
    private int groupid;
    private String sequenceNumber;
    private Date postingDate;
    private int readCount;
    private String writerName;
    private String password;
    private String title;
    private String content;
    
    public static enum TABLE {
        id ("article_id"),
        groupid ("group_id"),
        sequenceNumber ("sequence_no"),
        postingDate ("posting_date"),
        readCount ("read_count"),
        writerName ("writer_name"),
        password ("password"),
        title ("title"),
        content ("content");
        
        private final String name;       

        private TABLE(String s) {
            name = s;
        }
        
        public String toString(){
            return name;
         }
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getGroupid() {
        return groupid;
    }
    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }
    public String getSequenceNumber() {
        return sequenceNumber;
    }
    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
    public Date getPostingDate() {
        return postingDate;
    }
    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }
    public int getReadCount() {
        return readCount;
    }
    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }
    public String getWriterName() {
        return writerName;
    }
    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
    
    // 게시글의 중첩 레벨을 구한다.
    public int getLevel() {
        if (sequenceNumber == null) {
            return -1;
        }
        if (sequenceNumber.length() != 16) {
            return -1;
        }
        if (sequenceNumber.endsWith("999999")) {    // Level 0
            return 0;
        }
        if (sequenceNumber.endsWith("9999")) {      // Level 1
            return 1;
        }
        if (sequenceNumber.endsWith("99")) {        // Level 2
            return 2;
        }
        return 3;
    }
    
    
}