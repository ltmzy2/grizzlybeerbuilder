package ${packageName};

import java.io.Serializable;

public class ${className} implements Serializable {

    private static final long serialVersionUID = 1L;

    <#list typeList as item>
    private ${item["type"]}  ${item["name"]};
    </#list>

    <#list typeList as item>
    public ${item["type"]} get${item["name"]?cap_first}() {
        return ${item["name"]};
    }
    </#list>

    <#list typeList as item>
    public ${className} set${item["name"]?cap_first}(${item["type"]} ${item["name"]}) {
        this.${item["name"]} = ${item["name"]};
        return this;
    }
    </#list>

}