package ru.stoupin.gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stoupin.gateway.domain.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
}
