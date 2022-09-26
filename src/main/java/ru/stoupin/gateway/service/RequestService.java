package ru.stoupin.gateway.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stoupin.gateway.domain.Request;
import ru.stoupin.gateway.repository.RequestRepository;

@Slf4j
@Service
public class RequestService {
    @Autowired
    private RequestRepository requestRepository;

    public Request registerRequest(Request request) {
        log.info("save {}", request);
        return requestRepository.save(request);
    }
}
