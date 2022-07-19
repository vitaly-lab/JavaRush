package com.javarush.task.task33.task3313;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
@JsonAutoDetect
public class Event {
    public String name;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    public Date eventDate;

    public Event(String name) {
        this.name = name;
        eventDate = new Date();

    }
}