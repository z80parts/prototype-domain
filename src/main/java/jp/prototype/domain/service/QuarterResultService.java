package jp.prototype.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jp.prototype.domain.model.QuarterResult;
import jp.prototype.domain.repository.QuarterResultRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class QuarterResultService {

  private QuarterResultRepository repository;

  public Page<QuarterResult> findAll(int page, int size) {
    return repository.findAll(PageRequest.of(page, size));
  }
  
  public long count() {
    return 100;
  }

}