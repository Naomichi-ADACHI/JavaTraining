package shopping;

import java.util.ArrayList;
import java.util.List;

/**
 * ショップクラス
 */
public class Shop {
    private String name;    // ショップ名
    private List<Item> listItem = new ArrayList<Item>();   // 取り扱っている商品リスト

    // TODO 全部メソッドprotectedでいいよね？

    /**
     * ショップのコンストラクタ
     * ※引数なしのコンストラクタは許さない
     *
     * @param name
     */
    public Shop(String name) {
        this.name = name;
    }

    /**
     * メンバの商品リストに引数で与えられた商品を追加する
     *
     * @param item 商品リストに追加する商品
     */
    public void add(Item item) {
        listItem.add(item);
    }

    /**
     * 店名と取り扱っている商品一覧をターミナルに表示する
     */
    public void print() {
        System.out.println("========================================");
        System.out.println("いらっしゃいませ！" + name + "へようこそ。");
        System.out.println("【取扱商品】");

        // 商品名の列挙
        for (int itemIndex = 0; itemIndex < listItem.size(); itemIndex++) {
            System.out.print(itemIndex + " ");  // インデックスを表示する
            listItem.get(itemIndex).print();
        }

        System.out.println("========================================");
    }

    /**
     * 特定の商品番号の商品を返す
     * @param itemNo 取得したい商品番号
     * @return 取得した商品
     * @throws Exception ショップの商品リストに存在しない商品番号を指定すると通知される
     */
    public Item get(int itemNo) throws Exception{
        // listItem内の値でない
        if(checkItemNo(itemNo) == false){
            // TODO 別の例外を投げる
            throw new Exception("Listに登録されていない商品です");
        }

        return listItem.get(itemNo);
    }

    /**
     * 引数で与えられた商品番号が有効か判定
     * @param itemNo チェック対象の商品番号
     * @return 商品リストにある値の場合True
     */
    private boolean checkItemNo(int itemNo)
    {
        // 0 <= itemNo <= 商品リストの要素数
        return itemNo >= 0 && itemNo < listItem.size();
    }
}
