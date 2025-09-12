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

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @description: (请在此添加描述)
 * @author chenyves
 * @date 2023/11/23 9:24 AM
 * @since JDK 1.8
 */
@Mapper
public interface UserTransformMapper {

    UserTransformMapper INSTANCE = Mappers.getMapper(UserTransformMapper.class);

    UserDO user2DO(User user);

    User do2User(UserDO userDO, Product product);
}