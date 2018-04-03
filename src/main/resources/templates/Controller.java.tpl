package #package.web#;

import com.kuaicto.framework.controller.BasicController;
import com.kuaicto.framework.controller.RestPrototypeController;
import com.kuaicto.spec.aware.IOperatorAware;
import com.kuaicto.framework.mybatis.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import #package.voReq#.#domain.className#Query;
import #package.voReq#.#domain.className#Req;
import #package.voResp#.#domain.className#Resp;
import #package.service#.I#domain.className#Service;
import com.kuaicto.framework.exception.APIException;

/**
 * smart-mybatis-spring-boot-starter
 * <p>
 * Description :
 * <p>
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2017/11/15
 * @time: 下午1:27
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/11/15 下午1:27
 */
@RestPrototypeController
@RequestMapping("#uriPath#")
public class #domain.className#Controller extends BasicController {
    /******* Fields Area *******/

    @Autowired
    private I#domain.className#Service #domain.objName#Service;

    /******* Construction Area *******/
    /******* GetSet Area ******/


    @GetMapping("/{id}")
    public #domain.className#Resp get(@PathVariable("id") Long id) {
        #domain.className#Resp target = this.#domain.objName#Service.getById(id);
        return target;
    }

    @GetMapping("")
    public Page<#domain.className#Resp> find(#domain.className#Query query) {
        Page<#domain.className#Resp> target = this.#domain.objName#Service.findByQuery(query);
        return target;
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Long id) throws APIException{
        this.#domain.objName#Service.remove(id, super.getSessionUserFromGateway());
    }

    /******* Method Area *******/


}

