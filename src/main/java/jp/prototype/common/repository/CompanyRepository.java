package jp.prototype.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.prototype.common.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
// <==> CrudRepository JpaRepository

//  List<Company> findAll();
//
//  Company findByCode(String code);
}
