package app.model;

import javax.persistence.*;

@Entity
@Table(name="dream_journal")
public class JournalEntry{
    @Column(name="entry_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer entryId;
    private Integer userId;
    private String date;
    private String textPayload;


    //constructors
    public JournalEntry(){

    }

    public JournalEntry(Integer userId, String date, String textPayload){
        this.userId = userId;
        this.date = date;
        this.textPayload = textPayload;
    }

    public JournalEntry(Integer entryId, Integer userId, String date, String textPayload){
        this.entryId = entryId;
        this.userId = userId;
        this.date = date;
        this.textPayload = textPayload;
    }

    //getters and setters
    public Integer getEntryId(){
        return entryId;
    }
    public void setEntryId(Integer entryId){
        this.entryId = entryId;
    }

    public Integer getUserId(){
        return userId;
    }
    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }

    public String getTextPayload(){
        return textPayload;
    }
    public void setTextPayload(String textPayload){
        this.textPayload = textPayload;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        JournalEntry other = (JournalEntry) obj;
        if(!(this.entryId == other.entryId)){
            return false;
        }
        return true;         
    }

    @Override
    public String toString(){
        return "JournalEntry{entryId=" + entryId + ", date=" +
        date + "textPayload=" + textPayload + "}";
    }
}