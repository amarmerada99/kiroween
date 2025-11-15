package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name="night_quiz")
public class NightQuiz {
    @Column(name="quiz_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer nQuizId;
    private Integer userId;
    private String date;
    private Integer productivity;
    private Integer tirednessOnset;

    //constructors
    public NightQuiz(){

    }

    public NightQuiz(Integer userId, String date, Integer productivity, Integer tirednessOnset){
        this.userId = userId;
        this.date = date;
        this.productivity = productivity;
        this.tirednessOnset = tirednessOnset;
    }

    public NightQuiz(Integer nQuizId, Integer userId, String date, Integer productivity, Integer tirednessOnset){
        this.nQuizId = nQuizId;
        this.userId = userId;
        this.date = date;
        this.productivity = productivity;
        this.tirednessOnset = tirednessOnset;
    }

    //getters and setters

    public Integer getNQuizId(){
        return nQuizId;
    }
    public void setNQuizId(Integer nQuizId){
        this.nQuizId = nQuizId;
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

    public Integer getTirednessOnset(){
        return tirednessOnset;
    }
    public void setTirednessOnset(Integer tirednessOnset){
        this.tirednessOnset = tirednessOnset;
    }

    public Integer getProductivity(){
        return productivity;
    }
    public void setProductivity(Integer productivity){
        this.productivity = productivity;
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
        NightQuiz other = (NightQuiz) obj;
        if(!this.nQuizId == other.nQuizId){
            return false;
        }
        return true;         
    }

    @Override
    public String toString(){
        return "NightQuiz{nQuizId=" + nQuizId + ", userId=" +
        userId + ", date=" + date + ", productivity=" +
        productivity + ", tirednessOnset=" + tirednessOnset + "}";
    }
}