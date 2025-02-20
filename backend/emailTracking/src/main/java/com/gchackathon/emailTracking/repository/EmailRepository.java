package com.gchackathon.emailTracking.repository;
import com.gchackathon.emailTracking.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    List<Email> findByAssignedUserId(long userId);
    @Query("SELECT e from Email e where e.assignedUser.email = :email")
    List<Email> findByAssignedUserEmail(String email);

//    @Query("SELECT COUNT(e) FROM Email e WHERE DATE(e.receivedAt) = CURRENT_DATE")
//    int countTodayQueries();
//
//    @Query("SELECT COUNT(e) FROM Email e WHERE e.status = 'PENDING'")
//    int countPendingQueries();
//
//    @Query("SELECT COUNT(e) FROM Email e WHERE e.status = 'ESCALATED'")
//    int countEscalatedQueries();
//
//    @Query("SELECT e.priority, COUNT(e) FROM Email e WHERE e.receivedAt >= CURRENT_DATE - 7 GROUP BY e.priority")
//    List<Object[]> getPriorityTrends();


    @Query("SELECT e.assignedUser.name, COUNT(e), " +
            "SUM(CASE WHEN e.status = 'SOLVED' THEN 1 ELSE 0 END), " +
            "e.receivedAt, e.escalatedTime, " +
            "SUM(CASE WHEN e.status = 'ESCALATED' THEN 1 ELSE 0 END) " +
            "FROM Email e "+
            "GROUP BY e.assignedUser.name, e.receivedAt, e.escalatedTime")
    List<Object[]> getTeamPerformance();
//    List<Object[]> getTeamPerformance();

    @Query("SELECT e.keywords, COUNT(e) FROM Email e GROUP BY e.keywords")
    List<Object[]> getCommonQueryTypes();

//    @Query("SELECT COUNT(e) / (SELECT COUNT(*) FROM Email) * 100 FROM Email e WHERE e.status = 'SOLVED'")
//    double getQueryResolutionRate();

//    @Query("SELECT DATE(e.receivedAt), COUNT(e) FROM Email e WHERE e.status = 'ASSIGNED'  GROUP BY DATE(e.receivedAt)")
//    List<Object[]> getEscalationTrends();

    @Query("SELECT DATE(e.receivedAt), COUNT(e) FROM Email e " +
            "WHERE e.status = 'ASSIGNED' " +  // Fetch only last 7 days
            "GROUP BY DATE(e.receivedAt) " +
            "ORDER BY DATE(e.receivedAt)")
    List<Object[]> getEscalationTrendsLast7Days();
//
//    @Query("SELECT DATE(e.receivedAt), COUNT(e) FROM Email e WHERE e.status = 'SOLVED' AND e.receivedAt >= CURRENT_DATE - 7 GROUP BY DATE(e.receivedAt)")
//    List<Object[]> getResolutionTrends();
//
//    @Query("SELECT e FROM Email e WHERE e.status = 'SOLVED'")
//    List<Object[]> getSolvedQueries();
//
//    @Query("SELECT COUNT(e) FROM Email e")
//    long getTotalQueryCount();
}
