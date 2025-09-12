package lee;

import lee.node.Node;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Yves
 * @Data 2023/8/3 下午2:02
 */
public class Main {


    public static void main(String[] args) {
        String redirectUrl = "sadasdadspdf";
        if (redirectUrl.contains(".")) {
            System.out.println(redirectUrl.substring(redirectUrl.indexOf(".")+1));
        }

//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = null;
//
//        List<Node> list= new ArrayList<>();
//        list.add(node1);
//        list.add(node2);
//        list.add(node3);
//        for (Node node : list) {
//            System.out.println(node);
//        }
//        BigDecimal a = null;
//        BigDecimal b = new BigDecimal(2);
//        System.out.println(a.add(b));
    }

    private static String transferPayYears(String payYearsInDB) {
        if (payYearsInDB.startsWith("至") && payYearsInDB.endsWith("岁")) {
            return payYearsInDB.substring(payYearsInDB.indexOf("至")+1, payYearsInDB.indexOf("岁"));
        }
        return payYearsInDB;
    }
}
