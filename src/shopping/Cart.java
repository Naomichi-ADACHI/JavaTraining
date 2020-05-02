package shopping;

import java.util.ArrayList;
import java.util.List;

/**
 * ショッピングカートクラス
 */
public class Cart {
    private List<Item> listItem = new ArrayList<>();    // カート内の商品リスト

    /**
     * カートに商品を追加する
     *
     * @param item 追加する商品
     */
    public void add(Item item) {
        listItem.add(item);
    }

    /**
     * カート内の商品リストをターミナルに表示する
     */
    public void print() {
        System.out.println("【カート内の商品】");

        if (listItem.isEmpty()) {
            // カートが空の場合
            System.out.println("カートに商品が入っていません。");
        } else {
            // カートが空でない場合、カートに入っている商品の値段を列挙
            for (int itemIndex = 0; itemIndex < listItem.size(); itemIndex++) {
                // インデックスの表示
                System.out.print(itemIndex + " ");

                // 商品個別の値段を表示
                listItem.get(itemIndex).print();
            }

            // カートの合計金額を表示
            System.out.println("カート内の商品の合計価格 : " + getTotalPrice() + " 円");
        }
    }

    /**
     * カートの合計金額を返す
     * @return
     */
    public int getTotalPrice() {
        int sum = 0;

        // 合計金額を足していく
        for (Item item:
             listItem) {
            sum += item.getPrice();
        }

        return sum;
    }
}
