package com.hlkw.cafe.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@Component @Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    private String id;
    private String pw;
    private String addr;
    private int age;
    private String phoneNum;
    private Gender gender;
    private String email;
    private String nickname;
    private Level level;

//    public void setLevel(String level) {
//        switch (level) {
//            case "manager" : this.level = Level.MANAGER;
//                break;
//            case "cosmos" : this.level = Level.COSMOS;
//                break;
//            case "galaxy" : this.level = Level.GALAXY;
//                break;
//            case "nebula" : this.level = Level.NEBULA;
//                break;
//            case "dust" : this.level = Level.DUST;
//                break;
//        }
//    }
//
//    public void setLevel(String level){
//        this.level = Level.valueOf(level);
//    }
}
