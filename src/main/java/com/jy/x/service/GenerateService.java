package com.jy.x.service;

import com.jy.x.chain.GenerateChain;
import com.jy.x.chain.GenerateChainContext;
import com.jy.x.common.Chain;
import com.jy.x.entity.GenPara;
import com.jy.x.entity.ReqPara;
import com.jy.x.factory.GenConfiguration;
import com.jy.x.factory.GenConfigurationFactory;
import com.jy.x.strategy.specific.*;
import com.jy.x.utils.StringUtil;
import com.jy.x.utils.ZipUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.jy.x.common.Constant.*;

/**
 * @program: GenerateLubaba
 * @author: Jy
 * @create: 2019-08-02 15:33
 **/
@Slf4j
@Service
public class GenerateService {

    /**
     * 组装参数 传入表名对应的实体类名 开始生成
     *
     * @param entityName
     * @return String
     * @author: Jy  2019/8/2 16:46
     */
    public String genService(String entityName) {

        //初始化责任链
        GenerateChain generateChain = GenerateChainContext.getGenerateChain();
        String newEntityName = StringUtil.remove_(entityName.split("_"));

        GenPara genPara = new GenPara();
        genPara.setEntityName(newEntityName);
        List<String> fileNameList = new ArrayList<>();
        GenConfiguration configuration = new GenConfigurationFactory().getConfiguration(CONFIGURATION);

        genPara.setFreemarkerGenStrategy(new GenerateReadOnlyStrategy());
        fileNameList.add(generateChain.generateChain(Chain.READONLY.getIndex(), genPara, configuration));

        genPara.setFreemarkerGenStrategy(new GenerateReadOnlyImplStrategy());
        fileNameList.add(generateChain.generateChain(Chain.READONLYIMPL.getIndex(), genPara, configuration));

        genPara.setFreemarkerGenStrategy(new GenerateInterfaceStrategy());
        fileNameList.add(generateChain.generateChain(Chain.INTERFACE.getIndex(), genPara, configuration));

        genPara.setFreemarkerGenStrategy(new GenerateInterfaceImplStrategy());
        fileNameList.add(generateChain.generateChain(Chain.INTERFACEIMPL.getIndex(), genPara, configuration));

        //删除被打包过的文件
        return deleteFile(StringUtil.removeFirstName(newEntityName), ZIP_SYFFIX);
    }


    /**
     * 生成文件
     *
     * @param list    表参数
     * @param reqPara 请求参数
     * @return java.lang.String
     * @author: Jy  2019/8/12 13:56
     */
    public String genService(List<Map<String, Object>> list, ReqPara reqPara) {
        //初始化责任链
        GenerateChain generateChain = GenerateChainContext.getGenerateChain();

        GenPara genPara = new GenPara();
        genPara.setPackageName(reqPara.getPackageName());
        genPara.setTypeList(list);
        genPara.setClassName((String) list.get(0).get("tableName"));
        List<String> fileNameList = new ArrayList<>();

        GenConfiguration configuration = new GenConfigurationFactory().getConfiguration(CONFIGURATION);

        genPara.setFreemarkerGenStrategy(new GenerateEntityGetSetStrategy());
        fileNameList.add(generateChain.generateChain(Chain.ENTITYGETSET.getIndex(), genPara, configuration));

        return deleteFile(genPara.getClassName(), ZIP_SYFFIX);
    }

    /**
     * 打包zip并删除源文件
     *
     * @param className
     * @param zipName
     * @return java.lang.String
     * @author: Jy  2019/8/22 9:52
     */
    private String deleteFile(String className, String zipName) {
        File file = null;
        String fileName = className + zipName;
        try {
            file = new ClassPathResource("/templates").getFile();
            ZipUtil.zip(file.getAbsolutePath() + "/" + fileName, file.getAbsolutePath());
            log.info("打包ZIP文件完成:{}", fileName);
            ZipUtil.deleteGenFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    /**
     * 开始下载流
     *
     * @param response
     * @param fileName
     * @return void
     * @author: Jy  2019/8/13 17:35
     */
    public void download(HttpServletResponse response, String fileName) {
        FileInputStream fis = null;
        File file = null;
        InputStream is = null;
        try {
            file = new File(new ClassPathResource("/templates").getFile() + "/" + fileName);
            fis = new FileInputStream(file);
            is = new BufferedInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] buffer = null;
        try {
            buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            response.reset();
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Content-Length", "" + file.length());
            OutputStream os = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            os.write(buffer);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
