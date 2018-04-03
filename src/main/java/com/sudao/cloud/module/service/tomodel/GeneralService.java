package com.sudao.cloud.module.service.tomodel;

import com.kuaicto.spec.dto.BaseSpecFields;
import com.mysql.jdbc.Driver;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Spector on 2017/6/7.
 */
@Service
public class GeneralService {

    private static final Logger logger = LoggerFactory.getLogger(GeneralService.class);

    public static Map<String, CompilationUnit> dtoMap = new HashMap<>();

    public void generalCode() {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;

        File configFile = null;

        try {
            configFile = ResourceUtils.getFile("classpath:mybatis.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ConfigurationParser cp = new ConfigurationParser(warnings);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        Configuration config = null;
        try {
            String driverPath = getDriverJarPath();

            config = cp.parseConfiguration(configFile);
            config.addClasspathEntry(driverPath);

            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);


            myBatisGenerator.generate(null);
            buildFieldC(myBatisGenerator);


            logger.info("table生成model成功!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void buildFieldC(MyBatisGenerator myBatisGenerator) {
        Field[] declaredFields = BaseSpecFields.class.getDeclaredFields();
        Method[] declaredMethods = BaseSpecFields.class.getMethods();

        List<CompilationUnit> dtos = myBatisGenerator.getGeneratedJavaFiles().stream().filter(v -> v.getCompilationUnit().getSuperClass() != null && v.getCompilationUnit().getSuperClass().getShortName().equalsIgnoreCase("BaseDTO")).map(v -> v.getCompilationUnit()).collect(Collectors.toList());
        try {
            for (CompilationUnit dto : dtos) {
                String domain = dto.getType().getShortName();
                TopLevelClass topLevelClass = (TopLevelClass) dto;
                Field field = InnerClass.class.getDeclaredField("fields");
                field.setAccessible(true);
                Field method = InnerClass.class.getDeclaredField("methods");
                method.setAccessible(true);

                List<org.mybatis.generator.api.dom.java.Field> customFields = topLevelClass.getFields().stream().filter(v -> {
                    return Arrays.stream(declaredFields).filter(b -> b.getName().equalsIgnoreCase(v.getName())).count() == 0;
                }).collect(Collectors.toList());
                List<org.mybatis.generator.api.dom.java.Method> customMethods = topLevelClass.getMethods().stream().filter(v -> {
                    return Arrays.stream(declaredMethods).filter(b -> b.getName().equalsIgnoreCase(v.getName())).count() == 0;
                }).collect(Collectors.toList());
                field.set(dto, customFields);
                method.set(dto, customMethods);

                dtoMap.put(domain, dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String getDriverJarPath() {
        String driverPath = Driver.class.getResource("").getPath();
        driverPath = driverPath.substring(driverPath.indexOf("file:") + 5, driverPath.indexOf("!"));
        return driverPath;
    }
}
