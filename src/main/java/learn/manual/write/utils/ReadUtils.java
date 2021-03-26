package learn.manual.write.utils;

import com.alibaba.fastjson.JSONObject;
import sun.misc.IOUtils;

import java.io.*;
import java.util.Objects;

public class ReadUtils {
    public static JSONObject readFileToJson(File file) throws Exception {
        String jsonStr = null;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] bytes = IOUtils.readFully(inputStream, -1, true);
            jsonStr = new String(bytes);
            return JSONObject.parseObject(jsonStr);
        } finally {
            if (Objects.nonNull(inputStream)) {
                inputStream.close();
            }
        }
    }
}
