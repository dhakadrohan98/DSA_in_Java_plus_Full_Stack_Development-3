package org.codeship;

import java.util.*;

//Node class definition
class DLLNode {
	int key;
	int val;
	int freq;
	DLLNode next;
	DLLNode prev;

	public DLLNode(int key, int val) {
		this.key = key;
		this.val = val;
		this.freq = 1;
	}
}

// Doubly Linked list class definition
class DoublyLinkedList {
	int listSize;
	DLLNode head;
	DLLNode tail;

	public DoublyLinkedList() {
		this.listSize = 0;
		this.head = new DLLNode(0, 0);
		this.tail = new DLLNode(0, 0);
		head.next = tail;
		tail.prev = head;
	}

	// add new node into head of list & increase list size by 1.
	public void addNode(DLLNode curr) {
		DLLNode nextNode = head.next;
		curr.next = nextNode;
		nextNode.prev = curr;
		head.next = curr;
		curr.prev = head;
		listSize++;
	}

	// remove input node & decrease list size by 1.
	public void removeNode(DLLNode node) {
		// changing link of tail & tail.prev node to put new node just left to the tail
		// node.
		DLLNode prevNode = node.prev;
		DLLNode nextNode = node.next;
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
		node.next = null;
		node.prev = null;
		listSize--;
	}
}

public class LFUCache {

	// TC: O(1) on average for put() & get() methods
	// SC: O(n)

	final int capacity;
	int currSize;
	int minFrequency;
	Map<Integer, DoublyLinkedList> freqMap;
	Map<Integer, DLLNode> cache;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.currSize = 0;
		this.minFrequency = 0;
		
		this.freqMap = new HashMap<>();
		this.cache = new HashMap<>();
	}

	// get method
	public int get(int key) {
		DLLNode currNode = cache.get(key);
		if (currNode == null) {
			return -1;
		}
		updateNode(currNode);
		return currNode.val;
	}

	// put method is a little bit complex method
	public void put(int key, int value) {
		// corner case: check the cache capacity initialization
		if (capacity == 0) {
			return;
		}

		if (cache.containsKey(key)) {
			DLLNode currNode = cache.get(key);
			currNode.val = value;
			updateNode(currNode);
		} else {
			currSize++;
			if (currSize > capacity) {
				// get minimum frequency list
				DoublyLinkedList minFreqList = freqMap.get(minFrequency);
				// remove last node's key from cache map.
				// minFreqList.tail.prev.key : Integer
				cache.remove(minFreqList.tail.prev.key);
				// remove last node from DoublyLinkedList i.e. minFreqList & then decrement
				// doubly linked list size by 1
				// minFreqList.tail.prev : DLLNode
				minFreqList.removeNode(minFreqList.tail.prev);
				currSize--;
			}
			// reset min frequency to 1 because of adding new node
			minFrequency = 1;
			DLLNode newNode = new DLLNode(key, value);

			// get the list with frequency 1, and then add new node into the doubly linked
			// list
			// and into LFU cache as well.
			DoublyLinkedList currList = freqMap.getOrDefault(1, new DoublyLinkedList());
			currList.addNode(newNode);
			freqMap.put(1, currList);
			cache.put(key, newNode);
		}
	}

	// Update node while fetching, inserting & updating <key, value>
	private void updateNode(DLLNode currNode) {
		int currFreq = currNode.freq;
		DoublyLinkedList currList = freqMap.get(currFreq);

		currList.removeNode(currNode);
		// if current list is the last list which has lowest frequency & current node is
		// the only node
		// in that list then we need to remove the entire list & increase the min
		// frequency value by 1.
		if (currFreq == minFrequency && currList.listSize == 0) {
			minFrequency++;
		}

		currNode.freq++;
		// add current node to another list has has current frequency + 1.
		// If we don't have the list with this frequency, then initialize it.
		DoublyLinkedList newList = freqMap.getOrDefault(currNode.freq, new DoublyLinkedList());
		newList.addNode(currNode);
		// put newList(entire list) at curr node frequency which acting as key to
		// freqMap.
		freqMap.put(currNode.freq, newList);

	}
}
