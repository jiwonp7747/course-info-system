package kr.ac.hansung.course.service;

import kr.ac.hansung.course.dao.CourseDao;
import kr.ac.hansung.course.model.Course;
import kr.ac.hansung.course.model.CourseRegisterRequest;
import kr.ac.hansung.course.model.CreditSummaryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseDao courseDao;

    @Autowired
    public CourseService(
        CourseDao courseDao
    ) {
        this.courseDao = courseDao;
    }

    public List<CreditSummaryDto> getCoursesGroupBySemester() {
        return courseDao.getCreditSummaryBySemester();
    }

    public List<Course> getCoursesByYearAndSemester(int year, int semester) {
        return courseDao.getCoursesBySemester(year, semester);
    }

    public void saveCourse(CourseRegisterRequest request) {
        Course course = Course.builder()
                .year(request.getYear())
                .semester(request.getSemester())
                .courseCode(request.getCourseCode())
                .courseName(request.getCourseName())
                .courseType(request.getCourseType())
                .professor(request.getProfessor())
                .credit(request.getCredit())
                .build()
                ;

        courseDao.insertCourse(course);
    }

    public void deleteById(Long id) {
        courseDao.deleteCourse(id);
    }
}
