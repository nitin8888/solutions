package java8.code_exercises;

import java.util.Optional;

public class ListNode {
    private final int data;
    private ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Optional<ListNode> getNext() {
        return Optional.ofNullable(next);
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
