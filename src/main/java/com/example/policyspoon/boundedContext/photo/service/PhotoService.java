package com.example.policyspoon.boundedContext.photo.service;

import com.example.policyspoon.boundedContext.photo.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PhotoService {
    
    private final PhotoRepository photoRepository;
}
