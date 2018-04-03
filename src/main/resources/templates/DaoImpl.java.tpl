package #package.dao#;

import com.kuaicto.framework.mybatis.dao.BaseDao;
import com.kuaicto.framework.mybatis.model.Page;
import com.kuaicto.framework.mybatis.model.Pagination;
import com.kuaicto.framework.mybatis.enums.EnumOrder;
import #package.dao#.dto.#domain.className#DTO;
import #package.dao#.dto.#domain.className#DTOExample;
import #package.dao#.mapper.#domain.className#DTOMapper;
import #package.voReq#.#domain.className#Query;
import com.kuaicto.spec.enums.dto.EnumDeleted;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * I#domain.className#Dao 实现类
 *
 * =========================================
 * <p>
 * Contributors :
 * Mybatis auto generator
 */
@Service
public class #domain.className#DaoImpl extends BaseDao implements I#domain.className#Dao {
    /******* Fields Area *******/
    private #domain.className#DTOMapper #domain.objName#DTOMapper;

    /******* Construction Area *******/
    public #domain.className#DaoImpl(@Autowired #domain.className#DTOMapper #domain.objName#DTOMapper) {
        this.#domain.objName#DTOMapper = #domain.objName#DTOMapper;
    }

    @Override
    public #domain.className#DTO getById(Long id) {
        return this.#domain.objName#DTOMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<#domain.className#DTO> findByExample(#domain.className#DTOExample example, Pagination... paginationParam) {
        Pagination pagination = paginationParam == null || paginationParam.length == 0 ? new Pagination() : paginationParam[0];
        Page<#domain.className#DTO> page = new Page<#domain.className#DTO>(pagination);
        this.loadDefaultOrder(example);
        long total = this.#domain.objName#DTOMapper.countByExample(example);
        page.setTotal(total);
        if (total > page.getOffset()) {
            example.limit(page.getOffset(), page.getLimit());
            List<#domain.className#DTO> targets = this.#domain.objName#DTOMapper.selectByExample(example);
            page.setItems(targets);
        }
        return page;
    }


    @Override
    public List<#domain.className#DTO> listByExample(#domain.className#DTOExample example) {
        this.loadDefaultOrder(example);
        return this.#domain.objName#DTOMapper.selectByExample(example);
    }

    @Override
    public #domain.className#DTO getByExample(#domain.className#DTOExample example) {
        #domain.className#DTO target = null;
        this.loadDefaultOrder(example);
        List<#domain.className#DTO> targets = this.#domain.objName#DTOMapper.selectByExample(example);
        if (targets.size() > 0) {
            target = targets.get(0);
        }
        return target;
    }

    @Override
    public Long countByExample(#domain.className#DTOExample example) {
        this.loadDefaultOrder(example);
        return this.#domain.objName#DTOMapper.countByExample(example);
    }

    @Override
    public Page<#domain.className#DTO> findByQuery(#domain.className#Query query) {
        Page<#domain.className#DTO> page = new Page<>(query);
        #domain.className#DTOExample example = this.buildQueryExample(query);

        this.loadDefaultOrder(example);
        long total = this.#domain.objName#DTOMapper.countByExample(example);
        page.setTotal(total);
        if (total > page.getOffset()) {
            example.limit(page.getOffset(), page.getLimit());
            List<#domain.className#DTO> targets = this.#domain.objName#DTOMapper.selectByExample(example);
            page.setItems(targets);
        }
        return page;
    }

    @Override
    public List<#domain.className#DTO> listByQuery(#domain.className#Query query) {
        #domain.className#DTOExample example = this.buildQueryExample(query);
        return this.#domain.objName#DTOMapper.selectByExample(example);
    }


    @Override
    public Long countByQuery(#domain.className#Query query) {
        #domain.className#DTOExample example = this.buildQueryExample(query);
        return this.#domain.objName#DTOMapper.countByExample(example);
    }

    @Override
    public boolean create(#domain.className#DTO target) {
        return this.#domain.objName#DTOMapper.insertSelective(target) > 0;
    }


    @Override
    public #domain.className#DTO createAndGet(#domain.className#DTO target) {
        #domain.className#DTO result = null;
        if (this.create(target)) {
            result = this.getById(target.#getPrimaryKeyMethod#);
        }
        return result;
    }

    @Override
    public boolean update(#domain.className#DTO target) {
        target.setUpdateTime(new Date());
        return this.#domain.objName#DTOMapper.updateByPrimaryKeySelective(target) > 0;
    }

    @Override
    public #domain.className#DTO updateAndGet(#domain.className#DTO target) {
        #domain.className#DTO result = null;
        if (this.update(target)) {
            result = this.getById(target.#getPrimaryKeyMethod#);
        }
        return result;
    }

    @Override
    public boolean remove(#domain.className#DTO target) {
        target.setDeleted(EnumDeleted.DELETED);
        return this.update(target);
    }

    @Override
    public boolean batchCreate(List<#domain.className#DTO> targets) {
        boolean batchFlag = targets.stream().map(this::create).filter(v -> !v).count() > 0;
        return batchFlag;
    }

    @Override
    public boolean batchUpdate(List<#domain.className#DTO> targets) {
        boolean batchFlag = targets.stream().map(this::update).filter(v -> !v).count() > 0;
        return batchFlag;
    }

    @Override
    public boolean batchRemove(List<#domain.className#DTO> targets) {
        boolean batchFlag = targets.stream().map(this::remove).filter(v -> !v).count() > 0;
        return batchFlag;
    }

    private void loadDefaultOrder(#domain.className#DTOExample example) {
        if (StringUtil.isEmpty(example.getOrderByClause())) {
            String orderBySql = "create_time" + " " + EnumOrder.DESC.getCode();
            example.setOrderByClause(orderBySql);
        }
    }

    private #domain.className#DTOExample buildQueryExample(#domain.className#Query query) {
        #domain.className#DTOExample example = new #domain.className#DTOExample();
        #domain.className#DTOExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(EnumDeleted.NORMAL);
        String orderByField = StringUtil.isEmpty(query.getDbSortColumn()) ? "create_time" : query.getDbSortColumn();
        String orderBySql = orderByField + " " + query.getSortOrder().getCode();
        example.setOrderByClause(orderBySql);
        example.limit(query.getOffset(), query.getLimit());
        return example;
    }


}
