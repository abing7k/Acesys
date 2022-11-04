package com.example.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @PROJECT_NAME: Acesys
 * @DESCRIPTION:
 * @USER: 韩冰
 * @DATE: 2022/11/4 0004 16:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buy {
    private Integer uid;
    private Integer pid;
    private Float weight;
}
