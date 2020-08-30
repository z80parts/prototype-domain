package jp.prototype.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.prototype.common.model.Company;
import jp.prototype.common.repository.CompanyRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CompanyService {

  private CompanyRepository repository;

  public List<Company> find() {

    return repository.findAll();
  }
}
