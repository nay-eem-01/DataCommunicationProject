package com.example.datacomproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataComForm {
    private String operation;
    private String input1;
    private String input2;
    private String result;

}
