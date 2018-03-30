#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

typedef int DataType;

typedef struct Node
{
	struct Node* _pNext;
	DataType _data;
}Node, *PNode;


//////////////////����ͷ���ĵ�����////////////////////////////////////// 
// .h 
// �����ʼ�� 
void SListInit(PNode* pHead);

// β�� 
void SListPushBack(PNode* pHead, DataType _data);

// βɾ 
void SListPopBack(PNode* pHead);

// ͷ�� 
void SListPushFront(PNode* pHead, DataType _data);

// ͷɾ 
void SListPopFront(PNode* pHead);

// ����ֵΪ_data�Ľ�㣬���ظý���������е�λ�� 
PNode SListFind(PNode pHead, DataType _data);

// ������posλ�ú������_data 
void SListInsert(PNode* pHead, PNode pos, DataType _data);

// ɾ������posλ���ϵĽ�� 
void SListErase(PNode* pHead, PNode pos);

// ���ٵ����� 
void SListDestroy(PNode* pHead);

// �������н��ĸ��� 
int SListSize(PNode pHead);

// �������еĽ����� 
void SListClear(PNode* pHead);

//��ȡ�ڼ����ڵ�
PNode getAnyNode(PNode pHead, int num);

// ��ȡ��� 
PNode BuySListNode(DataType _data);

// ��ȡ�����е����һ����㣬���ظý��ĵ�ַ 
PNode SListBack(PNode pHead);

void showSList(PNode head);

//�����ӡ������
void reverseShowSList(PNode head);

//ɾ��ָ���ڵ�
void DeleteNotTailNode(PNode pos);

// ������posλ��ǰ����ֵΪ_data�Ľ�� 
void InsertPosFront(PNode pos, DataType _data);

void setJosephCirecle(PNode* head);
// Լɪ�� 
void JosephCircle(PNode* pHead, const int M);

// ʹ��ð�ݷ�ʽ�Ե������������ 
void BubbleSort(PNode pHead);

// �����������---����ָ�� 
void ReverseSList(PNode* pHead);

// �����������---ʹ��ͷ�巨 
PNode ReverseSListOP(PNode* pHead);

// �ϲ��������������ϲ�������ȻҪ���� 
PNode MergeSList(PNode pHead1, PNode pHead2);

// ����������м��㣬Ҫ��ֻ�ܱ���һ������ 
PNode FindMiddleNode(PNode pHead);

// ��������ĵ�����K����� 
PNode FindLastKNode(PNode pHead, int K);
// ɾ������ĵ�����K���ڵ�
void DeleteLastKNode(PNode head, int k);

// ��ȡ�ཻ����Ľ���
PNode GetCrossNode(PNode pHead1, PNode pHead2);

//�ж������Ƿ����
PNode hasCircle(PNode pHead);

//ħ���˿���
void setMagicCard(PNode* pHead);

//��������
int** LatinArray(PNode* pHead, unsigned int n);
//���Ժϲ�������������

void testMerge() {

	PNode pHead;
	SListInit(&pHead);
	SListPushBack(&pHead, 1);
	SListPushBack(&pHead, 3);
	SListPushBack(&pHead, 5);
	SListPushBack(&pHead, 6);
	SListPushBack(&pHead, 9);
	showSList(pHead);
	PNode pHead1;
	SListInit(&pHead1);
	SListPushBack(&pHead1, 2);
	SListPushBack(&pHead1, 4);
	SListPushBack(&pHead1, 5);
	SListPushBack(&pHead1, 8);
	SListPushBack(&pHead1, 10);
	SListPushBack(&pHead1, 15);
	showSList(pHead1);

	PNode head = MergeSList(pHead, pHead1);
	showSList(head);
}

//����Լɪ��
void testJosephCircle() {
	PNode pHead;
	SListInit(&pHead);
	SListPushBack(&pHead, 1);
	SListPushBack(&pHead, 2);
	SListPushBack(&pHead, 3);
	SListPushBack(&pHead, 4);
	SListPushBack(&pHead, 5);
	SListPushBack(&pHead, 6);
	showSList(pHead);
	JosephCircle(&pHead, 3);
	showSList(pHead);
	
}

//���������ӡ������
void testReverseShowList() {
	PNode pHead;
	SListInit(&pHead);
	SListPushBack(&pHead, 1);
	SListPushBack(&pHead, 2);
	SListPushBack(&pHead, 3);
	SListPushBack(&pHead, 4);
	SListPushBack(&pHead, 5);
	SListPushBack(&pHead, 6);
	reverseShowSList(pHead);
}

//��������λ�õ�ɾ��
void testDeleteNotTailNode() {
	PNode pHead;
	SListInit(&pHead);
	SListPushBack(&pHead, 1);
	SListPushBack(&pHead, 2);
	SListPushBack(&pHead, 3);
	SListPushBack(&pHead, 4);
	SListPushBack(&pHead, 5);
	SListPushBack(&pHead, 6);
	showSList(pHead);
	PNode node = getAnyNode(pHead, 3);
	DeleteNotTailNode(node);
	showSList(pHead);
}

//����������λ��ǰ�����
void testInsertPosFront() {
	PNode pHead;
	SListInit(&pHead);
	SListPushBack(&pHead, 1);
	SListPushBack(&pHead, 2);
	SListPushBack(&pHead, 3);
	SListPushBack(&pHead, 4);
	SListPushBack(&pHead, 5);
	SListPushBack(&pHead, 6);
	showSList(pHead);
	PNode node = getAnyNode(pHead, 3);
	InsertPosFront(node, 10);
	showSList(pHead);
}

//�������õ�����
void testReverseSList() {
	PNode pHead;
	SListInit(&pHead);
	SListPushBack(&pHead, 1);
	SListPushBack(&pHead, 2);
	SListPushBack(&pHead, 3);
	SListPushBack(&pHead, 4);
	SListPushBack(&pHead, 5);
	SListPushBack(&pHead, 6);
	showSList(pHead);
	ReverseSList(&pHead);
	showSList(pHead);
}

//����ð������
void testBubbleSort() {
	PNode pHead;
	SListInit(&pHead);
	SListPushBack(&pHead, 1);
	SListPushBack(&pHead, 9);
	SListPushBack(&pHead, 3);
	SListPushBack(&pHead, 5);
	SListPushBack(&pHead, 2);
	SListPushBack(&pHead, 6);
	showSList(pHead);
	BubbleSort(pHead);
	showSList(pHead);
}

//�����ҵ��м�ڵ�
void testFindMiddleNode() {
	PNode pHead;
	SListInit(&pHead);
	SListPushBack(&pHead, 1);
	SListPushBack(&pHead, 2);
	SListPushBack(&pHead, 3);
	SListPushBack(&pHead, 4);
	SListPushBack(&pHead, 5);
	SListPushBack(&pHead, 6);
	showSList(pHead);
	PNode pMiddleNode = FindMiddleNode(pHead);
	printf("�м�ڵ�Ϊ��%d\n", pMiddleNode->_data);
}

//�����ҵ������ڼ����ڵ�
void testFindLastKNode() {
	PNode pHead;
	SListInit(&pHead);
	SListPushBack(&pHead, 1);
	SListPushBack(&pHead, 2);
	SListPushBack(&pHead, 3);
	SListPushBack(&pHead, 4);
	SListPushBack(&pHead, 5);
	SListPushBack(&pHead, 6);
	showSList(pHead);
	int k = 3;
	PNode pLastKNode = FindLastKNode(pHead, k);
	printf("������%d���ڵ�Ϊ%d\n", k, pLastKNode->_data);
}

//����ɾ�������ڼ����ڵ�
void testDeleteLastKNode() {
	PNode pHead;
	SListInit(&pHead);
	SListPushBack(&pHead, 1);
	SListPushBack(&pHead, 2);
	SListPushBack(&pHead, 3);
	SListPushBack(&pHead, 4);
	SListPushBack(&pHead, 5);
	SListPushBack(&pHead, 6);
	showSList(pHead);
	int k = 3;
	DeleteLastKNode(pHead, k);
	showSList(pHead);
}

//����ͷ�巨���ò���
void testReverseSListOP() {
	PNode pHead;
	SListInit(&pHead);
	SListPushBack(&pHead, 1);
	SListPushBack(&pHead, 2);
	SListPushBack(&pHead, 3);
	SListPushBack(&pHead, 4);
	SListPushBack(&pHead, 5);
	SListPushBack(&pHead, 6);
	showSList(pHead);
	ReverseSListOP(&pHead);
	showSList(pHead);
}

//���������Ƿ��ཻ
void testGetCrossNode() {
	PNode pHead;
	SListInit(&pHead);
	SListPushBack(&pHead, 1);
	SListPushBack(&pHead, 3);
	SListPushBack(&pHead, 5);
	SListPushBack(&pHead, 6);
	SListPushBack(&pHead, 9);
	showSList(pHead);

	PNode pHead1;
	SListInit(&pHead1);
	SListPushBack(&pHead1, 2);
	SListPushBack(&pHead1, 4);
	SListPushBack(&pHead1, 5);
	SListPushBack(&pHead1, 8);
	SListPushBack(&pHead1, 10);
	SListPushBack(&pHead1, 15);
	showSList(pHead1);
	
	PNode pLastNode = SListBack(pHead);
	pLastNode->_pNext = getAnyNode(pHead1, 3);
	showSList(pHead);

	PNode crossNode = GetCrossNode(pHead, pHead1);
	printf("�ཻ�ڵ�Ϊ%d\n", crossNode->_data);
}

void testHasCircle() {
	PNode pHead;
	SListInit(&pHead);
	SListPushBack(&pHead, 1);
	SListPushBack(&pHead, 2);
	SListPushBack(&pHead, 3);
	SListPushBack(&pHead, 4);
	SListPushBack(&pHead, 5);
	SListPushBack(&pHead, 6);
	PNode pTail = SListBack(pHead);
	pTail->_pNext = getAnyNode(pHead, 5);
	//showSList(pHead);
	PNode entrenceNode = hasCircle(pHead);
	printf("��ڵ�Ϊ%d\n", entrenceNode->_data);
}

//����ħ���˿���
void testSetMagicCard() {
	PNode pHead;
	SListInit(&pHead);
	setMagicCard(&pHead);
}

//������������
void testLatinArray() {
	PNode pHead;
	SListInit(&pHead);
	int n = 5;
	int**arr = LatinArray(&pHead, n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			printf("%d ", arr[i][j]);
		}
		printf("\n");
	}
}


int main()
{
	//�ϲ���������
	//testMerge();
	//Լɪ��
	//testJosephCircle();
	//������ʾ������
	//testReverseShowList();
	//ɾ����ͷ�����β�ڵ�
	//testDeleteNotTailNode();
	//����ͷ�������һ���ڵ�ǰ����һ���ڵ�
	//testInsertPosFront();
	//���õ�������1
	//testReverseSList();
	//ð������
	//testBubbleSort();
	//�ҵ��м�ڵ�
	//testFindMiddleNode();
	//�ҵ�������k���ڵ�
	//testFindLastKNode();
	//ɾ��������k���ڵ�
	//testDeleteLastKNode();
	//��ȡ����
	//testGetCrossNode();
	//�Ƿ����
	//testHasCircle();
	//ħ���˿���
	//testSetMagicCard();
	//��������
	//testLatinArray();
	return 0;
}

//��ʼ��
void SListInit(PNode* pHead) {
	*pHead = (PNode)malloc(sizeof(Node));
	(*pHead)->_data = 0;
	(*pHead)->_pNext = NULL;

}

// β�� 
void SListPushBack(PNode* pHead, DataType _data) {
	assert(*pHead);

	PNode insertNode = BuySListNode(_data);

	PNode pTail = *pHead;
	while (pTail->_pNext) {
		pTail = pTail->_pNext;
	}
	pTail->_pNext = insertNode;
}

// βɾ 
void SListPopBack(PNode* pHead) {
	assert(*pHead);
	PNode pTail = *pHead;
	PNode pPreTail = *pHead;
	while (pTail->_pNext) {
		pPreTail = pTail;
		pTail = pTail->_pNext;
	}
	pPreTail->_pNext = NULL;
	free(pTail);
	pTail = NULL;
}

// ͷ�� 
void SListPushFront(PNode* pHead, DataType _data) {
	assert(*pHead);

	PNode insertNode = BuySListNode(_data);

	PNode head = *pHead;
	insertNode->_pNext = head->_pNext;
	head->_pNext = insertNode;
}

// ͷɾ 
void SListPopFront(PNode* pHead) {
	assert(*pHead);
	PNode pCur = *pHead;
	PNode pNext = NULL;
	pNext = pCur->_pNext;
	pCur->_pNext = pCur->_pNext->_pNext;
	free(pNext);
	if (pCur->_pNext->_pNext == NULL) {
		free(pCur->_pNext);
	}
}

//��ȡָ��λ�õĽڵ�
PNode getAnyNode(PNode pHead, int num) {
	assert(pHead);
	PNode pCur = pHead;
	while (num--) {
		pCur = pCur->_pNext;
	}
	return pCur;
}

// ����ֵΪ_data�Ľ�㣬���ظý���������е�λ�� 
PNode SListFind(PNode pHead, DataType _data) {
	assert(pHead);
	PNode pCur = pHead;
	while (pCur) {
		if (pCur->_data == _data) {
			return pCur;
		}
		pCur = pCur->_pNext;
	}

}

// ������posλ�ú������_data 
void SListInsert(PNode* pHead, PNode pos, DataType _data) {
	assert(*pHead);
	PNode pCur = *pHead;
	PNode newNode = BuySListNode(_data);
	while (pCur->_pNext) {
		if (pCur == pos)
		{
			newNode->_pNext = pCur->_pNext;
			pCur->_pNext = newNode;
			break;
		}
		pCur = pCur->_pNext;
	}

	pCur->_pNext = newNode;
}

// ɾ������posλ���ϵĽ�� 
void SListErase(PNode* pHead, PNode pos) {
	assert(*pHead);
	PNode pCur = *pHead;
	PNode pPreCur = NULL;
	while (pCur) {

		if (pCur == pos) {
			pPreCur->_pNext = pCur->_pNext;
			free(pos);
			break;
		}
		pPreCur = pCur;
		pCur = pCur->_pNext;

	}

}

// ���ٵ����� 
void SListDestroy(PNode* pHead) {
	PNode pPreCur = *pHead;
	if (*pHead == NULL)
		return;
	while (*pHead) {
		pPreCur = *pHead;
		(*pHead) = (*pHead)->_pNext;
		free(pPreCur);
	}
	free(*pHead);
	*pHead = NULL;
	
}

// �������н��ĸ��� 
int SListSize(PNode pHead) {
	assert(pHead);
	PNode pCur = pHead;
	int count = 0;
	while (pCur) {
		++count;
		pCur = pCur->_pNext;
	}
	return count;

}


//�޸�ͷָ����봫ͷָ��ĵ�ַ��
// �������еĽ����� 
void SListClear(PNode* pHead) {
	assert(*pHead);
	PNode preNode = *pHead;
	while ((*pHead)) {
		preNode = *pHead;
		(*pHead) = (*pHead)->_pNext;
		free(preNode);
		preNode = NULL;
	}
}

// ��ȡ��� 
PNode BuySListNode(DataType _data) {
	PNode node = (PNode)malloc(sizeof(Node));
	node->_pNext = NULL;
	node->_data = _data;
	return node;
}

// ��ȡ�����е����һ����㣬���ظý��ĵ�ַ 
PNode SListBack(PNode pHead) {
	assert(pHead);
	PNode pTail = pHead;
	while (pTail->_pNext) {
		pTail = pTail->_pNext;
	}
	return pTail;
}


//ɾ��һ����ͷ������ķ�β�ڵ�(�滻��)
void DeleteNotTailNode(PNode deleteNode) {
	assert(deleteNode);
	deleteNode->_data = deleteNode->_pNext->_data;
	PNode p = deleteNode->_pNext;
	deleteNode->_pNext = deleteNode->_pNext->_pNext;
	free(p);
}

//��һ����֪��ڵ�ǰ����һ���ڵ�
void InsertPosFront(PNode descNode, DataType _data) {
	assert(descNode);
	PNode insertNode = BuySListNode(_data);

	insertNode->_pNext = descNode->_pNext;
	descNode->_pNext = insertNode;

	int temp = descNode->_data;
	descNode->_data = insertNode->_data;
	insertNode->_data = temp;
}

//������ӡ������
void showSList(PNode head) {
	PNode pCur = head;
	while (pCur) {
		printf("%d ", pCur->_data);
		pCur = pCur->_pNext;
	}
	printf("\n");
}


//�����ӡ������
void reverseShowSList(PNode head) {
	PNode pCur = head;
	if (pCur != NULL) {
		reverseShowSList(pCur->_pNext);
		printf("%d ", pCur->_data);
	}
}


//ð������
void BubbleSort(PNode head) {
	assert(head);
	PNode pOut = head;
	PNode pIn = head;
	PNode pTail = NULL;
	//����Ѿ��ź��򣬾Ͳ�������
	int state = 0;
	while (pOut != pTail) {
		pIn = pOut;
		state = 0;
		while (1) {
			if (pIn->_pNext == pTail) {
				break;
			}
			if (pIn->_data > pIn->_pNext->_data) {
				int temp = pIn->_data;
				pIn->_data = pIn->_pNext->_data;
				pIn->_pNext->_data = temp;
				state = 1;
			}
			pIn = pIn->_pNext;
		}
		pTail = pIn;
		if (state == 0)
			break;
	}
}

//�ҵ��м�ڵ�
PNode FindMiddleNode(PNode head) {
	assert(head);
	PNode pCurFast = head;
	PNode pCurSlow = head;
	PNode pPreCurSlow = NULL;
	while (pCurFast) {

		pCurFast = pCurFast->_pNext->_pNext;;
		if (pCurFast == NULL) {
			return pCurSlow;
		}
		//���ܻ���Ҫ��һ������ֵ
		pPreCurSlow = pCurSlow;
		pCurSlow = pCurSlow->_pNext;
		if (pCurFast == NULL) {
			return pCurSlow;
		}
	}
}

//�ҵ�������k���ڵ�,һ��ָ������k��
PNode FindLastKNode(PNode head, int k) {
	assert(head);
	PNode pCurFast = head;
	PNode pCurSlow = head;
	int count = k;
	while (count--) {
		pCurFast = pCurFast->_pNext;
		if (pCurFast == NULL)
			return NULL;
	}
	while (pCurFast) {
		pCurFast = pCurFast->_pNext;
		pCurSlow = pCurSlow->_pNext;
	}
	return pCurSlow;
}


//ɾ�������ڼ����ڵ�
void DeleteLastKNode(PNode head, int k) {
	assert(head);
	PNode pCurFast = head;
	PNode pCurSlow = head;
	PNode pPreCurSlow = NULL;
	int count = k;
	while (count--) {
		pCurFast = pCurFast->_pNext;
		if (pCurFast == NULL)
			return NULL;
	}
	while (pCurFast) {
		pCurFast = pCurFast->_pNext;
		pPreCurSlow = pCurSlow;
		pCurSlow = pCurSlow->_pNext;
	}
	PNode temp = pPreCurSlow->_pNext;
	pPreCurSlow->_pNext = pPreCurSlow->_pNext->_pNext;
	free(temp);
}

//��β��ͷ��ӡ���ݹ�
//ɾ����ͷ������ķ�Ϊ�ڵ㣺�滻��(ֻ��ɾ����β�ڵ�)��
//����ͷ�������һ���ڵ�Ǯ����һ���ڵ㣺�Ȳ嵽�����ٽ���
//�ҵ�����k���ڵ㣺����1,����k��
//���м�Ľڵ㣺����ָ�룬��һ��һ��������
//�ж����������Ƿ��ཻ����һ����������һ���ڵ�ָ��ڶ�����������Ľڵ㣬��Ҫ��������֪������


////�ݹ鷨�ҵ����ڼ����ڵ�
//PNode searchDaoshuNode(PNode head) {
//	PNode pCur = head;
//	int k = 5;
//	int all = -5;
//	if (pCur != NULL) {
//		all++;
//		searchDaoshuNode(pCur->_pNext);
//		return pCur;
//	}
//}

//����Լɪ��
void setJosephCirecle(PNode* head) {
	assert(*head);
	PNode pTail = *head;
	while (1) {
		pTail = pTail->_pNext;
		if (pTail->_pNext == NULL)
		{
			pTail->_pNext = *head;
			return;
		}
	}
}

/**������ʵ��Լɪ��
num��ʾ�����ĵڼ����ڵ㱻ɾ��
*/
void JosephCircle(PNode* head, int num) {
	assert(*head);

	PNode pPre = *head;
	PNode pTemp = NULL;
	//����Լɪ��
	setJosephCirecle(head);

	while (1) {
		int count = num;
		while (--count) {
			pPre = *head;
			*head = (*head)->_pNext;
		}
		pTemp = (pPre)->_pNext;
		*head = (pPre)->_pNext->_pNext;
		(pPre)->_pNext = (pPre)->_pNext->_pNext;
		printf("ɾ���ڵ�%d\n", (pTemp)->_data);
		free(pTemp);
		if ((*head)->_pNext == *head)
			break;
	}
	(*head)->_pNext = NULL;
}

//���õ�����
void ReverseSList(PNode* head) {
	assert(*head);
	PNode preNode = NULL;
	PNode pCur = *head;
	PNode pNextNode = NULL;

	while (pCur != NULL) {
		pNextNode = pCur->_pNext;
		pCur->_pNext = preNode;
		preNode = pCur;
		pCur = pNextNode;
	}
	(*head) = preNode;
}

////ͷ�巨
//PNode ReverseSListOP(PNode *pHead) {
//
//	assert(*pHead);
//	PNode pCur = (*pHead)->_pNext->_pNext;
//	PNode pInsertNode = NULL;
//
//	while (pCur) {
//		pInsertNode = pCur;
//		(*pHead)->_pNext = pInsertNode;
//		pInsertNode->_pNext = ((*pHead)->_pNext);
//		pCur = pCur->_pNext;
//	}
//}

//�ϲ�������������
PNode MergeSList(PNode head1, PNode head2) {
	assert(head1);
	assert(head2);

	PNode phead = NULL;

	int gap = 0;

	//�ж��Ƿ�������Ϊ��
	if (head1->_pNext == NULL) {
		return head2;
	}
	if (head2->_pNext == NULL) {
		return head1;
	}
	phead = head1->_data < head2->_data ? head1 : head2;
	if (phead == head1)
	{
		head1 = head1->_pNext;
	}
	if (phead == head2)
	{
		head2 = head2->_pNext;
	}
	PNode pPreNode = NULL;
	PNode newHead = phead;
	while (1) {
		if (head1->_data < head2->_data) {
			phead->_pNext = head1;
			head1 = head1->_pNext;
		}
		else
		{
			phead->_pNext = head2;
			head2 = head2->_pNext;
		}

		if (head1 == NULL) {
			phead->_pNext->_pNext = head2;
			break;
		}


		if (head2 == NULL) {
			phead->_pNext->_pNext = head1;
			break;
		}

		phead = phead->_pNext;

	}
	return newHead;
}

// �ж����������Ƿ��ཻ���������������ཻ��ȡ����
PNode GetCrossNode(PNode pHead1, PNode pHead2) {
	assert(pHead1);
	assert(pHead2);
	
	PNode pCur1 = pHead1;
	PNode pCur2 = pHead2;

	int len1 = SListSize(pHead1);
	int len2 = SListSize(pHead2);
	int step = len1 - len2;

	if (step > 0) {
		while (step--) {
			pCur1 = pCur1->_pNext;
		}
		while (pCur1) {
			pCur1 = pCur1->_pNext;
			pCur2 = pCur2->_pNext;
			if (pCur1 == pCur2)
				return pCur1;
		}
		return NULL;
	}
	else {
		while (step++) {
			pCur2 = pCur2->_pNext;
		}
		while (pCur2) {
			pCur2 = pCur2->_pNext;
			pCur1 = pCur1->_pNext;
			if (pCur1 == pCur2)
				return pCur2;
		}
		return NULL;
	}
}

//���������ʼλ��ָ��ͬʱ�ߣ�������λ�þ��ǻ�����ڵ�ַ
//�ж������Ƿ����������ڣ��󻷵ĳ���
PNode hasCircle(PNode pHead) {
	assert(pHead);
	PNode pFast = pHead;
	PNode pSlow = pHead;
	int circleLen = 0;
	while (1) {
		pFast = pFast->_pNext->_pNext;
		pSlow = pSlow->_pNext;
		if (pFast == pSlow)
			break;
		if (pFast == NULL)
			return NULL;
	}
	pFast = pHead;
	while (pFast != pSlow){
		pFast = pFast->_pNext;
		pSlow = pSlow->_pNext;
	}

	while (1) {
		pSlow = pSlow->_pNext;
		circleLen++;
		if (pSlow == pFast)
			break;
	}
	printf("���ĳ���Ϊ%d\n", circleLen);
	return pFast;
}

//ħ��ʦ��������
void setMagicCard(PNode* pHead) {
	assert(*pHead);
	PNode setZero = *pHead;
	PNode insertNode = NULL;
	//��ʼ��13����Ϊ0(��ͷ���һ��13���ڵ�)
	int cardLen = 13;
	while (--cardLen) {
		insertNode = BuySListNode(0);
		setZero->_pNext = insertNode;
		insertNode->_pNext = NULL;
		setZero = insertNode;
	}

	showSList(*pHead);

	PNode pStart = *pHead;
	PNode pCur = *pHead;

	//�õ�һ���Ƶ���1
	pCur->_data = 1;
	//��ȡ���һ���ƣ��Ա㹹��ѭ������
	PNode tail = SListBack(*pHead);
	tail->_pNext = pStart;

	int cardID = 0;
	//�ӵڶ����ƿ�ʼ
	int i = 2;

	while (i <= 13) {
		while (cardID<i) {
			pCur = pCur->_pNext;
	 		//������û�и�ֵ��cardID++
			if (pCur->_data == 0) {
				cardID++;
				//printf("%d ", cardID);
			}
		}
		pCur->_data = cardID;
		cardID = 0;
		i++;
	}
	//�⻷
	tail->_pNext = NULL;
	showSList(*pHead);
}

//n����������
int** LatinArray(PNode* pHead, unsigned int n) {
	if (n == 0)
		return;
	//��Ԫ��Ϊ1
	PNode pCur = *pHead;
	PNode pTail = NULL;

	//�ȹ���һ��ѭ������
	for (int i = 1; i < n; i++) {
		pCur->_pNext = BuySListNode(i);
		pTail = pCur;
		pCur = pCur->_pNext;
	}
	pCur->_pNext = *pHead;
	PNode pStart = *pHead;
	pCur = *pHead;
	//showSList(*pHead);

	//����һ��n*n��С����������������
	int** arr = NULL;
	arr = (int**)malloc(sizeof(int)*n);
	for (int i = 0; i < n; i++) {
		arr[i] = (int *)malloc(sizeof(int *)*n);
	}

	//��ʼ������
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			arr[i][j] = 0;
		}
	}

	int i = 0;
	int j = 0;
	while (i<n) {
		pCur = pStart;
		j = 0;
		while (j < n) {
			arr[i][j] = pCur->_data;
			j++;
			pCur = pCur->_pNext;
		}
		i++;
		pStart = pStart->_pNext;
	}
	return arr;
}