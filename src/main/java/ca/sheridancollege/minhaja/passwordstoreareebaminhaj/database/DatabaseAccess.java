package ca.sheridancollege.minhaja.passwordstoreareebaminhaj.database;

import ca.sheridancollege.minhaja.passwordstoreareebaminhaj.beans.PasswordRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatabaseAccess extends CrudRepository<PasswordRecord, Long> {

    List<PasswordRecord> findByTitle(String Title);
}
