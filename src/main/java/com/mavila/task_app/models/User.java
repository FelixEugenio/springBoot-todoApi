package com.mavila.task_app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = User.TableName)
public class User {

    public interface ICreateUser{}

    public interface IUpdateUser{}

    public static final String TableName = "user";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id",unique=true)
     private long id;
     
     @Column(name = "username",unique=true,nullable = false,length = 100)
     @NotNull(groups=ICreateUser.class)
     @NotEmpty(groups=ICreateUser.class)
     @Size(min = 2,max = 100,groups=ICreateUser.class)
     private String username;

     @Column(name = "password",nullable = false,length = 60)
     @NotNull(groups= {ICreateUser.class,IUpdateUser.class})
     @NotEmpty(groups=  {ICreateUser.class,IUpdateUser.class})
     @Size(min = 8,max = 60,groups= {ICreateUser.class,IUpdateUser.class})
     private String password;

     //private List<Task> tasks = new ArrayList<Task>();

     //constructor
      public User(Long id, String username, String password) {
          this.id = id;
          this.username = username;
          this.password = password;
      }

      //getters and setters
      public long getId() {
          return id;
      }
      public void setId(long id) {
          this.id = id;
      }
      public String getUsername() {
          return username;
      }
      public void setUsername(String username) {
          this.username = username;
      }
      public String getPassword() {
          return password;
      }
      public void setPassword(String password) {
          this.password = password;
      }

      //equals and hashcode
      @Override
      public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          User user = (User) o;
          return id == user.id && username.equals(user.username) && password.equals(user.password);
      }
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + username.hashCode();
        result = prime * result + password.hashCode();
        return result;
      }
}
