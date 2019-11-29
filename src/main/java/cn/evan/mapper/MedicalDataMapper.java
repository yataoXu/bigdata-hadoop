package cn.evan.mapper;


import cn.evan.DTO.MedicalData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MedicalDataMapper {

    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    @Select("SELECT * FROM medical_data")
    List<MedicalData> selectAllUser();
}
