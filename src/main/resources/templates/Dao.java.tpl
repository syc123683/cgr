package #package.dao#;


import com.kuaicto.framework.mybatis.model.Page;
import com.kuaicto.framework.mybatis.model.Pagination;
import #package.dao#.dto.#domain.className#DTO;
import #package.dao#.dto.#domain.className#DTOExample;
import #package.voReq#.#domain.className#Query;

import java.util.List;

/**
 * I#domain.className#Dao 接口类
 *
 * =========================================
 * <p>
 * Contributors :
 * Mybatis auto generator
 */
public interface I#domain.className#Dao {

    /**
     * 根据ID
     *
     * @return {@link #domain.className#DTO}
     */
    #domain.className#DTO getById(Long id);

    /**
     * 根据条件获得分页 Item 信息
     *
     * @param example mybatis criteria example
     * @return 具有分页功能的Page包装集合 {@link Page}, 其中囊括的Item类型 {@link #domain.className#DTO}
     */
    Page<#domain.className#DTO> findByExample(#domain.className#DTOExample example, Pagination... pagination);


    /**
     * 根据条件获得 Item 信息列表
     *
     * @param example mybatis criteria example
     * @return List {@link List<#domain.className#DTO>}
     */
    List<#domain.className#DTO> listByExample(#domain.className#DTOExample example);

    /**
     * 根据条件获得 singlet item 信息
     *
     * @param example mybatis criteria example
     * @return Item {@link #domain.className#DTO}
     */
    #domain.className#DTO getByExample(#domain.className#DTOExample example);

    /**
     * 根据条件获得 统计数值 信息
     *
     * @param example mybatis criteria example
     * @return 统计数值
     */
    Long countByExample(#domain.className#DTOExample example);


    /**
     * 根据自定义Query获得具备分页的 Item 列表
     *
     * @param query 自定义Query {@link #domain.className#Query}
     * @return 具有分页功能的Page包装集合 {@link Page}, 其中囊括的Item类型 {@link #domain.className#DTO}
     */
    Page<#domain.className#DTO> findByQuery(#domain.className#Query query);

    /**
     * 根据自定义Query获得 Item 列表
     *
     * @param query 自定义Query {@link #domain.className#Query}
     * @return List {@link List<#domain.className#DTO>}
     */
    List<#domain.className#DTO> listByQuery(#domain.className#Query query);

    /**
     * 根据自定义Query获得 统计数值
     *
     * @param query 自定义Query
     * @return 统计数值
     */
    Long countByQuery(#domain.className#Query query);

    /**
     * 创建 Item
     * *注意* 参数作为瞬时数据, 严密逻辑下, 推荐不要在之后逻辑中使用
     *
     * @param target Item {@link #domain.className#DTO}
     * @return 操作flag
     */
    boolean create(#domain.className#DTO target);

    /**
     * 创建并获得最新Item
     *
     * @param target Item {@link #domain.className#DTO}
     * @return 持久数据, 可在之后的逻辑中使用. {@link #domain.className#DTO}
     */
    #domain.className#DTO createAndGet(#domain.className#DTO target);

    /**
     * 更新 Item
     * *注意* 参数作为瞬时数据, 严密逻辑下, 推荐不要在之后逻辑中使用
     *
     * @param target Item {@link #domain.className#DTO}
     * @return 操作flag
     */
    boolean update(#domain.className#DTO target);

    /**
     * 更新 Item
     *
     * @param target Item {@link #domain.className#DTO}
     * @return 持久数据, 可在之后的逻辑中使用. {@link #domain.className#DTO}
     */
    #domain.className#DTO updateAndGet(#domain.className#DTO target);


    /**
     * 根据 Item 删除
     *
     * @param target Item {@link #domain.className#DTO}
     * @return 操作flag
     */
    boolean remove(#domain.className#DTO target);

    /**
     * 批量创建 Item
     *
     * @param targets List Item 组 {@link #domain.className#DTO}
     * @return 操作flag
     */
    boolean batchCreate(List<#domain.className#DTO> targets);

    /**
     * 批量创建 更新
     *
     * @param targets List Item 组 {@link #domain.className#DTO}
     * @return 操作flag
     */
    boolean batchUpdate(List<#domain.className#DTO> targets);

    /**
     * 批量删除 Item
     * *注意* 逻辑删除, 非物理删除
     *
     * @param targets List Item 组 {@link #domain.className#DTO}
     * @return 操作flag
     */
    boolean batchRemove(List<#domain.className#DTO> targets);
}