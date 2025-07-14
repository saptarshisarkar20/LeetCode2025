/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    int getDecimalValue(ListNode* head) {
        int depth = 0;
        ListNode* h = head;

        while (h) {
            depth++;
            h = h->next;
        }

        h = head;

        int ans = 0;
        while (h) {
            ans += ((h->val) << (--depth));
            h = h->next;
        }
        return ans;
    }
};