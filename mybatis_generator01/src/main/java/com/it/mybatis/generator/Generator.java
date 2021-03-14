package com.it.mybatis.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;

/**
 * 逆向工程
 */
public class Generator {
    public static void main(String[] args) {
        new Generator().generator();
    }

    public void generator() {
        try {
            ArrayList<String> warnings = new ArrayList<String>();
            boolean overWrite = true;
            File generatorConfig = new File("src/generatorConfig.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration configuration = cp.parseConfiguration(generatorConfig);
            DefaultShellCallback shellCallback = new DefaultShellCallback(overWrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, shellCallback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
