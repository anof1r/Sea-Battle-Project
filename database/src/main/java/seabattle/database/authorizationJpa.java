package seabattle.database;

/*
 * Copyright
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Factorial JPA.
 *
 * @since 0.0.1
 */
@Entity
@Table(schema = "public", name = "authorizationDB")
public class authorizationJpa {

    /**
     * Primary key.
     * Autogenerated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    /**
     * User nickname
     */
    @Column(name = "nickname")
    private String nickname;
    /**
     * User email
     */
    @Column(name = "email")
    private String email;
    /**
     * User password
     */
    @Column(name = "password")
    private String password;

    @Column(name = "regdate")
    private Date date;

    public authorizationJpa() {
    }



    public authorizationJpa(
            final String nickname,
            final String email,
            final String password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.date = new Date();
    }

    /**
     * Get ID of user.
     *
     * @return Id.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Get nickname of user.
     *
     * @return Name.
     */
    public String getNickname() {
        return this.nickname;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}


