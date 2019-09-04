package ${packageName};

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shunlu.cloud.dao.BaseReadOnlyDao;
import com.shunlu.cloud.dao.cluster.${entityName}ReadOnlyDao;
import com.shunlu.cloud.entity.${entityName};
import com.shunlu.cloud.entity.${entityName}Example;
import com.shunlu.cloud.entity.form.PageForm;
import com.shunlu.cloud.entity.vo.SLPage;
import com.shunlu.cloud.service.${iClassName};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ${className} extends ${baseClassName}<${entityName}> implements ${iClassName} {

    @Autowired
    private ${entityName}ReadOnlyDao ${entityName2}ReadOnlyDao;

    @Override
    public List<${entityName}> selectByExample(${entityName}Example example) {
        return ${entityName2}ReadOnlyDao.selectByExample(example);
    }

    @Override
    public SLPage<${entityName}> selectByExample(${entityName}Example example, PageForm pageForm) {
        SLPage<${entityName}> pageList = new SLPage<>();
        List<${entityName}> list = null;
            try {
                Page<?> page = PageHelper.startPage(pageForm.getPageIndex(), pageForm.getPageSize());
                list = ${entityName2}ReadOnlyDao.selectByExample(example);
                pageList.setList(list);
                pageList.setActuaCount(list.size());
                pageList.setPageIndex(pageForm.getPageIndex());
                pageList.setPageSize(pageForm.getPageSize());
                pageList.setTotal(page.getTotal());
            } catch (Exception e) {
                logger.error("查询${entityName}失败!原因是:", e);
            }
        return pageList;
    }

    @Override
    protected BaseReadOnlyDao<${entityName}> getMapper() {
        return ${entityName2}ReadOnlyDao;
    }
}