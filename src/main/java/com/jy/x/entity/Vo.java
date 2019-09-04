package com.jy.x.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: x
 * @author: Jy
 * @create: 2019-08-14 14:51
 **/
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class Vo {
    private String code;
    private String message;
    private String data;
}
