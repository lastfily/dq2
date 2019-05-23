package com.yt.dql.mapper;

import com.yt.dql.model.Classes;

public interface ClassMapper {

    Classes selectByPrimaryKey(Integer cId);

}