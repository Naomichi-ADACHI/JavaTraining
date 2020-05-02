package shopping;

/**
 * 商品クラス
 */
public class Item {
    private String name;    // 商品名
    private int price;  // 商品の価格

    /**
     * 商品クラスのコンストラクタ
     * ※引数なしのコンストラクタ許さない
     *
     * @param name  商品名
     * @param price 価格
     */
    public Item(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * 商品名と価格をターミナルに出力する
     */
    public void print() {
        System.out.println(name + " : " + price + " 円");
    }
}
