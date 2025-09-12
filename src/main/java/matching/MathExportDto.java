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
import lombok.Data;

/**
 * @description: (请在此添加描述)
 * @author chenyves
 * @date 2024/11/9 9:33 AM
 * @since JDK 1.8
 */
@Data
public class MathExportDto {

    @ExcelProperty("男方编号")
    private String maleId;
    @ExcelProperty("女方编号")
    private String femaleId;

    public String getMaleId() {
        return maleId;
    }

    public void setMaleId(String maleId) {
        this.maleId = maleId;
    }

    public String getFemaleId() {
        return femaleId;
    }

    public void setFemaleId(String femaleId) {
        this.femaleId = femaleId;
    }
}