package kr.ac.hansung.course.controller;

import kr.ac.hansung.course.model.Course;
import kr.ac.hansung.course.model.CreditSummaryDto;
import kr.ac.hansung.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(
        CourseService courseService
    ) {
        this.courseService = courseService;
    }

    @GetMapping("/completed-courses")
    public String getCompletedCoursesByGrade(Model model) {
        List<CreditSummaryDto> response= courseService.getCoursesGroupBySemester();
        Long totalCredit = response.stream()
                .mapToLong(CreditSummaryDto::getTotalCredit)
                .sum();


        model.addAttribute("creditSummary", response);
        model.addAttribute("totalCredit", totalCredit);

        return "credit-summary";
    }

    @GetMapping("/courses")
    public String getCoursesByYearAndSemester(
            Model model,
            @RequestParam(name = "year") int year,
            @RequestParam(name = "semester") int semester
    ) {
        List<Course> response= courseService.getCoursesByYearAndSemester(year, semester);

        model.addAttribute("courses", response);

        return "courses";
    }

    @PostMapping("/course")
    public String registerCourse(int studentId, int grade) {
        return null;
    }

    @GetMapping("/current-courses")
    public String getRegisteredCourses() {
        return null;
    }
}
