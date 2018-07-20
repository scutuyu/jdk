package com.tuyu.jdbc;

import lombok.Data;

import java.io.Serializable;

/**
 * test.`nam`的实体类
 *
 * @author tuyu
 * @date 7/20/18
 * Stay Hungry, Stay Foolish.
 */
@Data
public class CityName implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String state;
}
