package heap;


import com.sun.tools.javac.util.Pair;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author chenyves
 * @description: (超市卖货)
 * https://oj.haizeix.com/problem/284
 * 超市里有N个商品. 第i个商品必须在保质期(第di天)之前卖掉, 若卖掉可让超市获得pi的利润.
 * 每天只能卖一个商品. 现在你要让超市获得最大的利润.
 * @date 2025/8/5 21:54
 * @since JDK 1.8
 */
public class SellProducts {

    /**
     *
     *          1.对商品按照过期天数排序
     *          2. 维护一个最优商品集合  新商品是否能进入这个最后集合，需要进行如下判断 {
     *                 a. 如果新商品的过期天数 > 集合中的最大天数 {
     *                       直接放入集合中，因为可以在后面几天再销售该商品
     *                   }
     *                 b. 如果新商品的过期天数 = 集合中的最大天数 {
     *                       从集合中找出利润最小的那个商品 进行替换。（** 新商品可售卖的日期可以提前）
     *                   }
     *                 c。 如果新商品过期天数 < 集合中最大天数( 该情况不存在，因为第一步已经将所有商品按照过期天数排序了)
     *           }
     * @param pairs pair(k-过期天数, v-利润)
     * @return
     */
    public int maxProfit(List<Pair> pairs) {
        pairs.sort(Comparator.comparingInt(o -> (int) o.fst));

        // 因为需要找到集合中利润最小的以及后续要替换操作 所以可以用小根堆
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(o -> (int) o.fst));
        for (int i = 0; i < pairs.size(); i++) {
            Pair product = pairs.get(i);
            // i当作商品编号
            if ((int)product.fst > queue.size()) {
                queue.add(new Pair(product.snd, i));
            } else if ((int)product.fst == queue.size()){
                queue.add(new Pair(product.snd, i));
                queue.poll();
            }
        }

        // 对最优集合进行利润相加
        int ans=0;
        while (!queue.isEmpty()) {
            ans += (int)queue.poll().fst;
        }
        return ans;
    }
}