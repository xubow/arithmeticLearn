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

/**
 * @description: (请在此添加描述)
 * @author chenyves
 * @date 2023/11/23 9:33 AM
 * @since JDK 1.8
 */
public class Product {

    private String pName;

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pName='" + pName + '\'' +
                '}';
    }
}