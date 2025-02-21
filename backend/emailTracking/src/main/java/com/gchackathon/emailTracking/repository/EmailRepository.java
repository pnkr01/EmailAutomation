package com.gchackathon.emailTracking.repository;
import com.gchackathon.emailTracking.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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


//    @Query("SELECT e.assignedUser.name, COUNT(e), " +
//            "SUM(CASE WHEN e.status = 'SOLVED' THEN 1 ELSE 0 END), " +
//            "e.receivedAt, e.escalatedTime, " +
//            "SUM(CASE WHEN e.status = 'ESCALATED' THEN 1 ELSE 0 END) " +
//            "FROM Email e "+
//            "GROUP BY e.assignedUser.name, e.receivedAt, e.escalatedTime")
//    List<Object[]> getTeamPerformance();
//    List<Object[]> getTeamPerformance();

    @Query("SELECT e.keywords, COUNT(e) FROM Email e GROUP BY e.keywords")
    List<Object[]> getCommonQueryTypes();

//    @Query("SELECT COUNT(e) / (SELECT COUNT(*) FROM Email) * 100 FROM Email e WHERE e.status = 'SOLVED'")
//    double getQueryResolutionRate();

    @Query(value = "SELECT DATE(received_at) AS date, COUNT(*) AS resolvedQueries " +
            "FROM Email " +
            "WHERE status = 'ASSIGNED' " +
            "GROUP BY DATE(received_at) " +
            "ORDER BY DATE(received_at)", nativeQuery = true)
    List<Object[]> getQueryResolutionTrend();




//    @Query("SELECT DATE(e.receivedAt), COUNT(e) FROM Email e WHERE e.status = 'ASSIGNED'  GROUP BY DATE(e.receivedAt)")
//    List<Object[]> getEscalationTrends();

    @Query("SELECT DATE(e.receivedAt), COUNT(e) FROM Email e " +
            "WHERE e.status = 'ASSIGNED' " +  // Fetch only last 7 days
            "GROUP BY DATE(e.receivedAt) " +
            "ORDER BY DATE(e.receivedAt)")
    List<Object[]> getEscalationTrendsLast7Days();

    @Query(value = "SELECT e.keywords AS category, COUNT(e.id) AS count " +
            "FROM Email e " +
            "GROUP BY e.keywords")
    List<Object[]> getCategoryDistribution();


    @Query(value = "SELECT DATE(received_at) AS date, " +
            "       (COUNT(CASE WHEN status = 'SOLVED' THEN 1 END) * 100.0) / COUNT(*) AS resolution_rate " +
            "FROM Email " +
            "GROUP BY DATE(received_at) " +
            "ORDER BY DATE(received_at)",
            nativeQuery = true)
    List<Object[]> getQueryResolutionRate();


    @Query(value = "SELECT DATE(e.received_at) AS date, " +
            "       (COUNT(CASE WHEN TIMESTAMPDIFF(HOUR, e.received_at, e.solved_at) <= 2 THEN 1 END) * 100.0) / COUNT(*) AS compliance_rate " +
            "FROM Email e " +
            "WHERE e.status = 'SOLVED' " +
            "GROUP BY DATE(e.received_at) " +
            "ORDER BY DATE(e.received_at)",
            nativeQuery = true)
    List<Object[]> getSLAComplianceRate();



    @Query("SELECT e.assignedUser.name, e.receivedAt, e.lastUpdatedAt, e.solvedAt, e.status " +
            "FROM Email e " +
            "WHERE e.assignedUser.adminAddSme.aid = :id")
    List<Object[]> getEmailData(long id);





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
