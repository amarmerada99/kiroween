package app.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Column(name="user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String username;
    private String password;

    public User(){

    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(Integer userId, String username, String password){
        this.userId = userId;
        this.password = password;
        this.username = username;
    }

    public Integer getUserId(){
        return userId;
    }
    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
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
        User other = (User) obj;
        if(userId == null){
            if(other.userId != null){
                return false;
            } 
        } else if (!userId.equals(other.userId)){
            return false;
        }
        if (password == null){
            if(other.password != null){
                return false;
            }
        }else if (!password.equals(other.password)){
                return false;
        }
        if(username == null){
            if(other.username != null){
                return false;
            }
        } else if (!(username.equals(other.username))){
            return false;
        }
        return true;         
    }

    @Override
    public String toString(){
        return "User{userId=" + userId +", username=" + username
        + ", password=" + password + "}";
    }
}