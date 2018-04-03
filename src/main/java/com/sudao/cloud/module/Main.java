package com.sudao.cloud.module;

/**
 * general
 * <p>
 * Description :
 * <p>
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2017/11/15
 * @time: 下午10:06
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/11/15 下午10:06
 */
public class Main {
    /******* Fields Area *******/

    /******* Construction Area *******/
    public Main() {
    }
    /******* GetSet Area ******/

    /******* Method Area *******/

    public static void main(String[] args) {
        String a = "package com.sudao.cloud.module.category.dao.dto;\n" +
                "\n" +
                "import com.kuaicto.spec.enums.dto.EnumDeleted;\n" +
                "import com.sudao.spec.dto.BaseSpecFields;\n" +
                "import java.io.Serializable;\n" +
                "import java.util.Date;\n" +
                "\n" +
                "public class CategoryDTO extends BaseSpecFields implements Serializable {\n" +
                "    private Long categoryId;\n" +
                "\n" +
                "    private Long parentId;\n" +
                "\n" +
                "    private String name;\n" +
                "\n" +
                "    private String code;\n" +
                "\n" +
                "    private String description;\n" +
                "\n" +
                "    private String image;\n" +
                "\n" +
                "    private String keywords;\n" +
                "\n" +
                "    private Integer displayOrder;\n" +
                "\n" +
                "    private Integer version;\n" +
                "\n" +
                "    private EnumDeleted deleted;\n" +
                "\n" +
                "    private Long createUserId;\n" +
                "\n" +
                "    private String createUserName;\n" +
                "\n" +
                "    private Date createTime;\n" +
                "\n" +
                "    private Long updateUserId;\n" +
                "\n" +
                "    private String updateUserName;\n" +
                "\n" +
                "    private Date updateTime;\n" +
                "\n" +
                "    private Date lastUpdate;\n" +
                "\n" +
                "    private static final long serialVersionUID = 1L;\n" +
                "\n" +
                "    public Long getCategoryId() {\n" +
                "        return categoryId;\n" +
                "    }\n" +
                "\n" +
                "    public void setCategoryId(Long categoryId) {\n" +
                "        this.categoryId = categoryId;\n" +
                "    }\n" +
                "\n" +
                "    public Long getParentId() {\n" +
                "        return parentId;\n" +
                "    }\n" +
                "\n" +
                "    public void setParentId(Long parentId) {\n" +
                "        this.parentId = parentId;\n" +
                "    }\n" +
                "\n" +
                "    public String getName() {\n" +
                "        return name;\n" +
                "    }\n" +
                "\n" +
                "    public void setName(String name) {\n" +
                "        this.name = name == null ? null : name.trim();\n" +
                "    }\n" +
                "\n" +
                "    public String getCode() {\n" +
                "        return code;\n" +
                "    }\n" +
                "\n" +
                "    public void setCode(String code) {\n" +
                "        this.code = code == null ? null : code.trim();\n" +
                "    }\n" +
                "\n" +
                "    public String getDescription() {\n" +
                "        return description;\n" +
                "    }\n" +
                "\n" +
                "    public void setDescription(String description) {\n" +
                "        this.description = description == null ? null : description.trim();\n" +
                "    }\n" +
                "\n" +
                "    public String getImage() {\n" +
                "        return image;\n" +
                "    }\n" +
                "\n" +
                "    public void setImage(String image) {\n" +
                "        this.image = image == null ? null : image.trim();\n" +
                "    }\n" +
                "\n" +
                "    public String getKeywords() {\n" +
                "        return keywords;\n" +
                "    }\n" +
                "\n" +
                "    public void setKeywords(String keywords) {\n" +
                "        this.keywords = keywords == null ? null : keywords.trim();\n" +
                "    }\n" +
                "\n" +
                "    public Integer getDisplayOrder() {\n" +
                "        return displayOrder;\n" +
                "    }\n" +
                "\n" +
                "    public void setDisplayOrder(Integer displayOrder) {\n" +
                "        this.displayOrder = displayOrder;\n" +
                "    }\n" +
                "\n" +
                "    public Integer getVersion() {\n" +
                "        return version;\n" +
                "    }\n" +
                "\n" +
                "    public void setVersion(Integer version) {\n" +
                "        this.version = version;\n" +
                "    }\n" +
                "\n" +
                "    public EnumDeleted getDeleted() {\n" +
                "        return deleted;\n" +
                "    }\n" +
                "\n" +
                "    public void setDeleted(EnumDeleted deleted) {\n" +
                "        this.deleted = deleted;\n" +
                "    }\n" +
                "\n" +
                "    public Long getCreateUserId() {\n" +
                "        return createUserId;\n" +
                "    }\n" +
                "\n" +
                "    public void setCreateUserId(Long createUserId) {\n" +
                "        this.createUserId = createUserId;\n" +
                "    }\n" +
                "\n" +
                "    public String getCreateUserName() {\n" +
                "        return createUserName;\n" +
                "    }\n" +
                "\n" +
                "    public void setCreateUserName(String createUserName) {\n" +
                "        this.createUserName = createUserName == null ? null : createUserName.trim();\n" +
                "    }\n" +
                "\n" +
                "    public Date getCreateTime() {\n" +
                "        return createTime;\n" +
                "    }\n" +
                "\n" +
                "    public void setCreateTime(Date createTime) {\n" +
                "        this.createTime = createTime;\n" +
                "    }\n" +
                "\n" +
                "    public Long getUpdateUserId() {\n" +
                "        return updateUserId;\n" +
                "    }\n" +
                "\n" +
                "    public void setUpdateUserId(Long updateUserId) {\n" +
                "        this.updateUserId = updateUserId;\n" +
                "    }\n" +
                "\n" +
                "    public String getUpdateUserName() {\n" +
                "        return updateUserName;\n" +
                "    }\n" +
                "\n" +
                "    public void setUpdateUserName(String updateUserName) {\n" +
                "        this.updateUserName = updateUserName == null ? null : updateUserName.trim();\n" +
                "    }\n" +
                "\n" +
                "    public Date getUpdateTime() {\n" +
                "        return updateTime;\n" +
                "    }\n" +
                "\n" +
                "    public void setUpdateTime(Date updateTime) {\n" +
                "        this.updateTime = updateTime;\n" +
                "    }\n" +
                "\n" +
                "    public Date getLastUpdate() {\n" +
                "        return lastUpdate;\n" +
                "    }\n" +
                "\n" +
                "    public void setLastUpdate(Date lastUpdate) {\n" +
                "        this.lastUpdate = lastUpdate;\n" +
                "    }\n" +
                "}";

        String substring = a.substring(a.indexOf("Serializable {") + "Serializable {".length() + 1, a.length() - 1);
        System.out.println(substring);
    }


}
