package com.sudao.cloud.module.service.toservice;

import com.kuaicto.spec.dto.BaseSpecFields;
import com.sudao.cloud.module.service.tomodel.GeneralService;
import org.apache.commons.io.IOUtils;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.List;

@Service
public class ResourceServiceGenerator {
    private static final Yaml yaml = new Yaml();

    private static enum Type {
        Controller, Dao, DaoImpl, Service, ServiceImpl, Req, Resp, Query
    }

    public static void gen() throws Exception {
        Resource resource = new ClassPathResource("resource-service-config.yaml");
        InputStream input = resource.getInputStream();



        try {
            Config config = yaml.loadAs(input, Config.class);
            template(config);
        } finally {
            IOUtils.closeQuietly(input);
        }

        System.out.println("ResourceServiceGenerator> Done.");
    }

    private static void template(Config config) throws IOException {
        for (ConfigItem item : config.getItems()) {
            makeFromTpl(item, new File(config.getTarget()), Type.Controller);
            makeFromTpl(item, new File(config.getTarget()), Type.Dao);
            makeFromTpl(item, new File(config.getTarget()), Type.DaoImpl);
            makeFromTpl(item, new File(config.getTarget()), Type.Service);
            makeFromTpl(item, new File(config.getTarget()), Type.ServiceImpl);
            makeFromTpl(item, new File(config.getTarget()), Type.Req);
            makeFromTpl(item, new File(config.getTarget()), Type.Resp);
            makeFromTpl(item, new File(config.getTarget()), Type.Query);
        }
    }

    /**
     * @param item
     * @param rootDir
     * @param type    Controller|Service|ServiceImpl
     * @throws IOException
     */
    private static void makeFromTpl(ConfigItem item, File rootDir, Type type) throws IOException {
        Resource resource = new ClassPathResource("templates/" + type + ".java.tpl");
        InputStream inputStream = resource.getInputStream();

//        String tpl = IOUtils.toString(Loader.getResource("templates/" + type + ".java.tpl", ConfigLoader.class.getClassLoader()));
        String tpl = IOUtils.toString(inputStream, Charset.forName("UTF-8"));

        String webPkg = item.pkg + ".controller"; // web package
        String servicePkg = item.pkg + ".service"; // service package
        String reqPkg = item.pkg + ".vo.req"; // vo req package
        String respPkg = item.pkg + ".vo.resp"; // vo resp package
//        String daoPkg = item.pkg + ".dto"; // dao package
        //TODO
        String daoPkg = item.pkg + ".dao"; // dao package
        String mapperPkg = item.pkg + ".mapper";

        // #package.voReq#
        tpl = tpl.replaceAll("#package.voReq#", reqPkg);
        // #package.voResp#
        tpl = tpl.replaceAll("#package.voResp#", respPkg);
        // #package.web#
        tpl = tpl.replaceAll("#package.web#", webPkg);
        // #package.service#
        tpl = tpl.replaceAll("#package.service#", servicePkg);
        // #package.dao#
        tpl = tpl.replaceAll("#package.dao#", daoPkg);

        tpl = tpl.replaceAll("#package.mapper#", mapperPkg);
        // #uriPath#
        tpl = tpl.replaceAll("#uriPath#", item.uriPath);
        // #domain.className#
        tpl = tpl.replaceAll("#domain.className#", item.domain);
        // #domain.objName#
        tpl = tpl.replaceAll("#domain.objName#", item.domain.substring(0, 1).toLowerCase() + item.domain.substring(1));
        // #primaryKeyField#
        tpl = tpl.replaceAll("#primaryKeyField#", item.primaryKeyField);
        // #primaryKeyField.setMethod#
        tpl = tpl.replaceAll("#primaryKeyField.setMethod#", "set" + item.primaryKeyField.substring(0, 1).toUpperCase() + item.primaryKeyField.substring(1));
        // #primaryKeyField.getMethod#
        tpl = tpl.replaceAll("#primaryKeyField.getMethod#", "get" + item.primaryKeyField.substring(0, 1).toUpperCase() + item.primaryKeyField.substring(1));

        tpl = replaceFields(item, tpl);
        // write
        String pkg = null;
        if (type == Type.Controller) {
            pkg = webPkg.replace(".", "/");
        } else if (type == Type.Req || type == Type.Query) {
            pkg = reqPkg.replace('.', '/');
        } else if (type == Type.Resp) {
            pkg = respPkg.replace('.', '/');
        } else if (type == Type.Service || type == Type.ServiceImpl) {
            pkg = servicePkg.replace(".", "/");
        } else if (type == Type.Dao || type == Type.DaoImpl) {
            pkg = daoPkg.replace(".", "/");
        }

        boolean isInterface = type == Type.Service || type == Type.Dao;
        String fileName = isInterface ? "I" + item.domain + type + ".java" : item.domain + type + ".java";
        File dir = new File(rootDir, pkg);
        dir.mkdirs();

        File file = new File(dir, fileName);
        FileWriter writer = new FileWriter(file, false);
        IOUtils.write(tpl, writer);
        IOUtils.closeQuietly(writer);

        System.out.println(">\t" + file.getPath());
    }

    private static String replaceFields(ConfigItem item, String tpl) {
        CompilationUnit dtoCompilationUnit = GeneralService.dtoMap.get(item.domain + "DTO");
        String fileContext = dtoCompilationUnit.getFormattedContent();
        String fieldContext = fileContext.substring(fileContext.indexOf("Serializable {") + "Serializable {".length() + 1, fileContext.length() - 1);
        for (FullyQualifiedJavaType fullyQualifiedJavaType : dtoCompilationUnit.getImportedTypes()) {
            if(!tpl.contains(fullyQualifiedJavaType.getFullyQualifiedName())) {
                tpl = tpl.replaceAll("#fieldsImports#", "import " + fullyQualifiedJavaType.getFullyQualifiedName() + ";\r\n#fieldsImports#");
            }
        }
        tpl = tpl.replaceAll("#fieldsImports#", "");
        org.mybatis.generator.api.dom.java.Field field = ((TopLevelClass) dtoCompilationUnit).getFields().get(0);
        String getPrimaryKeyMethod = "get" + field.getName().substring(0,1).toUpperCase() + field.getName().substring(1) + "()";
        tpl = tpl.replaceAll("#getPrimaryKeyMethod#", getPrimaryKeyMethod);
        tpl = tpl.replaceAll("#fields#", fieldContext);
        return tpl;
    }
}
