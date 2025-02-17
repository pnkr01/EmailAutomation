package com.gchackathon.emailTracking.service;

import com.gchackathon.emailTracking.models.KnowledgeBase;

import java.util.List;

public interface KnowledgeBaseService {
    KnowledgeBase addKnowledgeBase(KnowledgeBase knowledgeBase);
    KnowledgeBase getKnowledgeBaseById(Long id);
    List<KnowledgeBase> getAllKnowledgeBases();
}