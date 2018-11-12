/*
 * Copyright (c) 2018. zhangbohan.dell@gmail.com ,All Rights Reserved
 *
 */

package xyz.zhangbohan.eurekaclient.model.entity;

import lombok.*;

/**
 * file encoding: utf-8
 * Function :
 * Create : 2018/10/15 15:36
 *
 * @author : zhangbohan.dell@gmail.com
 * @version : 1.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String name;
    private Integer age;
}
