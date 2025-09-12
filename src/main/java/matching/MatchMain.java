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

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import javafx.util.Pair;
import org.apache.commons.collections4.CollectionUtils;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 * @description: (请在此添加描述)
 * @author chenyves
 * @date 2024/11/9 8:44 AM
 * @since JDK 1.8
 */
public class MatchMain {

    private  static  Map<String, List<String>> males = new HashMap<>();
    private static List<Pair<String, String>> pairs = new ArrayList<>();

    public static int test() {
        try {
            return 1/0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    public static void main(String[] args) {
        System.out.println(test());



//        System.out.println(new BigDecimal("0" ).divide(new BigDecimal("0"), 2, RoundingMode.HALF_UP));


        //        System.out.println("20241101".compareTo("20241102"));
//        String file = "/Users/chenyves/Desktop/互选表.xlsx";
//        readMaleSheet(file);
////        System.out.println(males);
//        readFemaleSheetAndBuildMaps(file);
//
//        List<MathExportDto> exportList = new ArrayList<>();
//        for (Pair pair : pairs) {
//            MathExportDto dto = new MathExportDto();
//            dto.setMaleId(pair.getKey().toString());
//            dto.setFemaleId(pair.getValue().toString());
//            exportList.add(dto);
//        }
//        EasyExcel.write("/Users/chenyves/Desktop/匹配.xlsx", MathExportDto.class).sheet().doWrite(exportList);
//        System.out.println(pairs);

    }

    private static void readFemaleSheetAndBuildMaps(String file) {
        EasyExcel.read(new File(file), FemaleMatchDTO.class, new AnalysisEventListener<FemaleMatchDTO>() {
            @Override
            public void invoke(FemaleMatchDTO matchDTO, AnalysisContext analysisContext) {
                matchDTO.getLileList().stream().filter(StringUtils::isNotEmpty)
                        .forEach(maleId -> {
                            List<String> maleLikes = males.get(maleId);
                            if (CollectionUtils.isNotEmpty(maleLikes)) {
                                if (maleLikes.contains(matchDTO.getId())) {
                                    Pair<String, String> pair = new Pair<>(maleId, matchDTO.getId());
                                    pairs.add(pair);
                                }
                            }
                        });
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).sheet("女生").doRead();
    }

    private static void readMaleSheet(String fileName) {
        EasyExcel.read(new File(fileName), MaleMatchDTO.class, new AnalysisEventListener<MaleMatchDTO>() {
            @Override
            public void invoke(MaleMatchDTO matchDTO, AnalysisContext analysisContext) {
                //add to map
                if (StringUtils.isNotEmpty(matchDTO.getId())) {
                    List<String> likeList = new ArrayList<>();
                    if (StringUtils.isNotEmpty(matchDTO.getObjOne())) {
                        likeList.add(matchDTO.getObjOne());
                    }
                    if (StringUtils.isNotEmpty(matchDTO.getObjTwo())) {
                        likeList.add(matchDTO.getObjTwo());
                    }
                    if (StringUtils.isNotEmpty(matchDTO.getObjThree())) {
                        likeList.add(matchDTO.getObjThree());
                    }
                    if (StringUtils.isNotEmpty(matchDTO.getObjFour())) {
                        likeList.add(matchDTO.getObjFour());
                    }
                    males.put(matchDTO.getId(), likeList);
                }
//                System.out.println(matchDTO);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).sheet("男生").doRead();
    }


}