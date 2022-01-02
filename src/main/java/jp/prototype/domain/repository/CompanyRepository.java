package jp.prototype.domain.repository;

import jp.prototype.domain.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
// <==> CrudRepository JpaRepository

//  List<Company> findAll();
//
//  Company findByCode(String code);
}
