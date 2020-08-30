package jp.prototype.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.prototype.common.model.Item;
import jp.prototype.common.repository.ItemRepository;

@Service
public class ItemService {
  
  @Autowired
  private ItemRepository repo;
  
  public void write(List<Item> items) {
    repo.batchInsert(items);
  }

}
