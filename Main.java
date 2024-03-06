import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Main {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }


    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {

        SinglyLinkedListNode Node = new SinglyLinkedListNode(data);
        if(position == 1){
            Node.next = head;
            head = Node;
        }
        else{
            SinglyLinkedListNode previous = head;
            int count = 1;

            while(count < position - 1){
                previous = previous.next;
                count++;

            }

            SinglyLinkedListNode current = previous.next;
            Node.next = current;
            previous.next = Node;


        }
        return head;
    }



    //Inserting At Front

/*
    void insertAtFront(int new_data)
    {
        // 1. allocate node
        Node newNode = new Node();

        // 2. put in the data
        newNode.data = new_data;

        // 3. Make next of new node as head
        newNode.next = head;

        // 4. move the head to point
        // to the new node
        head = newNode;
    }



    //Inserting At End

    void insertAtEnd(int new_data) {

        //1. allocate node
        Node newNode = new Node();

        //2. assign data element
        newNode.data = newElement;

        //3. assign null to the next of new node
        newNode.next = null;

        //4. Check the Linked List is empty or not,
        //   if empty make the new node as head
        if(head == null) {
            head = newNode;
        } else {

            //5. Else, traverse to the last node
            Node temp = new Node();
            temp = head;
            while(temp.next != null)
                temp = temp.next;

            //6. Change the next of last node to new node
            temp.next = newNode;
        }
    }

*/

    /*

    //Delete node at position

    if(position  == 1){
        head == head.next;
    }
    ListNode prev = head;
    int count = 1;
    while(count < position - 1){
        prev = prev.next;
        count++;
    }
    ListNode curr = previous.next;
    prev.next = curr.next;

*/

    // Write your code here



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }

        int data = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int position = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, data, position);

        printSinglyLinkedList(llist_head, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
