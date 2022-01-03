package Entite;

import java.util.Date;
import java.util.Objects;


public class User {
    
    private int id;
    private String userName;
        private String pseudoName;
            private String userMail;
                private String userPassword;
                    private String userPhone;
                        private String userCin;
                             private String userAddress;
                                  private String userPhoto;
                                       private Date userDayOfBirth;
                                            private String userSite;
                                                 private Date createdAt;
                                                      private String nationality;
                                                           private String speciality;
                                                                private String bio;
                                                                     private String role;

    public User( String userName, String pseudoName, String userMail, String userPassword, String userPhone, String userCin, String userAddress, String userPhoto, Date userDayOfBirth, String userSite, Date createdAt, String nationality, String speciality, String bio, String role) {
        
        this.userName = userName;
        this.pseudoName = pseudoName;
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userCin = userCin;
        this.userAddress = userAddress;
        this.userPhoto = userPhoto;
        this.userDayOfBirth = userDayOfBirth;
        this.userSite = userSite;
        this.createdAt = createdAt;
        this.nationality = nationality;
        this.speciality = speciality;
        this.bio = bio;
        this.role = role;
    }
                                                                     
                                                                     
                                                                     
                                                                     
                                                                     
       public User(){
       };

    public User(String youssefbj, String peudo, String mail, String string) {
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPseudoName() {
        return pseudoName;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserCin() {
        return userCin;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public Date getUserDayOfBirth() {
        return userDayOfBirth;
    }

    public String getUserSite() {
        return userSite;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getNationality() {
        return nationality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getBio() {
        return bio;
    }

    public String getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPseudoName(String pseudoName) {
        this.pseudoName = pseudoName;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setUserCin(String userCin) {
        this.userCin = userCin;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public void setUserDayOfBirth(Date userDayOfBirth) {
        this.userDayOfBirth = userDayOfBirth;
    }

    public void setUserSite(String userSite) {
        this.userSite = userSite;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName=" + userName + ", pseudoName=" + pseudoName + ", userMail=" + userMail + ", userPassword=" + userPassword + ", userPhone=" + userPhone + ", userCin=" + userCin + ", userAddress=" + userAddress + ", userPhoto=" + userPhoto + ", userDayOfBirth=" + userDayOfBirth + ", userSite=" + userSite + ", createdAt=" + createdAt + ", nationality=" + nationality + ", speciality=" + speciality + ", bio=" + bio + ", role=" + role + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.pseudoName, other.pseudoName)) {
            return false;
        }
        if (!Objects.equals(this.userMail, other.userMail)) {
            return false;
        }
        if (!Objects.equals(this.userPassword, other.userPassword)) {
            return false;
        }
        if (!Objects.equals(this.userPhone, other.userPhone)) {
            return false;
        }
        if (!Objects.equals(this.userCin, other.userCin)) {
            return false;
        }
        if (!Objects.equals(this.userAddress, other.userAddress)) {
            return false;
        }
        if (!Objects.equals(this.userPhoto, other.userPhoto)) {
            return false;
        }
        if (!Objects.equals(this.userSite, other.userSite)) {
            return false;
        }
        if (!Objects.equals(this.nationality, other.nationality)) {
            return false;
        }
        if (!Objects.equals(this.speciality, other.speciality)) {
            return false;
        }
        if (!Objects.equals(this.bio, other.bio)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        if (!Objects.equals(this.userDayOfBirth, other.userDayOfBirth)) {
            return false;
        }
        if (!Objects.equals(this.createdAt, other.createdAt)) {
            return false;
        }
        return true;
    }
    

}


