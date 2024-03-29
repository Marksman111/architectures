package generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wei Laibao
 * @date 2019/5/17 11:54
 * @description Mybatis Generator 生成代码请运行这个类
 **/
public class Generator {
    public static void main(String[] args) throws Exception {

        // 执行过程中的警告信息
        List<String> warnings = new ArrayList<String>();

        // 当生成的代码重复时，覆盖原代码
        boolean overwrite = true;

        // 读取配置文件
        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);

        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);

        // 执行生成代码
        myBatisGenerator.generate(null);

        // 输出警告信息
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
