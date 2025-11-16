package app.model;

import javax.persistence.*;

@Entity
@Table(name="hours")
public class HoursLog{
    @Column(name="hours_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer hoursId;
    private Integer userId;
    private Integer sleepTime;
    private Integer wakeTime;
    private String sleepDate;
    private Float totalHours;


    //constructors
    public HoursLog(){

    }

    public HoursLog(Integer userId, String sleepDate, Integer sleepTime, Integer wakeTime, Float totalHours){
        this.userId = userId;
        this.sleepDate = sleepDate;
        this.sleepTime = sleepTime;
        this.wakeTime = wakeTime;
        this.totalHours = totalHours;
    }

    public HoursLog(Integer hoursId, Integer userId, String sleepDate, Integer sleepTime, Integer wakeTime, Float totalHours){
        this.hoursId = hoursId;
        this.userId = userId;
        this.sleepDate = sleepDate;
        this.sleepTime = sleepTime;
        this.wakeTime = wakeTime;
        this.totalHours = totalHours;
    }

    //getters and setters
    public Integer getHoursId(){
        return hoursId;
    }
    public void setHoursId(Integer hoursId){
        this.hoursId = hoursId;
    }

    public Integer getUserId(){
        return userId;
    }
    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public String getSleepDate(){
        return sleepDate;
    }
    public void setSleepDate(String sleepDate){
        this.sleepDate = sleepDate;
    }

    public Integer getSleepTime(){
        return sleepTime;
    }
    public void setSleepTime(Integer sleepTime){
        this.sleepTime = sleepTime;
    }

    public Integer getWakeTime(){
        return wakeTime;
    }
    public void setWakeTime(Integer wakeTime){
        this.wakeTime = wakeTime;
    }

    public Float getTotalHours(){
        return totalHours;
    }
    public void setTotalHours(Float totalHours){
        this.totalHours = totalHours;
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
        HoursLog other = (HoursLog) obj;
        if(!(this.hoursId == other.hoursId)){
            return false;
        }
        return true;         
    }

    @Override
    public String toString(){
        return "";
    }
}