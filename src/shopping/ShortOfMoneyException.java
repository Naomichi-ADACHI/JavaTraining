package shopping;

/**
 * 精算時に所持金不足
 */
public class ShortOfMoneyException extends Exception {
    /**
     * コンストラクタ。Exceptionにわたすのみ。
     *
     * @param message 例外メッセージ
     */
    ShortOfMoneyException(String message) {
        super(message);
    }
}
