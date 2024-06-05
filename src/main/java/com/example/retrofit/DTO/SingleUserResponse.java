package com.example.retrofit.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SingleUserResponse extends DefaultDTO{
    private Data data;
    private Support support;

    @Override
    public String toString() {
        return "SingleUserResponse {" + "\n" +
                "   data:" +"\n" + data + "\n" +
                "   support:" +"\n" + support + "\n" +
                '}';
    }
}
