/**
 * Copyright (c) 2024, ShangHai HOWBUY INVESTMENT MANAGEMENT Co., Ltd.
 * All right reserved.
 * <p>
 * THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF HOWBUY INVESTMENT
 * MANAGEMENT CO., LTD.  THE CONTENTS OF THIS FILE MAY NOT BE DISCLOSED
 * TO THIRD PARTIES, COPIED OR DUPLICATED IN ANY FORM, IN WHOLE OR IN PART,
 * WITHOUT THE PRIOR WRITTEN PERMISSION OF HOWBUY INVESTMENT MANAGEMENT
 * CO., LTD.
 */
package matching;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @description: (请在此添加描述)
 * @author chenyves
 * @date 2024/11/9 8:48 AM
 * @since JDK 1.8
 */
public class MaleMatchDTO {


    @ExcelProperty("编号")
    private String id;
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("心动女1")
    private String objOne;
    @ExcelProperty("心动女2")
    private String objTwo;
    @ExcelProperty("心动女3")
    private String objThree;
    @ExcelProperty("心动女4")
    private String objFour;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjOne() {
        return objOne;
    }

    public void setObjOne(String objOne) {
        this.objOne = objOne;
    }

    public String getObjTwo() {
        return objTwo;
    }

    public void setObjTwo(String objTwo) {
        this.objTwo = objTwo;
    }

    public String getObjThree() {
        return objThree;
    }

    public void setObjThree(String objThree) {
        this.objThree = objThree;
    }

    public String getObjFour() {
        return objFour;
    }

    public void setObjFour(String objFour) {
        this.objFour = objFour;
    }

    @Override
    public String toString() {
        return "MatchDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", objOne='" + objOne + '\'' +
                ", objTwo='" + objTwo + '\'' +
                ", objThree='" + objThree + '\'' +
                ", objFour='" + objFour + '\'' +
                '}';
    }
}