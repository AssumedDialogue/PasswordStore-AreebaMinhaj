package ca.sheridancollege.minhaja.passwordstoreareebaminhaj.beans;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="PASSWORD")
public class PasswordRecord {
    @Id
    @NonNull
    @Column(name = "ID")
    private long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "URL")
    private String url;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "NOTES", length = 500)
    private String notes;
}
