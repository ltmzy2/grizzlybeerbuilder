package ${packageName};

import com.shunlu.cloud.dao.BaseDao;
import com.shunlu.cloud.dao.master.${entityName}Dao;
import com.shunlu.cloud.entity.${entityName};
import com.shunlu.cloud.service.${iClassName};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ${className} extends ${baseClassName}<${entityName}> implements ${iClassName} {

    @Autowired
    private ${entityName}Dao ${entityName2}Dao;

    @Override
    protected BaseDao<${entityName}> getMapper() {
        return ${entityName2}Dao;
    }
}