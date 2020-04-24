package com.beer.grizzly.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class Vo {
    private String code;
    private String message;
    private String data;
}
