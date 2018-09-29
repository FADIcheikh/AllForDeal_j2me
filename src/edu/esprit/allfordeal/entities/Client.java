/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.entities;

import java.util.Date;

/**
 *
 * @author FADI
 */
public class Client {

   private int id;
    private String username;
    private String usernameCanonical;
    private String email;
    private String emailCanonical;
    private boolean enabled;
    private String salt;
    private String password;
    private Date lastLogin;
    private boolean locked;
    private boolean expired;
    private Date expiresAt;
    private String confirmationToken;
    private Date passwordRequestedAt;
    private String roles;
    private boolean credentialsExpired;
    private Date credentialsExpireAt;
    private String adresse;
    private String firstName;
    private String lastName;
    private int telephone;
    private int sexe;
    private Date dateNaissance;
    private Date dateInscription;
    private int nbPoint;

    public Client() {

        this.enabled = true;
        this.locked = false;
        this.expired = false;
        this.credentialsExpired = false;
        this.roles = "a:0:{}";

    }

    public Client(int id, String username, String usernameCanonical, String email, String emailCanonical, int enabled, String salt, String password, Date lastLogin, int locked, int expired, Date expiresAt, String confirmationToken, Date passwordRequestedAt, String roles, int credentialsExpired, Date credentialsExpireAt, String adresse, String firstName, String lastName, int telephone, int sexe, Date dateNaissance, Date dateInscription, int nbPoint) {
        this.id = id;
        this.username = username;
        this.usernameCanonical = usernameCanonical;
        this.email = email;
        this.emailCanonical = emailCanonical;
        this.enabled = true;
        this.salt = salt;
        this.password = password;
        this.lastLogin = lastLogin;
        this.locked = false;
        this.expired = false;
        this.expiresAt = expiresAt;
        this.confirmationToken = confirmationToken;
        this.passwordRequestedAt = passwordRequestedAt;
        this.roles = "a:0:{}";
        this.credentialsExpired = false;
        this.credentialsExpireAt = credentialsExpireAt;
        this.adresse = adresse;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.dateInscription = dateInscription;
        this.nbPoint = nbPoint;
    }

    public Client(int id, String username, String email, String salt, String password, String adresse, String firstName, String lastName, int telephone, int sexe, Date dateNaissance, Date dateInscription, int nbPoint) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.salt = salt;
        this.password = password;
        this.adresse = adresse;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.dateInscription = dateInscription;
        this.nbPoint = nbPoint;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameCanonical() {
        return usernameCanonical;
    }

    public void setUsernameCanonical(String usernameCanonical) {
        this.usernameCanonical = usernameCanonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCanonical() {
        return emailCanonical;
    }

    public void setEmailCanonical(String emailCanonical) {
        this.emailCanonical = emailCanonical;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getPasswordRequestedAt() {
        return passwordRequestedAt;
    }

    public void setPasswordRequestedAt(Date passwordRequestedAt) {
        this.passwordRequestedAt = passwordRequestedAt;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public boolean isCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    public Date getCredentialsExpireAt() {
        return credentialsExpireAt;
    }

    public void setCredentialsExpireAt(Date credentialsExpireAt) {
        this.credentialsExpireAt = credentialsExpireAt;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public int getNbPoint() {
        return nbPoint;
    }

    public void setNbPoint(int nbPoint) {
        this.nbPoint = nbPoint;
    }
    
    
}
