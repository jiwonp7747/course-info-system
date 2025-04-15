package kr.ac.hansung.course.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRegisterRequest {

    @NotNull(message = "수강 연도는 필수입니다.")
    private Integer year;

    @Min(value = 1, message = "학기는 1 또는 2여야 합니다.")
    @Max(value = 2, message = "학기는 1 또는 2여야 합니다.")
    private Integer semester;

    @NotBlank(message = "교과코드는 필수입니다.")
    private String courseCode;

    @NotBlank(message = "교과목명은 필수입니다.")
    private String courseName;

    @NotBlank(message = "교과구분은 필수입니다.")
    private String courseType;

    @NotBlank(message = "담당교수는 필수입니다.")
    private String professor;

    @Min(value = 1, message = "학점은 1 이상이어야 합니다.")
    @Max(value = 5, message = "학점은 5 이하이어야 합니다.")
    private Integer credit;
}

;;;