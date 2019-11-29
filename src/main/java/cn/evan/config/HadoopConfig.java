package cn.evan.config;

import cn.evan.comment.HadoopTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Description
 * @ClassName HadoopConfig
 * @Author Evan
 * @date 2019.11.07 15:12
 */
@Configuration
@ConditionalOnProperty(name = "hadoop.name-node")
@Slf4j
public class HadoopConfig {

    @Value("${hadoop.name-node}")
    private String nameNode;

    @Value("${hadoop.namespace:}")
    private String nameSpace;

    /**
     * Configuration conf=new Configuration（）；
     * 创建一个Configuration对象时，其构造方法会默认加载hadoop中的两个配置文件，
     * 分别是hdfs-site.xml以及core-site.xml，这两个文件中会有访问hdfs所需的参数值，
     * 主要是fs.default.name，指定了hdfs的地址，有了这个地址客户端就可以通过这个地址访问hdfs了。
     * 即可理解为configuration就是hadoop中的配置信息。
     *
     * @return
     */
    @Bean("fileSystem")
    public HadoopTemplate getFileSystem() {

        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();

        String defaultHdfsUri = null;
        if (StringUtils.isNotBlank(nameNode)) {
            defaultHdfsUri = nameNode + nameSpace;
        }
        conf.set("fs.defaultFS", defaultHdfsUri);
        return new HadoopTemplate(conf, defaultHdfsUri);

    }
}
