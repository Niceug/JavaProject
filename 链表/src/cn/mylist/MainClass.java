package cn.mylist;

class LinkList{
	
	class Node{
		int data;
		Node next = null;
		Node(int data){
			this.data = data;
		}
	}
	
	
	//头结点，无任何作用
	private Node head = new Node(0);
	
	//获取头结点
	public Node getHead(){
		return this.head;
	}
	
	//获取长度
	public int getListLength(){
		Node pCur = head;
		int len = 0;
		while(pCur != null){
			len++;
			pCur = pCur.next;
		}
		return len;
	}
	
	//尾插法
	public void insertIntoTail(int data){
		Node insertNode = new Node(data);
		insertNode.next = null;
		Node cur = head;
		while(cur.next != null)
		{
			cur = cur.next;
		}
		cur.next = insertNode;
	}
	
	//尾删
	public void deleteFromTail(){
		if(head.next == null)
		{
			System.out.println("链表为空");
		}
		Node cur = head.next;
		Node preCur = null;
		while(cur.next != null){
			preCur = cur;
			cur = cur.next;
		}
		preCur.next = null;
		cur = null;
	}
	
	//头插法
	public void insertIntoFront(int data){
		Node insertNode = new Node(data);
		insertNode.next = head.next;
		head.next = insertNode;
	}
	
	//头删
	public void deleteFromFront(){
		if(head.next == null){
			System.out.println("空链表");
			return;
		}
			
		head.next = head.next.next;
	}
	
	
	//打印链表
	public void showList(){
		Node cur = head.next;
		while(cur != null){
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
		System.out.println("");
	}
	
	//逆序打印链表
	public void reverseShowList(Node cur){
		if(cur.next != null){
			reverseShowList(cur.next);
		}
		System.out.print(cur.data + " ");
	}
	
	
	public void getJosephCircle(){
		Node pCur = head.next;
		while(pCur.next != null){
			pCur = pCur.next;
		}
		pCur.next = head.next;
	}
	
	//约瑟夫环
	public void setJosephCircle(int m){
		Node pCur = head.next;
		Node pPreCur = head.next;
		getJosephCircle();
		int count;
		while(pCur != pCur.next){
			count = m;
			while(true){
				pPreCur = pCur;
				pCur = pCur.next;
				--count;
				if(count == 1)
					break;
			}
			
			System.out.println("删除节点"+pCur.data);
			pPreCur.next = pCur.next;
			pCur = null;
			pCur = pPreCur.next;
		}
		pCur.next = null;
	}
	
	//逆置单链表
	public void reverseList(){
		
		Node cur = head.next;
		Node preCur = null;
		Node tail = null;
		
		while(cur != null){
			preCur = cur;
			cur = cur.next;
			preCur.next = tail;
			tail = preCur;
		}
		head.next = preCur;
	}
	
	//单链表冒泡排序
	public void bubbleSort(){
		Node out = head.next;
		Node in = head.next;
		Node tail = null;
		while(out != tail){
			in = out;
			while(in.next != tail){
				if(in.data > in.next.data){
					int tmp = in.data;
					in.data = in.next.data;
					in.next.data = tmp;
				}
				in = in.next;
			}
			tail = in;
		}
	}
	
	//获取中间节点
	public Node getMiddleNode(){
		Node pFast = head.next;
		Node pSlow = head.next;
		while(pFast != null){
			if(pFast.next == null)
				return pSlow;
			pFast = pFast.next.next;
			pSlow = pSlow.next;
		}
		return pSlow;	
	}
	
	//获得倒数第k个节点
	public Node getLastLocationAtK(int k){
		Node pFast = head.next;
		Node pSlow = head.next;
		while(k-- > 0){
			pFast = pFast.next;
		}
		while(pFast != null){
			pFast = pFast.next;
			pSlow = pSlow.next;
		}
		return pSlow;
	}
	
	//获取尾节点
	public Node getLastNode(){
		Node pTail = head.next;
		while(pTail.next != null){
			pTail = pTail.next;
		}
		return pTail;
	}
	
	//判断单链表是否带环
	public Node hasCircle(){
		Node pFast = head.next;
		Node pSlow = head.next;
		while(true){
			pFast = pFast.next.next;
			pSlow = pSlow.next;
			if(pFast == pSlow){
				break;
			}
			if(pFast == null){
				return null;
			}
		}
		pSlow = head.next;
		while(true){
			if(pSlow == pFast){
				return pSlow;
			}
			pFast = pFast.next;
			pSlow = pSlow.next;
		}
	}
	
	//获取k位置上的节点
	public Node getAnyNode(int k){
		Node pCur = head;
		while(k > 0){
			pCur = pCur.next;
			k--;
		}
		return pCur;
	}
	
	//判断两个链表是否相交（链表不带环），求交点
	public static Node getCrossNode(LinkList list1, LinkList list2){
		Node head1 = list1.getHead().next;
		Node head2 = list2.getHead().next;
		if(head1 == null || head2 == null)
			return null;
		int len1 = list1.getListLength();
		int len2 = list2.getListLength();
		int step = 0;
		if(len1 > len2){
			step = len1 - len2;
			while(step > 0){
				head1 = head1.next;
				step--;
			}
			while(head1 != null){
				head1 = head1.next;
				head2 = head2.next;
				if(head1 == head2)
					return head1;
			}
		}else{
			
			step = len2 - len1;
			while(step > 0){
				head2 = head2.next;
				step--;
			}
			while(head1 != null){
				head1 = head1.next;
				head2 = head2.next;
				if(head1 == head2)
					return head1;
			}
			
		}
		return null;
	}
	
	//判断两个单链表是否相交，链表可能带环
	public static Node getCrossNodePlus(LinkList list1, LinkList list2){
		if(list1.getHead().next == null)
			return null;
		if(list2.getHead().next == null)
			return null;
		
		//判断两个链表是否带环
		Node crossNode1 = list1.isCircle();
		Node crossNode2 = list2.isCircle();
		
		//都不带环
		if(crossNode1 == null && crossNode2 == null){
			return getCrossNode(list1, list2);
		}
		
		//都带环
		if(crossNode1 != null && crossNode2 != null){
			LinkList.Node cur1 = list1.getHead().next;
			LinkList.Node cur2 = list2.getHead().next;
			
			if(crossNode1 == crossNode2){
				
				//环外相交，分别求两个链表到环入口点的长度
				int len1 = 0;
				int len2 = 0;
				while(true){
					if(cur1 != crossNode1){
						cur1 = cur1.next;
						len1++;
					}
					if(cur2 != crossNode2){
						len2++;
						cur2 = cur2.next;
					}
					if(cur1 == cur2)
						break;	
				}
				
				cur1 = list1.getHead().next;
				cur2 = list2.getHead().next;
				int len = len1 - len2;
				if(len>0){
					
					while(len>0){
						cur1 = cur1.next;
						len--;
					}
					
					while(true){
						if(cur1 == cur2)
							return cur1;
						cur1 = cur1.next;
						cur2 = cur2.next;
					}
					
				}else{
					while(len<0){
						cur2 = cur2.next;
						len++;
					}
					
					while(true){
						if(cur1 == cur2)
							return cur1;
						cur1 = cur1.next;
						cur2 = cur2.next;
					}
				}
				
			}else{
				//环内相交，返回任意一个入口点。
				return crossNode1;
			}
		}
			return null;
	}
	
	//合并两个单链表
	public static LinkList mergeLists(LinkList list1, LinkList list2){
		if(list1.getHead() == null)
			return list2;
		if(list2.getHead() == null)
			return list1;
		Node head1 = list1.getHead();
		Node head2 = list2.getHead();
		LinkList list = new LinkList();
		
		Node head = list.getHead();
		head.next = head1.data>head2.data?head2:head1;
		
		//去除头结点操作，如果指向head1，head2的头结点被去除。如果指向head2，head1的头结点被去除
		head1 = head1.next;
		head2 = head2.next;
		
		//具体的插值操作
		while(true){
			if(head1.data<head2.data){
				head.next = head1;
				head1 = head1.next;
			}else{
				head.next = head2;
				head2 = head2.next;
			}
			
			if(head1 == null){
				head.next.next = head2;
				break;
			}
			if(head2 == null){
				head.next.next = head1;
				break;
			}
			head = head.next;
		}
		return list;
	}
	
	//判断单链表是否带环
	public Node isCircle(){
		Node pFast = head.next;
		Node pSlow = head.next;
		int len = 0;
		while(true){
			pFast = pFast.next.next;
			pSlow = pSlow.next;
			if(pFast == pSlow){
				break;
			}
			if(pFast == null){
				return null;
			}
		}
		pSlow = head.next;
		while(pSlow != pFast){
			pSlow = pSlow.next;
			pFast = pFast.next;
		}
		
		while(true){
			pFast = pFast.next;
			len++;
			if(pFast == pSlow)
				break;
		}
		System.out.println("环的长度为" + len);
		return pSlow;
	}
	

}





public class MainClass {
	
	
	
	//判断是否带环
	public static void TestHasCircle(){
		LinkList list = new LinkList();
		//尾插
		list.insertIntoTail(1);
		list.insertIntoTail(2);
		list.insertIntoTail(3);
		list.insertIntoTail(4);
		list.insertIntoTail(5);
		list.insertIntoTail(6);
		LinkList.Node node = list.getLastNode();
		node.next = list.getAnyNode(2);
		LinkList.Node crossNode = list.hasCircle();
		System.out.println("相交节点为：" +crossNode.data);
	}
	
	public static void TestGetLastLocationAtK(){
		LinkList list = new LinkList();
		//尾插
		list.insertIntoTail(7);
		list.insertIntoTail(6);
		list.insertIntoTail(4);
		list.insertIntoTail(54);
		list.insertIntoTail(11);
		list.insertIntoTail(23);
		list.insertIntoTail(66);
		list.showList();
		
		int k = 2;
		LinkList.Node node = list.getLastLocationAtK(k);
		System.out.println("倒数第" + k + "个节点为" + node.data);
	}
	
	public static void TestJoseph(){
		LinkList list = new LinkList();
		//尾插
		list.insertIntoTail(7);
		list.insertIntoTail(6);
		list.insertIntoTail(4);
		list.insertIntoTail(5);
		list.insertIntoTail(8);
		list.showList();
		
		list.setJosephCircle(4);
		list.showList();
	}
	
	public static void TestShowReverseList(){
		LinkList list = new LinkList();
		//尾插
		list.insertIntoTail(7);
		list.insertIntoTail(6);
		list.insertIntoTail(4);
		list.insertIntoTail(5);
		list.insertIntoTail(8);
		list.showList();
		list.reverseShowList(list.getHead().next);
	}
	
	public static void TestReverseList(){
		LinkList list = new LinkList();
		//尾插
		list.insertIntoTail(7);
		list.insertIntoTail(6);
		list.insertIntoTail(4);
		list.insertIntoTail(5);
		list.insertIntoTail(8);
		list.showList();
		list.reverseList();
		list.showList();
	}
	
	public static void TestBubbleSort(){
		LinkList list = new LinkList();
		list.insertIntoTail(7);
		list.insertIntoTail(6);
		list.insertIntoTail(4);
		list.insertIntoTail(5);
		list.insertIntoTail(8);
		list.showList();
		list.bubbleSort();
		list.showList();	
	}
	
	public static void TestGetMiddleNode(){
		LinkList list = new LinkList();
		list.insertIntoTail(7);
		list.insertIntoTail(6);
		list.insertIntoTail(4);
		list.insertIntoTail(5);
		list.insertIntoTail(8);
		list.showList();
		LinkList.Node node = list.getMiddleNode();
		System.out.println(node.data);
	}
	
	public static void TestGetCrossNode(){
		LinkList list1 = new LinkList();
		list1.insertIntoTail(7);
		list1.insertIntoTail(6);
		list1.insertIntoTail(4);
		list1.insertIntoTail(11);
		list1.insertIntoTail(8);
		LinkList.Node lastNode = list1.getLastNode();
		
		LinkList list2 = new LinkList();
		list2.insertIntoTail(1);
		list2.insertIntoTail(10);
		list2.insertIntoTail(12);
		list2.insertIntoTail(8);
		list2.insertIntoTail(13);
		lastNode.next = list2.getAnyNode(3);
		list1.showList();
		list2.showList();
		
		LinkList.Node crossNode = LinkList.getCrossNode(list1, list2);
		System.out.println("交点为" + crossNode.data);
		
	}
	
	public static void TestMergeLists(){
		LinkList list = new LinkList();
		list.insertIntoTail(2);
		list.insertIntoTail(3);
		list.insertIntoTail(4);
		list.insertIntoTail(9);
		list.insertIntoTail(12);
		
		LinkList list1 = new LinkList();
		list1.insertIntoTail(1);
		list1.insertIntoTail(2);
		list1.insertIntoTail(3);
		list1.insertIntoTail(4);
		list1.insertIntoTail(13);
		list.showList();
		list1.showList();
		LinkList newList = LinkList.mergeLists(list, list1);
		newList.showList();
		
	}
	
	public static void TestIsCircle(){
		LinkList list = new LinkList();
		list.insertIntoTail(2);
		list.insertIntoTail(3);
		list.insertIntoTail(4);
		list.insertIntoTail(9);
		list.insertIntoTail(12);
		LinkList.Node tail = list.getLastNode();
		LinkList.Node node = list.getAnyNode(4);
		tail.next = node;
		LinkList.Node entrence =  list.isCircle();
		System.out.println("环的入口点为:" + entrence.data);
		
	}
	
	public static void TestGetCrossNodePlus(){
		LinkList list1 = new LinkList();
		list1.insertIntoTail(7);
		list1.insertIntoTail(6);
		list1.insertIntoTail(4);
		list1.insertIntoTail(11);
		list1.insertIntoTail(8);
		LinkList.Node lastNode1 = list1.getLastNode();
		
		LinkList list2 = new LinkList();
		list2.insertIntoTail(1);
		list2.insertIntoTail(2);
		list2.insertIntoTail(3);
		list2.insertIntoTail(4);
		list2.insertIntoTail(13);
		list2.insertIntoTail(18);
		list2.insertIntoTail(20);
		
		lastNode1.next = list2.getAnyNode(5);
		LinkList.Node lastNode2 = list2.getLastNode();
		lastNode2.next = list2.getAnyNode(2);
		
		LinkList.Node crossNode = LinkList.getCrossNodePlus(list1, list2);
		System.out.println("交点为" + crossNode.data);
	}
	
	
	public static void main(String[] args) {
		//TestGetCrossNodePlus();
		//TestGetLastLocationAtK();
		//TestJoseph();
		//TestShowReverseList();
		//TestReverseList();
		//TestBubbleSort();
		//TestGetMiddleNode();
		//TestHasCircle();
		
		//TestGetCrossNode();
		TestMergeLists();
		//TestIsCircle();
	}
	

}
