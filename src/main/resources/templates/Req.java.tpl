package #package.voReq#;

import #package.dao#.dto.#domain.className#DTO;
import com.kuaicto.spec.kits.BeanUtils;

import java.util.List;
import java.io.Serializable;
import java.util.stream.Collectors;
#fieldsImports#

/**
 * #domain.className# 请求参数模板
 *
 * =========================================
 * <p>
 * Contributors :
 * Mybatis auto generator
 */
public class #domain.className#Req implements Serializable {

#fields#

    public static #domain.className#DTO convertToDTO(#domain.className#Req req) {
        return req.convertToDTO();
    }

    public static List<#domain.className#DTO> convertToDTO(List<#domain.className#Req> reqs) {
        return reqs.stream().map(v -> v.convertToDTO()).collect(Collectors.toList());
    }

    public #domain.className#DTO convertToDTO() {
        return BeanUtils.copyProperties(this, #domain.className#DTO.class);
    }
}
