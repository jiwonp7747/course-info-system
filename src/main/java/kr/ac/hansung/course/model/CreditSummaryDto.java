package kr.ac.hansung.course.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreditSummaryDto {
    private Integer year;
    private Integer semester;
    private Long totalCredit;
}
