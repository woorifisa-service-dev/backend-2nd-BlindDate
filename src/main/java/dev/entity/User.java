//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package dev.entity;

import dev.dto.UserRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String email;
    private String password;
    private String name;
    private boolean gender;
    private boolean marry;
    private boolean couple;
    private Long age;
    private Long height;


    public User(String email, String password, String name, boolean gender, boolean marry, boolean couple, Long age, Long height) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.marry = marry;
        this.couple = couple;
        this.age = age;
        this.height = height;
    }

    public static User from(UserRequest userRequest) {
        String email = userRequest.getEmail();
        String password = userRequest.getPassword();
        String name = userRequest.getName();
        boolean gender = userRequest.isGender();
        boolean marry = userRequest.isMarry();
        boolean couple = userRequest.isCouple();
        Long age = userRequest.getAge();
        Long height = userRequest.getHeight();
        return new User(email, password, name, gender, marry, couple, age, height);
    }


}
