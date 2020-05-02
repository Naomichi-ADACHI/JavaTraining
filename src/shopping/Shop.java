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
     * @param name
     */
    public Shop(String name){
        this.name = name;
    }

    /**
     * メンバの商品リストに引数で与えられた商品を追加する
     * @param item 商品リストに追加する商品
     */
    public void add(Item item){
        listItem.add(item);
    }

    /**
     * 店名と取り扱っている商品一覧をターミナルに表示する
     */
    public void print(){
        System.out.println("========================================");
        System.out.println("いらっしゃいませ！" + name + "へようこそ。");
        System.out.println("【取扱商品】");

        // 商品名の列挙
        for (int i = 0; i < listItem.size(); i++){
            System.out.print(i + " ");  // インデックスを表示する
            listItem.get(i).print();
        }

        System.out.println("========================================");
    }
}
