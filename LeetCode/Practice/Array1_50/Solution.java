package com.dalai.array1_50;

import java.util.*;

/**
 * @author dalai
 * 
 *         类型：数组
 */
public class Solution {

	// 566 Reshape the Matrix
	public int[][] matrixReshape(int[][] nums, int r, int c) {

		if (nums == null || nums.length == 0)
			return null;
		int r_len = nums.length;
		int c_len = nums[0].length;
		if ((r * c) != (r_len * c_len)) {
			return nums;
		} else {
			int cc = 0, rr = 0;
			int[][] tmp = new int[r][c];
			for (int i = 0; i < r_len; i++)
				for (int j = 0; j < c_len; j++) {
					tmp[rr][cc] = nums[i][j];
					cc++;
					if (cc == c) {
						rr++;
						cc = 0;
					}
				}
			return tmp;
		}
	}

	// 1. Two Sum
	public int[] twoSum(int[] nums, int target) {

		if (nums.length == 0 || nums == null)
			return new int[2];
		int len = nums.length;

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] { i, map.get(target - nums[i]) };
			} else {
				map.put(nums[i], i);
			}
		}

		return new int[2];
	}

	// 219. Contains Duplicate II

	public boolean containsNearbyDuplicate(int[] nums, int k) {

		if (nums.length <= 0 || nums == null)
			return false;
		int len = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			if (map.containsKey(nums[i])) {
				if (k >= Math.abs(i - map.get(nums[i]))) {
					return true;
				} else {
					map.put(nums[i], i);
				}
			} else {
				map.put(nums[i], i);
			}
		}
		return false;
	}

	// 66. Plus One
	public int[] plusOne(int[] digits) {

		if (digits.length <= 0 || digits == null)
			return null;
		int len = digits.length;
		int result = 0;
		boolean flag = false;
		for (int i = len - 1; i >= 0; i--) {
			result = digits[i] + 1;
			if ((i == 0) && (result > 9)) {
				flag = true;
			}
			if (result > 9) {
				digits[i] = result % 10;
			} else {
				digits[i] = result;
				break;
			}
		}
		if (flag) {
			int[] arr = new int[len + 1];
			arr[0] = 1;
			for (int i = 1; i < len + 1; i++) {
				arr[i] = digits[i - 1];
			}
			return arr;
		}
		return digits;
	}

	// 283. Move Zeroes

	public void moveZeroes(int[] nums) {
		/*
		 * int len = nums.length; int zeroCount = 0; for (int i = 0; i < len;
		 * i++) { if (nums[i] == 0) { zeroCount++; } else { if (zeroCount > 0) {
		 * nums[i - zeroCount] = nums[i]; nums[i]=0; } } if (i >= len -
		 * zeroCount) { nums[i] = 0; }
		 */
		int zeroIndex = 0;
		for (int i = 0; i < nums.length; i++)
			if (nums[i] != 0)
				nums[zeroIndex++] = nums[i];

		for (; zeroIndex < nums.length; zeroIndex++)
			nums[zeroIndex] = 0;
	}

	// 532. K-diff Pairs in an Array

	public int findPairs(int[] nums, int k) {

		if (nums == null || nums.length == 0 || k < 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		int count = 0;
		Set<Integer> keys = map.keySet();
		for (int i : keys) {
			if (k == 0) {
				if (map.get(i) > 1) {
					count++;
				}
			} else {
				if (keys.contains(i + k)) {
					count++;
				}
			}
		}
		return count;
	}

	// 26. Remove Duplicates from Sorted Array

	public int removeDuplicates(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != nums[len]) {
				nums[++len] = nums[i];
			}
		}
		return ++len; // 这里++len和len+1有明显慢节奏，++len更快。
	}

	// 27. Remove Element

	public int removeElement(int[] nums, int val) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[index++] = nums[i];
			}
		}
		return index;
	}

	// 448. Find All Numbers Disappeared in an Array

	public List<Integer> findDisappearedNumbers(int[] nums) {

		ArrayList<Integer> arrayList = new ArrayList<>();
		/*
		 * if (nums == null || nums.length == 0) return arrayList; for (int i =
		 * 0; i < nums.length; i++) { int value = Math.abs(nums[i]) - 1; if
		 * (nums[value] > 0) nums[value] = -nums[value]; } for (int j = 0; j <
		 * nums.length; j++) { if (nums[j] > 0) arrayList.add(j + 1); }
		 */
		byte[] bs = new byte[nums.length];
		for (int i = 0; i < nums.length; i++) {
			bs[nums[i] - 1] = 1;
		}
		for (int j = 0; j < nums.length; j++) {
			if (bs[j] != 1)
				arrayList.add(j + 1);
		}

		return arrayList;
	}

	// 485.Max Consecutive Ones

	public int findMaxConsecutiveOnes(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		int maxCount = 0, tmpCount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1 && tmpCount >= 0) {
				tmpCount++;
			} else {
				if (tmpCount > maxCount)
					maxCount = tmpCount;
				tmpCount = 0;
			}
		}

		return maxCount > tmpCount ? maxCount : tmpCount;
	}

	// 35.Search Insert Position

	public int searchInsert(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return -1;
		}
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] == target) {
				return mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	// 121. Best Time to Buy and Sell Stock

	public int maxProfit(int[] prices) {

		if (prices == null || prices.length == 0) {
			return 0;
		}
		int max_profit = 0;
		int min_buy = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (min_buy > prices[i])
				min_buy = prices[i];
			if (prices[i] - min_buy > max_profit)
				max_profit = prices[i] - min_buy;
		}
		return max_profit;
	}

	// 122. Best Time to Buy and Sell Stock II
	public int maxProfit2(int[] prices) {

		if (prices == null || prices.length == 0) {
			return 0;
		}
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit += prices[i] - prices[i - 1];
			}
		}
		return profit;
	}

	// 217. Contains Duplicate
	public boolean containsDuplicate(int[] nums) {

		if (nums == null || nums.length == 0)
			return false;
		// 这个比较慢
		/*
		 * Set<Integer> set=new HashSet<>(); for(int i=0;i<nums.length;i++){
		 * if(set.contains(nums[i])){ return true; }else{ set.add(nums[i]); } }
		 * return false;
		 */
		// 这个快
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				return true;
			}
		}
		return false;
	}

	// 119. Pascal's Triangle II(杨辉三角形)
	public List<Integer> getRow2(int rowIndex) {

		if (rowIndex < 0)
			return null;
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int i = 0; i < rowIndex + 1; i++) {
			arrayList.add(1);
			for (int j = i - 1; j > 0; j--) {
				arrayList.set(j, arrayList.get(j - 1) + arrayList.get(j));
			}
		}
		return arrayList;
	}

	// 118. Pascal's Triangle(杨辉三角形)
	public List<List<Integer>> getRow(int numRows) {

		if (numRows < 0)
			return null;
		ArrayList<List<Integer>> arrayList = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			ArrayList<Integer> arr = new ArrayList<>(i + 1);
			if (i > 0) {
				arr.add(1);
			}
			for (int j = 1; j < i; j++) {
				arr.add(j, arrayList.get(i - 1).get(j - 1) + arrayList.get(i - 1).get(j));
			}
			arr.add(1);
			arrayList.add(arr);
		}
		return arrayList;
	}

	// 414. Third Maximum Number
	public int thirdMax(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;
		Arrays.sort(nums);
		int count = 0, min = 0;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1])
				count++;
			if (count == 2) {
				min = i - 1;
				break;
			}
		}
		if (count == 2)
			return nums[min];
		else
			return nums[nums.length - 1];
	}

	// 561. Array Partition I
	public int arrayPairSum(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0)
				sum += nums[i];
		}
		return sum;
	}

	// 189. Rotate Array
	public void rotate(int[] nums, int k) {

		// int time = k % nums.length;
		// myRotate(nums, time);
		int[] res = new int[nums.length];
		if (k >= nums.length) {
			k = nums.length - k % nums.length;
		} else {
			k = nums.length - k;
		}
		System.arraycopy(nums, 0, res, 0, nums.length);
		System.arraycopy(res, k, nums, 0, nums.length - k);
		System.arraycopy(res, 0, nums, nums.length - k, k);

	}

	private void myRotate(int[] nums, int k) {

		int tmp = 0;
		int len = nums.length;
		for (int i = 0; i < len / 2; i++) {
			tmp = nums[i];
			nums[i] = nums[len - i - 1];
			nums[len - 1 - i] = tmp;
		}
		for (int i = 0; i < k / 2; i++) {
			tmp = nums[i];
			nums[i] = nums[k - 1 - i];
			nums[k - 1 - i] = tmp;
		}
		for (int i = 0; i < (len - k) / 2; i++) {
			tmp = nums[i + k];
			nums[i + k] = nums[len - i - 1];
			nums[len - 1 - i] = tmp;
		}

	}

	// 88. Merge Sorted Array
	public void merge(int[] nums1, int m, int[] nums2, int n) {

		// int i = 0, j = 0, k = 0;
		// int[] mCopy = new int[m];
		// System.arraycopy(nums1, 0, mCopy, 0, m);
		// while (i < m && j < n) {
		// if (mCopy[i] > nums2[j]) {
		// nums1[k++] = nums2[j++];
		// } else {
		// nums1[k++] = mCopy[i++];
		// }
		// }
		// if (n - j <= 0) {
		// System.arraycopy(mCopy, i, nums1, k, mCopy.length - i);
		// } else {
		// System.arraycopy(nums2, j, nums1, k, nums2.length - j);
		// }
		int len = m + n - 1, i = m - 1, j = n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[len] = nums1[i];
				i--;
			} else {
				nums1[len] = nums2[j];
				j--;
			}
			len--;
		}
		while (j >= 0) {
			nums1[j] = nums2[j];
			j--;
		}
	}

	// 169. Majority Element
	public int majorityElement(int[] nums) {

		// int num = nums.length / 2;
		// Map<Integer, Integer> map = new HashMap<>();
		// for (Integer i : nums) {
		// if (map.containsKey(i)) {
		// map.put(i, map.get(i) + 1);
		// } else {
		// map.put(i, 1);
		// }
		// }
		// for (Integer i : nums) {
		// if (map.get(i) > num) {
		// return i;
		// }
		// }
		// return 0;
		int maj = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++) {

			if (maj == nums[i])
				count++;
			else if (count == 0) {
				maj = nums[i];
				count = 1;
			} else {
				count--;
			}

		}
		return maj;
	}

	// 167. Two Sum II - Input array is sorted
	public int[] twoSum2(int[] numbers, int target) {

		// int[] arr=new int[2];
		// Map<Integer, Integer> map=new HashMap<>();
		// for(int i=0;i<numbers.length;i++){
		// if(map.containsKey(target-numbers[i])){
		// arr[0]=map.get(target-numbers[i])+1;
		// arr[1]=i+1;
		// return arr;
		// }else{
		// map.put(numbers[i], i);
		// }
		// }
		//
		// return arr;
		int[] res = new int[2];
		int start = 0;
		int end = numbers.length - 1;

		while (start < end) {
			if (numbers[start] + numbers[end] == target) {
				res[0] = start + 1;
				res[1] = end + 1;
				return res;
			} else if (numbers[start] + numbers[end] < target) {
				start++;
			} else {
				end--;
			}
		}
		return res;
	}

	// 268. Missing Number
	public int missingNumber(int[] nums) {

		byte[] arr = new byte[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			arr[nums[i]] = 1;
		}
		for (int i = 0; i <= nums.length; i++) {
			if (arr[i] != 1)
				return i;
		}

		return 0;
	}

	// 581. Shortest Unsorted Continuous Subarray
	public int findUnsortedSubarray(int[] nums) {

		int len = nums.length, beg = -1, end = -2, min = nums[len - 1], max = nums[0];
		for (int i = 1; i < len; i++) {
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[len - i - 1]);
			if (nums[i] < max)
				end = i;
			if (nums[len - i - 1] > min)
				beg = len - 1 - i;
		}

		return end - beg + 1;

	}

	// 152. Maximum Product Subarray
	public int maxProduct(int[] nums) {

		int len = nums.length;
		int max = nums[0], min = nums[0], result = nums[0];
		for (int i = 1; i < len; i++) {
			int tmp = max;
			max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
			min = Math.min(Math.min(tmp * nums[i], min * nums[i]), nums[i]);
			if (result < max)
				result = max;
		}
		return result;
	}

	// 106. Construct Binary Tree from Inorder and Postorder Traversal
	public TreeNode buildTree(int[] inorder, int[] postorder) {

		if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)
			return null;
		return build(inorder, 0, postorder, 0, postorder.length);

	}

	public TreeNode build(int[] inorder, int inBeg, int[] postorder, int postBeg, int len) {

		if (len == 0)
			return null;
		TreeNode root = new TreeNode(postorder[postBeg + len - 1]);
		int index = 0;
		while (index < len) {
			if (postorder[len + postBeg - 1] == inorder[index + inBeg]) {
				break;
			}
			index++;
		}

		if (index + inBeg > inBeg) {
			root.left = build(inorder, inBeg, postorder, postBeg, index);
		}

		int inRightLen = len - 1 - index;

		if (inRightLen > 0) {
			root.right = build(inorder, index + 1 + inBeg, postorder, index + postBeg, inRightLen);
		}
		return root;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// 90. Subsets II
	public List<List<Integer>> subsetsWithDup(int[] nums) {

		if (nums == null || nums.length == 0) {
			return null;
		}
		Arrays.sort(nums);
		List<List<Integer>> subSets = new ArrayList<>();
		List<Integer> each = new ArrayList<>();
		subSet(0, subSets, each, nums);
		return subSets;
	}

	private void subSet(int n, List<List<Integer>> subSets, List<Integer> each, int[] nums) {

		if (n <= nums.length) {
			subSets.add(each);
		}
		int i = n;
		while (i < nums.length) {
			each.add(nums[i]);
			subSet(i + 1, subSets, new ArrayList<>(each), nums);
			each.remove(each.size() - 1);
			i++;
			while (i < nums.length && nums[i] == nums[i - 1]) {
				i++;
			}
		}
	}

	// 565. Array Nesting
	public int arrayNesting(int[] nums) {

		// 当时测试用例多大，直接栈溢出了
		// if (nums == null || nums.length == 0) {
		// return 0;
		// }
		// List<Integer> numsArrayList = new ArrayList<>();
		// List<Integer> kArr=null;
		// for (int i = 0, len = nums.length; i < len; i++) {
		// kArr = new ArrayList<>();
		// kArr.add(nums[i]);
		// arrayNest(nums, nums[i], kArr);
		// numsArrayList.add(kArr.size());
		// }
		// return Collections.max(numsArrayList);
		// }
		//
		// private void arrayNest(int[] nums, int n, List<Integer> kArr) {
		// if (n >= 0 && n < nums.length) {
		// if (kArr.contains(nums[n])) {
		// return ;
		// }
		// kArr.add(nums[n]);
		// arrayNest(nums, nums[n], kArr);
		// }
		// return;
		int max = Integer.MIN_VALUE;
		byte[] visited = new byte[nums.length];
		for (int i = 0, len = nums.length; i < len; i++) {
			if (visited[i] != 1) {
				max = Math.max(max, calculateLen(nums, i, visited));
			}
		}
		return max;
	}

	private int calculateLen(int[] nums, int s, byte[] visited) {

		int i = s, count = 0;
		while (count == 0 || i != s) {
			visited[i] = 1;
			i = nums[i];
			count++;
		}
		return count;
	}

	// 560. Subarray Sum Equals K
	public int subarraySum(int[] nums, int k) {
		// 运行时间好慢，时间复杂度接近O(n^2)
		// if (nums == null || nums.length == 0) {
		// return 0;
		// }
		// int sum = 0,tmp=k;
		// for (int i = 0, len = nums.length; i < len; i++) {
		// k=tmp;
		// for (int j = i; j < len; j++) {
		// k -= nums[j];
		// if (k == 0) {
		// sum++;
		// }
		// }
		// }
		// return sum;
		if (nums == null || nums.length == 0 || nums.length > 20000) {
			return 0;
		}

		if (k >= 1e7 && k <= -1e7) {
			return 0;
		}

		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);
		int sum = 0, sol = 0;
		for (int i : nums) {
			sum += i;
			int pre = sum - k;
			if (preSum.containsKey(pre)) {
				sol += preSum.get(pre);
			}
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}
		return sol;
	}

	// 495. Teemo Attacking
	public int findPoisonedDuration(int[] timeSeries, int duration) {

		if (timeSeries == null || timeSeries.length == 0)
			return 0;
		if (duration <= 0)
			return 0;
		int sum = 0;
		for (int i = 0, len = timeSeries.length - 1; i < len; i++) {
			if (timeSeries[i] + duration <= timeSeries[i + 1]) {
				sum += duration;
			} else {
				sum += timeSeries[i + 1] - timeSeries[i];
			}
		}
		sum += duration;
		return sum;
	}

	// 33. Search in Rotated Sorted Array
	public int search(int[] nums, int target) {

		if (nums == null || nums.length == 0)
			return -1;
		int maxNumIndex = nums.length - 1;
		for (int i = 0, len = nums.length - 1; i < len; i++) {
			if (nums[i] > nums[i + 1]) {
				maxNumIndex = i;
				break;
			}
		}
		int left = 0, right = nums.length - 1;
		if (target >= nums[left]) {
			right = maxNumIndex;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (nums[mid] == target) {
					return mid;
				} else if (nums[mid] > target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		} else {
			left = maxNumIndex + 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (nums[mid] == target) {
					return mid;
				} else if (nums[mid] > target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return -1;
	}

	// 81. Search in Rotated Sorted Array II
	public boolean search2(int[] nums, int target) {

		if (nums == null || nums.length == 0)
			return false;
		int maxNumIndex = nums.length - 1;
		for (int i = 0, len = nums.length - 1; i < len; i++) {
			if (nums[i] > nums[i + 1]) {
				maxNumIndex = i;
				break;
			}
		}
		int left = 0, right = nums.length - 1;
		if (target >= nums[left]) {
			right = maxNumIndex;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (nums[mid] == target) {
					return true;
				} else if (nums[mid] > target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		} else {
			left = maxNumIndex + 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (nums[mid] == target) {
					return true;
				} else if (nums[mid] > target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return false;
	}

	// 80. Remove Duplicates from Sorted Array II
	public int removeDuplicates2(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		int index = 0, count = 0;
		for (int len = nums.length, i = 1; i < len; i++) {
			if (nums[index] != nums[i]) {
				nums[++index] = nums[i];
				if (count > 0) {
					count = 0;
				}
			} else if (nums[index] == nums[i] && count == 0) {
				count++;
				nums[++index] = nums[i];
			} else
				;
		}
		return ++index;
	}

	// 79. Word Search
	public boolean exist(char[][] board, String word) {

		if (board == null || board.length == 0) {
			return false;
		}
		if (word == null || word.length() == 0)
			return false;
		for (int i = 0, rowlen = board.length; i < rowlen; i++) {
			for (int j = 0, collen = board[i].length; j < collen; j++) {
				if (exist(board, i, j, word, 0))
					return true;
			}
		}
		return false;
	}

	private boolean exist(char[][] board, int i, int j, String word, int start) {

		if (start >= word.length())
			return true;
		if (i < 0 || i >= board.length || j < 0 || j >= board[i].length)
			return false;
		if (board[i][j] == word.charAt(start++)) {
			char c = board[i][j];
			board[i][j] = '#';
			boolean res = exist(board, i + 1, j, word, start) || exist(board, i, j + 1, word, start)
					|| exist(board, i - 1, j, word, start) || exist(board, i, j - 1, word, start);
			board[i][j] = c;
			return res;
		}
		return false;
	}

	// 78. Subsets
	public List<List<Integer>> subsets(int[] nums) {

		if (nums == null || nums.length == 0)
			return null;
		List<List<Integer>> subSets = new ArrayList<>();
		List<Integer> each = new ArrayList<>();
		subset(0, subSets, each, nums);
		return subSets;
	}

	private void subset(int n, List<List<Integer>> subSets, List<Integer> each, int[] nums) {

		if (n <= nums.length) {
			subSets.add(each);
		}
		for (int i = n, len = nums.length; i < len; i++) {
			each.add(nums[i]);
			subset(++n, subSets, new ArrayList<>(each), nums);
			each.remove(each.size() - 1);
		}
	}

	// 75. Sort Colors
	public void sortColors(int[] nums) {

		if (nums == null || nums.length == 0)
			return;
		int j = 0;
		for (int i = 1, len = nums.length; i < len; i++) {
			int tmp = nums[i];
			for (j = i; j > 0 && tmp < nums[j - 1]; j--) {
				nums[j] = nums[j - 1];
			}
			nums[j] = tmp;
		}
	}

	// 74. Search a 2D Matrix
	public boolean searchMatrix(int[][] matrix, int target) {

		if (matrix == null || matrix.length == 0)
			return false;
		for (int i = 0, rowlen = matrix.length; i < rowlen; i++) {
			if (matrix[i].length == 0)
				return false;
			int collen = matrix[i].length;
			if (matrix[i][collen - 1] >= target) {
				for (int j = 0; j < collen; j++) {
					if (matrix[i][j] == target)
						return true;
				}
				return false;
			}
		}
		return false;
	}

	// 73. Set Matrix Zeroes
	public void setZeroes(int[][] matrix) {

		if (matrix == null || matrix.length == 0)
			return;
		ArrayList<Integer> rowList = new ArrayList<>();
		ArrayList<Integer> colList = new ArrayList<>();
		for (int i = 0, row = matrix.length; i < row; i++)
			for (int j = 0, col = matrix[i].length; j < col; j++) {
				if (matrix[i][j] == 0) {
					rowList.add(i);
					colList.add(j);
				}
			}
		for (int i = 0, len = rowList.size(); i < len; i++) {
			setZeroesRowCol(matrix, rowList.get(i), colList.get(i));
		}
	}

	private void setZeroesRowCol(int[][] matrix, int x, int y) {
		for (int i = 0, row = matrix.length; i < row; i++) {
			if (matrix[i][y] != 0) {
				matrix[i][y] = 0;
			}
		}
		for (int i = 0, col = matrix[x].length; i < col; i++) {
			if (matrix[x][i] != 0) {
				matrix[x][i] = 0;
			}
		}
	}

	// 64. Minimum Path Sum
	public int minPathSum(int[][] grid) {

		if (grid == null || grid.length == 0)
			return 0;
		int row = grid.length;
		int col = grid[0].length;
		int[][] sum = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				if (i == 0 && j == 0) {
					sum[i][j] = sum[i][j];
				} else if (i == 0 && j != 0) {
					sum[i][j] = sum[i][j - 1] + grid[i][j];
				} else if (i != 0 && j == 0) {
					sum[i][j] = sum[i - 1][j] + grid[i][j];
				} else {
					sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
				}
			}
		}
		return sum[row - 1][col - 1];
	}

	// 62. Unique Paths
	public int uniquePaths(int m, int n) {

		if (m <= 0 || n <= 0)
			return 0;
		int[][] pathNum = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (i == 0 && j == 0) {
					pathNum[i][j] = 1;
				} else if (i == 0 && j != 0) {
					pathNum[i][j] = pathNum[i][j - 1];
				} else if (i != 0 && j == 0) {
					pathNum[i][j] = pathNum[i - 1][j];
				} else {
					pathNum[i][j] = pathNum[i - 1][j] + pathNum[i][j - 1];
				}
			}
		}

		return pathNum[m - 1][n - 1];
	}

	// 63. Unique Paths II
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		if (obstacleGrid == null || obstacleGrid.length == 0)
			return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] pathNum = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (obstacleGrid[i][j] == 1) {
					pathNum[i][j] = 0;
				} else if (i == 0 && j == 0) {
					pathNum[i][j] = 1;
				} else if (i == 0 && j != 0) {
					pathNum[i][j] = pathNum[i][j - 1];
				} else if (i != 0 && j == 0) {
					pathNum[i][j] = pathNum[i - 1][j];
				} else {
					pathNum[i][j] = pathNum[i - 1][j] + pathNum[i][j - 1];
				}
			}
		}
		return pathNum[m - 1][n - 1];
	}

	// 54. Spiral Matrix
	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return new ArrayList<>();
		int start = 0, rows = matrix[0].length, cols = matrix.length;
		ArrayList<Integer> matrixList = new ArrayList<>();
		while (rows > start * 2 && cols > start * 2) {
			printMatrixCircle(matrix, start, matrixList);
			start++;
		}
		return matrixList;
	}

	private void printMatrixCircle(int[][] matrix, int start, ArrayList<Integer> matrixList) {
		int endX = matrix[0].length - start - 1;
		int endY = matrix.length - start - 1;
		// 从左到右
		for (int i = start; i <= endX; i++) {
			matrixList.add(matrix[start][i]);
		}
		// 从上到下
		if (start < endY) {
			for (int i = start + 1; i <= endY; i++) {
				matrixList.add(matrix[i][endX]);
			}
		}
		// right to left
		if (start < endX && start < endY) {
			for (int i = endX - 1; i >= start; i--) {
				matrixList.add(matrix[endY][i]);
			}
		}
		// down to up
		if (start < endX && start < endY - 1) {
			for (int i = endY - 1; i >= start + 1; i--) {
				matrixList.add(matrix[i][start]);
			}
		}
	}

	// 59. Spiral Matrix II
	public int[][] generateMatrix(int n) {

		if (n <= 0)
			return null;
		int start = 0;
		int[][] matrix = new int[n][n];
		while (n > start * 2) {

			matrixCircle(matrix, start);
			start++;
		}
		return matrix;
	}

	private int number = 1;

	private void matrixCircle(int[][] matrix, int start) {
		int endX = 0, endY = 0;
		endX = endY = matrix.length - start - 1;

		// 从左到右
		for (int i = start; i <= endX; i++) {
			matrix[start][i] = number++;
		}
		// 从上到下
		if (start < endY) {
			for (int i = start + 1; i <= endY; i++) {
				matrix[i][endX] = number++;
			}
		}
		// right to left
		if (start < endX && start < endY) {
			for (int i = endX - 1; i >= start; i--) {
				matrix[endY][i] = number++;
			}
		}
		// down to up
		if (start < endX && start < endY - 1) {
			for (int i = endY - 1; i >= start + 1; i--) {
				matrix[i][start] = number++;
			}
		}
	}

	public static void main(String[] args) {

		Solution solution = new Solution();

		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] arr2 = solution.generateMatrix(3);
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++)
				System.out.print(arr2[i][j]);
			System.out.println();
		}
		/*
		 * i = i+1会将1压入栈顶，然后调用iadd将栈顶两个整数相加， 整个过程有4个指令。
		 * i++则有一个单独的指令iinc来直接加减指定数值，相同操作还有i--,i+=1
		 */

	}
}
