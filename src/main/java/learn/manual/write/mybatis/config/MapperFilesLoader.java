package learn.manual.write.mybatis.config;

import com.alibaba.fastjson.JSONObject;
import learn.manual.write.utils.ReadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
@Slf4j
public class MapperFilesLoader implements InitializingBean {

    @Value("${mybatis.mappers}")
    private String mapperFilesDir;

    private final Map<String, JSONObject> mapperInfoMap = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        //读取application.properties配置文件目录
        File fileDirectories = ResourceUtils.getFile(mapperFilesDir);
        if (!fileDirectories.exists()) {
            log.info("mybatis文件未配置");
            return;
        }
        //将mybatis目录下的mapper配置文件加载到内存
        File[] files = fileDirectories.listFiles();
        if (Objects.isNull(files) || files.length == 0) {
            log.info("mybatis文件未配置");
            return;
        }
        for (File file : files) {
            JSONObject mapperInfo = null;
            try {
                mapperInfo = ReadUtils.readFileToJson(file);
            } catch (Exception e) {
                log.error("mybatis文件配置错误", e);
                return;
            }
            String namespace = mapperInfo.getString("namespace");
            if (mapperInfoMap.containsKey(namespace)) {
                log.info("mybatis mapper文件姓名空间重复:{}", namespace);
                return;
            }
            mapperInfoMap.put(namespace, mapperInfo);
        }
    }


}
