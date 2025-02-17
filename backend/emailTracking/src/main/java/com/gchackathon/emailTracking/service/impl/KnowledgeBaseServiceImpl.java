package com.gchackathon.emailTracking.service.impl;
import com.gchackathon.emailTracking.models.KnowledgeBase;
import com.gchackathon.emailTracking.repository.KnowledgeBaseRepository;
import com.gchackathon.emailTracking.service.KnowledgeBaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgeBaseServiceImpl implements KnowledgeBaseService {

    private final KnowledgeBaseRepository knowledgeBaseRepository;

    public KnowledgeBaseServiceImpl(KnowledgeBaseRepository knowledgeBaseRepository) {
        this.knowledgeBaseRepository = knowledgeBaseRepository;
    }

    @Override
    public KnowledgeBase addKnowledgeBase(KnowledgeBase knowledgeBase) {
        return knowledgeBaseRepository.save(knowledgeBase);
    }

    @Override
    public KnowledgeBase getKnowledgeBaseById(Long id) {
        return knowledgeBaseRepository.findById(id).orElse(null);
    }

    @Override
    public List<KnowledgeBase> getAllKnowledgeBases() {
        return knowledgeBaseRepository.findAll();
    }
}
