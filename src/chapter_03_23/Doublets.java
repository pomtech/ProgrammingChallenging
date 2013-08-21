package chapter_03_23;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class Doublets {

	public static class Node {

		public String data;
		public ArrayList<Node> children = new ArrayList<Node>();
		public Node(String data) {
			this.data = data;
		}

		public boolean isNext(String target) {
			if (target.length() != data.length()) {
				return false;
			}

			int count = 0;
			int[] hash = new int[128];
			char[] dataCharArr = data.toCharArray();
			char[] targetCharArr = target.toCharArray();
			for (int i = 0; i < dataCharArr.length; ++i) {
				hash[dataCharArr[i]]++;
			}
			for (int i = 0; i < targetCharArr.length; ++i) {
				hash[targetCharArr[i]]--;
			}
			int diffCounter = 0;

			for (int i = 0; i < hash.length; ++i) {
				if (hash[i] != 0) {
					diffCounter++;
				}
			}
			if (diffCounter == 2) {
				return true;
			} else {
				return false;
			}
		}

		public boolean find(Node target, LinkedHashMap<String, Boolean> hash) {
			ArrayList<Node> children = this.children;
			for (int i = 0; i < children.size(); ++i) {
				String compare = children.get(i).data;
				if (target.data.equals(compare)) {
					System.out.println("find! " + compare);
					Set<String> keys = hash.keySet();
					Iterator<String> iter = keys.iterator();
					while (iter.hasNext()) {
						String next = iter.next();
						System.out.println(next);
					}
					return true;
				} else {
					if (!hash.containsKey(compare)) {
						System.out.println(target.data + " vs." + compare);
						LinkedHashMap<String, Boolean> newHash = new LinkedHashMap<String, Boolean>(hash);
						newHash.put(compare, true);
						boolean ret = children.get(i).find(target, newHash);
						if (ret == true)
							return true;
					}
				}
			}
			return false;
		}
	}

	public Doublets() {

	}

	public static void main(String[] args) {

		System.out.println("main");
		ArrayList<Node> root = new ArrayList<Node>();
		String[] input = { "booster", "rooster", "roaster", "coaster","roasted", "coastal", "postal" };
		for (int i = 0; i < input.length; ++i) {
			root.add(new Node(input[i]));
		}
		for (int i = 0; i < root.size(); ++i) {
			for (int j = 0; j < root.size(); ++j) {
				if (i != j) {
					String compareTarget = root.get(j).data;
					if (root.get(i).isNext(compareTarget)) {
						root.get(i).children.add(root.get(j));
					}
					// target 와 compareTarget 비교해 글자가 한개만 다르면 target child로
				}
			}
		}
		// booster
		LinkedHashMap<String, Boolean> hash = new LinkedHashMap<String, Boolean>();
		hash.put(root.get(0).data, true);
		root.get(0).find(root.get(3), hash);
	}

}
