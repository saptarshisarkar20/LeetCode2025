/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* detectCycle(ListNode* head) {
        int x = INT_MIN;

        // int pos = -1
        ListNode* h = head;

        while (h) {
            if (h->val == x)
                return h;
            h->val = x;
            h = h->next;
        }
        return h;
    }
};