package com.system;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallanRepo extends JpaRepository<Challanfield,Long> {
}
