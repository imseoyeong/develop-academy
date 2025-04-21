public interface CartInterface {
    boolean isCartInItem(String id);
    void clearCart();
    Item removeCartItem(String id);
    void appendItem(Item item);
    void inCreaseItemCount(String id);
    void checkCart();
    Item deCreaseItemCount(String id);
    void removeCartItem(int index);
}
