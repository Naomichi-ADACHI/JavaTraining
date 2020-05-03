package shopping;

/**
 * 顧客クラス
 */
public class Customer {
    private String name;    // 顧客の名前
    private Cart myCart = new Cart();   //　自分の商品カート
    private int money = 0;  // 所持金

    /**
     * 顧客クラスのコンストラクタ
     * ※引数なしのコンストラクタは許さない
     *
     * @param name 顧客の名前
     */
    public Customer(String name) {
        this.name = name;
    }

    /**
     * 顧客クラスのコンストラクタ。所持金指定版
     *
     * @param name  顧客の名前
     * @param money 顧客の所持金
     */
    public Customer(String name, int money) {
        this.name = name;
        this.money = money;
    }

    /**
     * 自分の名前とカートの商品をターミナルに表示する
     */
    public void print() {
        System.out.println("****************************************");

        // 名前の表示
        System.out.println("私の名前は、" + name + "です");

        // 所持金の表示
        System.out.println("所持金は、" + money + " 円です。");

        // カート内の商品の表示
        printMyCart();
        System.out.println("****************************************");
    }

    /**
     * 自分の名前とカートの商品をターミナルに表示します
     */
    public void printMyCart() {
        // 商品の表示
        myCart.print();
    }

    /**
     * 特定のショップのカートに商品を追加する
     *
     * @param shop   ショップ
     * @param itemNo 追加する商品番号。ShopクラスのListのIndexと紐づく
     * @throws IndexOutOfBoundsException ショップの商品リストに存在しないitemNoが設定されたときに通知される
     */
    public void add(Shop shop, int itemNo) throws IndexOutOfBoundsException {
        myCart.add(shop.get(itemNo));
    }

    /**
     * カートの商品を精算する
     *
     * @throws ShortOfMoneyException 所持金不足のときに通知される
     */
    public void checkOut() throws ShortOfMoneyException {
        // カート内合計金額を取得
        final int totalPrice = myCart.getTotalPrice();

        if (isEnoughMoney(totalPrice)) {
            // 精算を行い、カートを空にする
            money -= totalPrice;
            myCart.clear();
        } else {
            // 所持金不足で、精算をしない
            throw new ShortOfMoneyException("所持金不足");
        }
    }

    /**
     * 所持金で引数の金額を払えるか判定する
     *
     * @param price 判定する金額
     * @return 払える場合True
     */
    private boolean isEnoughMoney(int price) {
        return money >= price;
    }

    /**
     * カート内の指定のインデックスの商品を取り除く
     *
     * @param itemNo 取り除く商品のインデックス
     * @throws IndexOutOfBoundsException 商品がカート内に存在しないときに通知される
     */
    public void remove(int itemNo) throws IndexOutOfBoundsException {
        myCart.remove(itemNo);
    }
}
