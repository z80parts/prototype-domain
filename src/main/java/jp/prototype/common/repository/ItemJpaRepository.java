package jp.prototype.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.prototype.common.model.Item;

@Repository
public interface ItemJpaRepository extends JpaRepository<Item, String> {
}
