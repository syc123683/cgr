package com.sudao.cloud.module.commons.enums;

/**
 * general
 * <p>
 * Description :
 * <p>
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2017/10/31
 * @time: 上午11:19
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/10/31 上午11:19
 */
public enum EnumActiveStatus {
    /******* Fields Area *******/

    ACTIVE("ACTIVE", "活跃"),
    INACTIVE("INACTIVE", "非活跃");

    private String code;
    private String title;

    /******* Construction Area *******/
    EnumActiveStatus(String code, String title) {
        this.code = code;
        this.title = title;
    }
    /******* GetSet Area ******/

    /******* Method Area *******/


}
