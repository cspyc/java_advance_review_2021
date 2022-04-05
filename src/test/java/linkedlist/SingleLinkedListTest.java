package linkedlist;

import com.dataStruct_algorithm.linkedlist.SingleLinkedList;
import org.junit.jupiter.api.Test;

/**
 * @author pi
 * @date 2021/07/02 18:22:34
 * 单向链表
 **/
public class SingleLinkedListTest {
    @Test
    public void should_test_single_linked_list() throws Exception {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList.Node node1 = new SingleLinkedList.Node(1, "小一");
        SingleLinkedList.Node node2 = new SingleLinkedList.Node(2, "小2");
        SingleLinkedList.Node node3 = new SingleLinkedList.Node(3, "小3");
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node3);

        singleLinkedList.list();
    }
}
