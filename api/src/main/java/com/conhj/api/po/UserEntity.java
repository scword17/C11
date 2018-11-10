package com.conhj.api.po;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String username;

    @Column(name="sex")
    private String sex;
    @Column(name="age")
    private Integer age;
    @Column(name="pwd")
    private String password;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //    @Id
//    @Column(name = "id")
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @Basic
//    @Column(name = "name")
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    @Basic
//    @Column(name = "sex")
//    public String getSex() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//    @Basic
//    @Column(name = "age")
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    @Basic
//    @Column(name = "pwd")
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String pwd) {
//        this.password = pwd;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserEntity that = (UserEntity) o;
//        return id == that.id &&
//                Objects.equals(username, that.username) &&
//                Objects.equals(sex, that.sex) &&
//                Objects.equals(age, that.age) &&
//                Objects.equals(password, that.password);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, username, sex, age, password);
//    }

}

