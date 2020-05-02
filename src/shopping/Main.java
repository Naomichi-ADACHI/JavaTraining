package shopping;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static final String SHOP_NAME = "カーショップ ジョイ";    // ショップ名
    static final String CUSTOMER_NAME = "●●";   // 顧客名

    public static void main(String[] args) {
	    // 商品を作る
        List<Item> itemList = makeItem();

        // 商品を取り扱うショップを作る
        // TODO 店がひとつだけならstaticでよくね
        Shop shop = new Shop(SHOP_NAME);

        // 作った商品をショップに登録する
        registerItem(itemList, shop);

        shop.print();

        // 顧客を作る
        Customer customer = new Customer(CUSTOMER_NAME);

        // 顧客を表示
        customer.print();

        // カートに商品を追加する
        addCart(customer, shop);

        // 顧客のカート内の商品を表示
        customer.printMyCart();
    }

    /**
     * 商品リストを作る
     * @return 商品リスト
     */
    private static List<Item> makeItem(){
        List<Item> itemList = new ArrayList<>();

        // 商品を登録する
        // TODO 商品列挙のenumを使う実装にしよう
        itemList.add(new Item("フリウス", 2350000));
        itemList.add(new Item("バリヤー", 2970000));
        itemList.add(new Item("ベルグランド", 3150000));
        itemList.add(new Item("フォーレディーＺ", 3980000));
        itemList.add(new Item("ガニメデ ", 2620000));

        // TODO 自由に登録できる機能をつくる

        return itemList;
    }

    /**
     * ショップに取扱商品リストを登録する
     * @param itemList 取扱商品リスト
     * @param shop 登録するショップ
     */ 
    private static void registerItem(List<Item> itemList, Shop shop){
        for (Item item :
                itemList) {
            shop.add(item);
        }
    }

    // TODO 商品名・金額一覧保存しておくenumかなにかをつくる

    /**
     * 顧客のカートに商品を追加する
     * @param customer 顧客
     * @param shop 買い物するショップ
     */
    private static void addCart(Customer customer, Shop shop)
    {
        customer.add(shop, 0);
        customer.add(shop, 3);
    }
}
