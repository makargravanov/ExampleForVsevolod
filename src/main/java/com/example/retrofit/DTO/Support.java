package com.example.retrofit.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Support extends DefaultDTO {
    private String url;
    private String text;

    @Override
    public String toString() {
        return "    Support {" +"\n"+
                "        url='" + url + '\''+ "\n"+
                "        text='" + text +'\''+ "\n"+
                "   }";
    }
}
