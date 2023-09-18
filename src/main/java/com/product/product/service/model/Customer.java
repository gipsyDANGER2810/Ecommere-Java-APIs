package com.product.product.service.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name ="users")
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements UserDetails {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(length = 50 , name ="user_id")
    private String userId;

    @Column(name = "user_name")
    private String username;

    private String password;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value="user-review")
    private List<Review> reviews = new ArrayList<>();

    public Customer(String userId , String username , String password){
        super();
        this.userId = userId;
        this.username=username;
        this.password=password;
    }

    public Customer( String username , String password){
        super();
        this.username=username;
        this.password=password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userid){

        this.userId =  Base64.getEncoder().withoutPadding().encodeToString(userid.getBytes());
        System.out.println("############USER ID##############\n"+this.userId +"\n"+this.userId.length());
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +  // Maybe exclude password for security reasons
                ", reviews=" + reviews +
                '}';
    }
}
