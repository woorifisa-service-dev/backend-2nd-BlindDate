//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package dev.dto;

import dev.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequest {
    private String email;
    private String password;
    private String name;
    private boolean gender;
    private boolean marry;
    private boolean couple;
    private Long age;
    private Long height;


    public UserRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public UserRequest(final String email, final String password, final String name, final boolean gender, final boolean marry, final boolean couple, final Long age, final Long height) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.marry = marry;
        this.couple = couple;
        this.age = age;
        this.height = height;
    }
    public static UserRequest from(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        String name = user.getName();
        boolean gender = user.isGender();
        boolean marry = user.isMarry();
        boolean couple = user.isCouple();
        Long age = user.getAge();
        Long height = user.getHeight();
        return new UserRequest(email, password, name, gender, marry, couple, age, height);
    }

}
