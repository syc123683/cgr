package #package.voResp#;

import #package.dao#.dto.#domain.className#DTO;
import com.kuaicto.spec.dto.BaseSpecFields;
import com.kuaicto.spec.kits.BeanUtils;
import java.util.stream.Collectors;
#fieldsImports#

import java.util.List;

/**
 * #domain.className# 相应参数模板
 *
 * =========================================
 * <p>
 * Contributors :
 * Mybatis auto generator
 */
public class #domain.className#Resp extends BaseSpecFields implements Serializable {

#fields#

    public static #domain.className#Resp parseSinglet(#domain.className#DTO target) {
        #domain.className#Resp self = new #domain.className#Resp();
        return self.parse(target);
    }

    public static List<#domain.className#Resp> parseList(List<#domain.className#DTO> targets) {
        return targets.stream().map(#domain.className#Resp::parseSinglet).collect(Collectors.toList());
    }

    public #domain.className#Resp parse(#domain.className#DTO target) {
        if(target == null) {
            return null;
        }
        BeanUtils.copyProperties(target, this);
        return this;
    }

    public static #domain.className#DTO convertToDTO(#domain.className#Resp resp) {
        return resp.convertToDTO();
    }

    public static List<#domain.className#DTO> convertToDTO(List<#domain.className#Resp> resps) {
        return resps.stream().map(v -> v.convertToDTO()).collect(Collectors.toList());
    }

    public #domain.className#DTO convertToDTO() {
        return BeanUtils.copyProperties(this, #domain.className#DTO.class);
    }
}
