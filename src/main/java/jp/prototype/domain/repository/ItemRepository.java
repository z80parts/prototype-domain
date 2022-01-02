package jp.prototype.domain.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.prototype.domain.model.Item;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class ItemRepository {

  private JdbcTemplate jdbcTemplate;

  public int[] batchInsert(List<Item> items) {
    return this.jdbcTemplate.batchUpdate(createSql(), new BatchPreparedStatementSetter() {
      public void setValues(PreparedStatement ps, int i) throws SQLException {
        ps.setInt(1, items.get(i).getId());
        ps.setString(2, items.get(i).getName());
        ps.setString(3, items.get(i).getType());
        ps.setString(4, items.get(i).getName());
        ps.setString(5, items.get(i).getType());
      }

      public int getBatchSize() {
        return items.size();
      }

    });
  }

  private String createSql() {
    StringBuilder sb = new StringBuilder();
    sb.append("insert into item (id, name, type) values(?,?,?)");
    sb.append(" ON DUPLICATE KEY UPDATE name=?, type=?");
    return sb.toString();
  }
}
