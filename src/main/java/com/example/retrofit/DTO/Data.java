package com.example.retrofit.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Data extends DefaultDTO {
    private Long id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

    @Override
    public String toString() {

        return "    Data {" + "\n" +
                "       id=" + id +"\n" +
                "       email='" + email +'\''+ "\n"  +
                "       first_name='" + first_name + '\''+"\n" +
                "       last_name='" + last_name +'\''+ "\n" +
                "       avatar='" + avatar + '\''+"\n" +
                "   }";
    }
}
