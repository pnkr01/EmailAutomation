package com.gchackathon.emailTracking.repository;

import com.gchackathon.emailTracking.models.KnowledgeBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnowledgeBaseRepository extends JpaRepository<KnowledgeBase, Long> {
}