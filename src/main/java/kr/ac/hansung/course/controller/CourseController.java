package kr.ac.hansung.course.controller;

import jakarta.validation.Valid;
import kr.ac.hansung.course.model.Course;
import kr.ac.hansung.course.model.CourseRegisterRequest;
import kr.ac.hansung.course.model.CreditSummaryDto;
import kr.ac.hansung.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
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

    /**
     * 학년별 이수 학점 조회 페이지
     * */
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

    /**
     * 학년별, 학기별 수강 과목 상세 조회 페이지
     * */
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

    /**
     * 수강 신청 페이지
     * */
    @GetMapping("/register-course")
    public String getRegisterCoursePage(
            Model model
    ) {
        model.addAttribute("courseRegisterRequest", new CourseRegisterRequest());
        return "register-course";
    }

    /**
     * 수강 신청 api
     * */
    @PostMapping("/course")
    public String registerCourse(
            @Valid @ModelAttribute CourseRegisterRequest request,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "register-course"; // 입력폼 다시 보여주기 (JSP 파일명)
        }
        courseService.saveCourse(request);

        return "redirect:/";
    }

    /**
     * 현재 학기 수강 신청 현황
     * */
    @GetMapping("/registered-courses")
    public String getRegisteredCourses(Model model) {
        int currentYear = LocalDate.now().getYear();
        int currentSemester = (LocalDate.now().getMonthValue() <= 6) ? 1 : 2;

        List<Course> response = courseService.getCoursesByYearAndSemester(currentYear, currentSemester);
        model.addAttribute("courses", response);
        model.addAttribute("year", currentYear);
        model.addAttribute("semester", currentSemester);

        return "registered-courses";
    }

    /**
     * 수강 신청 취소 api
     * */
    @DeleteMapping("/course")
    public String deleteCourse(
            @RequestParam("id") Long id,
            RedirectAttributes redirectAttributes
    ){
        courseService.deleteById(id);

        redirectAttributes.addFlashAttribute("alertMessage", "✅ 수강 신청이 취소되었습니다.");
        return "redirect:/registered-courses";
    }

}
