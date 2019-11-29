package cn.evan.mapper;

import cn.evan.DTO.MedicalData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class MedicalDataMapperTest {

    @Autowired
    MedicalDataMapper mapper;


    @Test
    public void batchSendMsg() {

            List<MedicalData> medicalData = mapper.selectAllUser();
            System.out.println(medicalData.size());

    }


}