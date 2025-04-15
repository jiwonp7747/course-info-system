package kr.ac.hansung.course.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import kr.ac.hansung.course.model.Course;
import kr.ac.hansung.course.model.CreditSummaryDto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    // 전체 조회 (최근 학기 먼저)
    public List<Course> getAllCourses() {
        String jpql = "SELECT c FROM Course c ORDER BY c.year DESC, c.semester DESC";
        TypedQuery<Course> query = entityManager.createQuery(jpql, Course.class);
        return query.getResultList();
    }

    // 연도 + 학기로 필터링
    public List<Course> getCoursesBySemester(int year, int semester) {
        String jpql = "SELECT c FROM Course c WHERE c.year = :year AND c.semester = :semester ORDER BY c.courseName";
        TypedQuery<Course> query = entityManager.createQuery(jpql, Course.class);
        query.setParameter("year", year);
        query.setParameter("semester", semester);
        return query.getResultList();
    }

    // 단건 조회 by id
    public Course getCourseById(Long id) {
        return entityManager.find(Course.class, id);
    }

    // 저장
    @Transactional
    public void insertCourse(Course course) {
        entityManager.persist(course);
    }

    // 수정
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    // 삭제
    @Transactional
    public void deleteCourse(Long id) {
        Course course = entityManager.find(Course.class, id);
        if (course != null) {
            entityManager.remove(course);
        }
    }

    public List<CreditSummaryDto> getCreditSummaryBySemester() {
        String jpql = "SELECT c.year, c.semester, SUM(c.credit) " +
                "FROM Course c " +
                "GROUP BY c.year, c.semester " +
                "ORDER BY c.year, c.semester";
        return entityManager.createQuery(jpql, CreditSummaryDto.class).getResultList();
    }
}
