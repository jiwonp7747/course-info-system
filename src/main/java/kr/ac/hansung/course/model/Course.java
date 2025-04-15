package kr.ac.hansung.course.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "year")
    private int year;

    @Column(name = "semester")
    private int semester;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_type")
    private String courseType;

    @Column(name = "professor")
    private String professor;

    @Column(name = "credit")
    private int credit;
}

/**
 *
 * CREATE TABLE courses (
 *          id bigint not null primary key auto_increment,
 *          year INT NOT NULL,                  -- 수강년도 (e.g., 2024)
 *          semester TINYINT NOT NULL,          -- 학기 (e.g., 1 or 2)
 *          course_code VARCHAR(10) NOT NULL,   -- 교과코드 (e.g., CSE0032)
 *          course_name VARCHAR(100) NOT NULL,  -- 교과목명 (e.g., 웹프레임워크 I)
 *          course_type VARCHAR(20),            -- 교과구분 (e.g., 전필, 교양)
 *          professor VARCHAR(50),              -- 담당교수 (e.g., 김남윤)
 *          credit TINYINT                     -- 학점 (e.g., 3)
 * );*/