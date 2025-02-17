package com.gchackathon.emailTracking.controller;
import com.gchackathon.emailTracking.models.KnowledgeBase;
import com.gchackathon.emailTracking.service.KnowledgeBaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/knowledge-base")
public class KnowledgeBaseController {

    private final KnowledgeBaseService knowledgeBaseService;

    public KnowledgeBaseController(KnowledgeBaseService knowledgeBaseService) {
        this.knowledgeBaseService = knowledgeBaseService;
    }

    @PostMapping
    public ResponseEntity<KnowledgeBase> addKnowledgeBase(@RequestBody KnowledgeBase knowledgeBase) {
        return ResponseEntity.ok(knowledgeBaseService.addKnowledgeBase(knowledgeBase));
    }

    @GetMapping("/{id}")
    public ResponseEntity<KnowledgeBase> getKnowledgeBaseById(@PathVariable Long id) {
        return ResponseEntity.ok(knowledgeBaseService.getKnowledgeBaseById(id));
    }

    @GetMapping
    public ResponseEntity<List<KnowledgeBase>> getAllKnowledgeBases() {
        return ResponseEntity.ok(knowledgeBaseService.getAllKnowledgeBases());
    }
}
