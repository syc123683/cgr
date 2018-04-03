package #package.service#;

import com.kuaicto.spec.aware.IOperatorAware;
import com.kuaicto.framework.mybatis.model.Page;
import #package.dao#.I#domain.className#Dao;
import #package.dao#.dto.#domain.className#DTO;
import #package.voReq#.#domain.className#Query;
import #package.voReq#.#domain.className#Req;
import #package.voResp#.#domain.className#Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * I#domain.className#Service 实现类
 *
 * =========================================
 * <p>
 * Contributors :
 * Mybatis auto generator
 */
@Service
public class #domain.className#ServiceImpl implements I#domain.className#Service {
    /******* Fields Area *******/

    private I#domain.className#Dao #domain.objName#Dao;

    /******* Construction Area *******/
    public #domain.className#ServiceImpl(@Autowired I#domain.className#Dao #domain.objName#Dao) {
        this.#domain.objName#Dao = #domain.objName#Dao;
    }

    @Override
    public #domain.className#Resp getById(Long id) {
        #domain.className#DTO target = this.#domain.objName#Dao.getById(id);
        return #domain.className#Resp.parseSinglet(target);
    }



    @Override
    public Page<#domain.className#Resp> findByQuery(#domain.className#Query query) {
        Page<#domain.className#DTO> targetPage = this.#domain.objName#Dao.findByQuery(query);
        Page<#domain.className#Resp> page = new Page<>(targetPage);
        page.setItems(#domain.className#Resp.parseList(targetPage.getItems()));
        return page;
    }

    @Override
    public List<#domain.className#Resp> listByQuery(#domain.className#Query query) {
        List<#domain.className#DTO> targets = this.#domain.objName#Dao.listByQuery(query);
        return #domain.className#Resp.parseList(targets);
    }

    @Override
    public Long countByQuery(#domain.className#Query query) {
        return this.#domain.objName#Dao.countByQuery(query);
    }

    @Override
    public #domain.className#Resp createAndGet(#domain.className#Req req, IOperatorAware operator) {
        #domain.className#DTO target = req.convertToDTO();
        target.setOperator(operator, true);
        target = this.#domain.objName#Dao.createAndGet(target);
        return #domain.className#Resp.parseSinglet(target);
    }

    @Override
    public #domain.className#Resp update(#domain.className#Req req, IOperatorAware operator) {
        #domain.className#DTO target = req.convertToDTO();
        target.setOperator(operator, false);
        target = this.#domain.objName#Dao.updateAndGet(target);
        return #domain.className#Resp.parseSinglet(target);
    }

    @Override
    public boolean remove(Long id, IOperatorAware operator) {
        #domain.className#DTO target = this.#domain.objName#Dao.getById(id);
        target.setOperator(operator, false);
        return this.#domain.objName#Dao.remove(target);
    }
    /******* GetSet Area ******/

    /******* Method Area *******/


}
