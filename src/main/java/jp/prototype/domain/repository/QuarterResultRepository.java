package jp.prototype.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.prototype.domain.model.QuarterResult;
import jp.prototype.domain.model.QuarterResultKey;

@Repository
public interface QuarterResultRepository
        extends JpaRepository<QuarterResult, QuarterResultKey> {

//  Page<QuarterResult> findByCode(String code, Pageable pageable);
//
//  Page<QuarterResult> findByName(String name, Pageable pageable);

}
