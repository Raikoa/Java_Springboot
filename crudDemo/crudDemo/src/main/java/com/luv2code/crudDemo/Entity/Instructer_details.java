package com.luv2code.crudDemo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="instructor_detail")
public class Instructer_details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="youtube_channel")
    private String youtube;
    @Column(name ="hobby")
    private String hobby;

    public Instructer_details(){

    }

    public Instructer_details(String youtube, String hobby) {
        this.youtube = youtube;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Instructer_details{" +
                "id=" + id +
                ", youtube='" + youtube + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
