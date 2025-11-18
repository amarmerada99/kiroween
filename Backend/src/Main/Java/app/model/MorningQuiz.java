package app.model;

import javax.persistence.*;

@Entity
@Table(name="morning_quiz")
public class MorningQuiz{
    @Column(name="quiz_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer mQuizId;
    private Integer userId;
    private LocalDate date;
    private Integer sleepRating;


    //constructors
    public MorningQuiz(){

    }

    public MorningQuiz(Integer userId, LocalDate date, Integer sleepRating){
        this.userId = userId;
        this.date = date;
        this.sleepRating = sleepRating;
    }

    public MorningQuiz(Integer mQuizId, Integer userId, LocalDate date, Integer sleepRating){
        this.mQuizId = mQuizId;
        this.userId = userId;
        this.date = date;
        this.sleepRating = sleepRating;
    }

    //getters and setters
    public Integer getMQuizId(){
        return mQuizId;
    }
    public void setMQuizId(Integer mQuizId){
        this.mQuizId = mQuizId;
    }

    public Integer getUserId(){
        return userId;
    }
    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public LocalDate getDate(){
        return date;
    }
    public void setDate(LocalDate date){
        this.date = date;
    }

    public Integer getSleepRating(){
        return sleepRating;
    }
    public void setSleepRating(Integer sleepRating){
        this.sleepRating = sleepRating;
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
        MorningQuiz other =  (MorningQuiz) obj;
        if(!(this.mQuizId == other.mQuizId)){
            return false;
        }
        return true;         
    }

    @Override
    public String toString(){
        return "MorningQuiz{mQuizId=" + mQuizId + ", userId="
        + userId + ", sleepRating=" + sleepRating + ", date="
        + date + "}";
    }
}