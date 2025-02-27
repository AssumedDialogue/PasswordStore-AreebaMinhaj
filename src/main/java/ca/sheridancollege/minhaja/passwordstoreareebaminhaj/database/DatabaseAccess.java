package ca.sheridancollege.minhaja.passwordstoreareebaminhaj.database;

import ca.sheridancollege.minhaja.passwordstoreareebaminhaj.beans.PasswordRecord;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatabaseAccess extends CrudRepository<PasswordRecord, Long> {
    List<PasswordRecord> findByTitle(String Title);

    @Query("SELECT s FROM PASSWORD s WHERE s.title like 'title'")
    List<PasswordRecord> findAllTitle();

    String title(String title);
}
