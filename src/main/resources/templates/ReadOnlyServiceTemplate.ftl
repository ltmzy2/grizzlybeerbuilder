package ${packageName};

import com.shunlu.cloud.entity.${entityName};
import com.shunlu.cloud.entity.${entityName}Example;
import com.shunlu.cloud.entity.form.PageForm;
import com.shunlu.cloud.entity.vo.SLPage;

public interface ${className} extends ${baseClassName}<${entityName}> {

    List<${entityName}> selectByExample(${entityName}Example example);

    SLPage<${entityName}> selectByExample(${entityName}Example example,PageForm pageForm);

}