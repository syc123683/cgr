package #package.service#;


import com.kuaicto.spec.aware.IOperatorAware;
import com.kuaicto.framework.mybatis.model.Page;
import #package.voReq#.#domain.className#Query;
import #package.voReq#.#domain.className#Req;
import #package.voResp#.#domain.className#Resp;

import java.util.List;

/**
 * I#domain.className#Service 接口
 *
 * =========================================
 * <p>
 * Contributors :
 * Mybatis auto generator
 */
public interface I#domain.className#Service {

    #domain.className#Resp getById(Long id);

    Page<#domain.className#Resp> findByQuery(#domain.className#Query query);

    List<#domain.className#Resp> listByQuery(#domain.className#Query query);

    Long countByQuery(#domain.className#Query query);

    #domain.className#Resp createAndGet(#domain.className#Req req, IOperatorAware operator);

    #domain.className#Resp update(#domain.className#Req req, IOperatorAware operator);

    boolean remove(Long id, IOperatorAware operator);


}

