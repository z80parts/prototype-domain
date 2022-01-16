package jp.prototype.domain.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.prototype.domain.model.QuarterResult;
import jp.prototype.domain.model.QuarterResultKey;

@Repository
public interface QuarterResultRepository
        extends JpaRepository<QuarterResult, QuarterResultKey> {

  @Query(value = "select * from quarter_result qr where qr.name like %?1%", nativeQuery = true)
  List<QuarterResult> findByName(String name);

  @Query(value = "select qr from QuarterResult qr where qr.name like %:name%")
  List<QuarterResult> findByNameJpql(@Param("name") String name);

  /**
   * あいまい検索。
   * 
   * <pre>
   * SQLはメソッド名から自動生成
   * ・select count(*) from quarter_result where name like '%name%';
   * ・select * from quarter_result where name like '%name%'limit ?,?;
   * </pre>
   * 
   * @param name
   * @param pageable
   * @return
   */
  Page<QuarterResult> findByNameContaining(String name, Pageable pageable);

}
