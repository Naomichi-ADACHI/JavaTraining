package shopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
//        addCart(customer, shop);
        selectItem(customer, shop);

        // 顧客のカート内の商品を表示
        customer.printMyCart();
    }

    /**
     * 商品リストを作る
     *
     * @return 商品リスト
     */
    private static List<Item> makeItem() {
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
     *
     * @param itemList 取扱商品リスト
     * @param shop     登録するショップ
     */
    private static void registerItem(List<Item> itemList, Shop shop) {
        for (Item item :
                itemList) {
            shop.add(item);
        }
    }

    // TODO 商品名・金額一覧保存しておくenumかなにかをつくる

//    /**
//     * 顧客のカートに商品を追加する
//     * itemNoを直打ちしてカートに追加する関数
//     *
//     * @param customer 顧客
//     * @param shop     買い物するショップ
//     */
//    private static void addCart(Customer customer, Shop shop) {
//        customer.add(shop, 0);
//        customer.add(shop, 3);
//    }


    /**
     * 顧客のカートに指定の商品を追加する
     *
     * @param customer 顧客
     * @param shop     買い物するショップ
     * @param itemNo   追加する商品
     * @throws Exception ショップの商品リストに存在しない商品番号を指定すると通知される
     */
    private static void addCart(Customer customer, Shop shop, int itemNo) throws Exception{
        customer.add(shop, itemNo);
    }

    /**
     * @param customer 買い物する顧客
     * @param shop 買い物するショップ
     */
    private static void selectItem(Customer customer, Shop shop) {
        System.out.println("購入したい商品を選んでください");

        Scanner sc = new Scanner(System.in);

        boolean isNotLoopEnd = true;  // "q"が入力されたときにtrueとなり、ループが終了するフラグ
        while (isNotLoopEnd) {
            System.out.print("商品番号（ｑで買い物を終了）？");
            // 標準入力から一行取得
            String inputStr = sc.nextLine();

            // 数字かどうかの判定がしたい
            try {
                // Intにパースできれば数字なので、商品を選択
                int itemNo = Integer.parseInt(inputStr);
                addCart(customer, shop, itemNo);
            } catch (NumberFormatException e) {
                // 数字以外
                switch (inputStr) {
                    case "q":
                        // "q"のとき、連続入力終了
                        isNotLoopEnd = false;
                        break;
                    default:
                        // 不正の文字の場合、表示を出し、次の入力を待つ
                        System.out.println("数値または指定の文字を入力してください。");
                        break;
                }
            } catch (Exception e) {
                // ショップに存在しない商品番号を指定してしまった
                System.out.println("指定された商品番号に該当する商品は商品リストにありません。");
            }
        }
    }
}
