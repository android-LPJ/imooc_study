package com.imooc.io;

import sun.misc.SharedSecrets;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {

    private String stuno;
    private String stuname;
    private transient int stuage; // 该元素不会进行jvm默认的序列化
    public Student() {

    }

    public Student(String stuno, String stuname, int stuage) {
        this.stuno = stuno;
        this.stuname = stuname;
        this.stuage = stuage;
    }

    public int getStuage() {
        return stuage;
    }

    public void setStuage(int stuage) {
        this.stuage = stuage;
    }

    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuno='" + stuno + '\'' +
                ", stuname='" + stuname + '\'' +
                ", stuage=" + stuage +
                '}';
    }

    private void writeObject(java.io.ObjectOutputStream s) throws IOException {
        s.defaultWriteObject(); // 把jvm默认序列化的元素进行序列化操作
        s.writeInt(stuage); // 自己完成序列化
    }

    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject(); // 把jvm默认序列化反序列化
        this.stuage = s.readInt(); // 把自己完成的序列化反序列化
    }
}
