public class linkedList {
    Node head;

    static class Node{
        int data;
        Node next;

        Node(int d){
            data=d;
            next=null;
        }
    }

    public static linkedList insert(linkedList list,int data){

        Node newNode=new Node(data);
        newNode.next=null;

        if(list.head==null){
            list.head=newNode;
        }
        else{
            Node last=list.head;
            while(last.next!=null){
                last=last.next;
            }
            last.next=newNode;
        }

        return list;
    }

    

    public static linkedList insertbegin(linkedList list,int data){
        Node firstNode = new Node(data);
        
        firstNode.next=list.head;
        list.head=firstNode;

        return list;
    }

    public static linkedList insertLast(linkedList list,int data){
        Node lastNode=new Node(data);
        Node curNode=list.head;

        while(curNode.next != null){
            curNode=curNode.next;
        }
        curNode.next=lastNode;

        return list;
    }

    public static linkedList insertSpecific(linkedList list,int data,int index){
        Node specNode=new Node(data);
        Node currNode=list.head;
        
        for(int i=0;i<index;i++){
            currNode=currNode.next;
        }
        specNode.next=currNode.next;
        currNode.next=specNode;
        return list;
    }

    public static void printList(linkedList list){
        Node currentNode=list.head;

        while(currentNode!=null){
            System.out.print(currentNode.data + " ");
            currentNode=currentNode.next;
        }
        System.out.println();
    }

    public static boolean isPalindrome(linkedList list){
        if(list.head == null || list.head.next == null){
            return true;
        }

        Node slow = list.head;
        Node fast = list.head;
        Node prevSlow = null;
        Node midNode = null;
        Node secondHalf;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
        }

        if(fast != null){
            midNode = slow;
            slow = slow.next;
        }

        secondHalf = slow;
        prevSlow.next = null;

        secondHalf = reverse(secondHalf);
        boolean result = compareLists(list.head, secondHalf);

        secondHalf = reverse(secondHalf);

        if(midNode != null){
            prevSlow.next = midNode;
            midNode.next = secondHalf;
        } else {
            prevSlow.next = secondHalf;
        }

        return result;
    }

    public static Node reverse(Node head){
        Node prev = null;
        Node current = head;
        Node next;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static boolean compareLists(Node head1, Node head2){
        Node temp1 = head1;
        Node temp2 = head2;
        while(temp1 != null && temp2 != null){
            if(temp1.data != temp2.data){
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        if(temp1 == null && temp2 == null){
            return true;
        }
        return false;
    }
    public static void main(String [] args){
        linkedList list=new linkedList();

        list =insert(list,1);
        list =insert(list,2);
        list =insert(list,3);
        list =insert(list,3);
        list =insert(list,2);
        list =insert(list,1);

        System.out.print("Original linked list: ");
        printList(list);

        System.out.println("Is the linked list a palindrome? " + isPalindrome(list));

        insertbegin(list,0);

        System.out.print("After inset for brgin to linked list: ");
        printList(list);

        insertLast(list,10);

        System.out.print("After inset for end of the linked list: ");
        printList(list);

        insertSpecific(list,20,4);

        System.out.print("After inset for specific place of linked list: ");
        printList(list);
    }
}