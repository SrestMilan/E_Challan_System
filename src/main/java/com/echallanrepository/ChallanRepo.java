package com.echallanrepository;

import com.model.Challanfield;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallanRepo extends JpaRepository<Challanfield, Long> {
}
