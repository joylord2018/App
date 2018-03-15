package app.dao;

import app.entity.Info;

public interface InfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Info record);

    int insertSelective(Info record);

    Info selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);
}