package com.zemelya.domain;

import java.util.Objects;

import static com.zemelya.util.Constants.EMPTY_STRING;

public class Student  implements Comparable<Student>{
    private String fullName;
    private String faculty;
    private String speciality;
    private int age;
    private int course;
    private final int DEFAULT_INT_VALUE = 0;

    public Student() {
        this.fullName = EMPTY_STRING;
        this.faculty = EMPTY_STRING;
        this.speciality = EMPTY_STRING;
        this.age = DEFAULT_INT_VALUE;
        this.course = DEFAULT_INT_VALUE;
    }

    public Student(String fullName, String faculty, String speciality, int age, int course) {
        this.fullName = fullName;
        this.faculty = faculty;
        this.speciality = speciality;
        this.age = age;
        this.course = course;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                course == student.course &&
                Objects.equals(fullName, student.fullName) &&
                Objects.equals(faculty, student.faculty) &&
                Objects.equals(speciality, student.speciality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, faculty, speciality, age, course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' + ", faculty='" + faculty + '\'' + ", speciality='" + speciality + '\'' +
                ", age=" + age + ", course=" + course + '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.fullName.compareToIgnoreCase(o.getFullName());
    }
}
