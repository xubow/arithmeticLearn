/**
 * Copyright (c) 2023, ShangHai HOWBUY INVESTMENT MANAGEMENT Co., Ltd.
 * All right reserved.
 * <p>
 * THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF HOWBUY INVESTMENT
 * MANAGEMENT CO., LTD.  THE CONTENTS OF THIS FILE MAY NOT BE DISCLOSED
 * TO THIRD PARTIES, COPIED OR DUPLICATED IN ANY FORM, IN WHOLE OR IN PART,
 * WITHOUT THE PRIOR WRITTEN PERMISSION OF HOWBUY INVESTMENT MANAGEMENT
 * CO., LTD.
 */
package spring.obj2obj;

import java.util.Collections;

/**
 * @description: (请在此添加描述)
 * @author chenyves
 * @date 2023/11/23 9:22 AM
 * @since JDK 1.8
 */
public class Main {

    public static void main(String[] args) {
        UserDO user = new UserDO();
        user.setAge(1);
        user.setName("zhangsan");
        user.setMale(true);
        Product product = new Product();
        product.setpName("test pro");
        user.setProductList(Collections.singletonList(product));
        User userDO = UserTransformMapper.INSTANCE.do2User(user, product);
        System.out.println(userDO);
    }

}