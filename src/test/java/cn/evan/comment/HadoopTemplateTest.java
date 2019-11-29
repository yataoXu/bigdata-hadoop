package cn.evan.comment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class HadoopTemplateTest {
    @Autowired
    private HadoopTemplate hadoopTemplate;


    @Test
    public void listFilesTest() {


        List<Map<String, Object>> result = hadoopTemplate.listFiles("/user/test/", null);

        result.forEach(fileMap -> {
            fileMap.forEach((key, value) -> {
                System.out.println(key + "--" + value);
            });
            System.out.println();
        });
    }

    @Test
    public void renameTest(){
        hadoopTemplate.rename("/user/test/par_tab","/user/test2/par_tab");
    }


}