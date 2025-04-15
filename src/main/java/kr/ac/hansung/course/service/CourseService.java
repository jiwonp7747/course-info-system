package kr.ac.hansung.course.service;

import kr.ac.hansung.course.dao.CourseDao;
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
}
