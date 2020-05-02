package shopping;

/**
 * 顧客クラス
 */
public class Customer {
    private String name;    // 顧客の名前
    private Cart myCart = new Cart();   //　自分の商品カート

    /**
     * 顧客クラスのコンストラクタ
     * ※引数なしのコンストラクタは許さない
     * @param name 顧客の名前
     */
    public Customer(String name) {
        this.name = name;
    }

    /**
     * 自分の名前とカートの商品をターミナルに表示する
     */
    public void print()
    {
        System.out.println("****************************************");

        // 名前の表示
        System.out.println("私の名前は、" + name + "です");

        // 商品の表示
        printMyCart();
        System.out.println("****************************************");
    }

    /**
     * 自分の名前とカートの商品をターミナルに表示します
     */
    public void printMyCart()
    {
        // 商品の表示
        myCart.print();
    }

    /**
     * 特定のショップのカートに商品を追加する
     * @param shop ショップ
     * @param itemNo 追加する商品番号。ShopクラスのListのIndexと紐づく
     * @throws Exception ショップの商品リストに存在しないitemNoが設定されたときに通知される
     */
    public void add(Shop shop, int itemNo) throws Exception{
        myCart.add(shop.get(itemNo));
    }
}
