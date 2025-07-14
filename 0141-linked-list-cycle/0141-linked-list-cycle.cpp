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
    bool hasCycle(ListNode* head) {

        ListNode* s = head;
        ListNode* f = head;
        bool flag = false;

        while (f && f->next && f->next->next ){
            s = s->next;
            f = f->next->next;
            if (s == f) {
                flag = true;
                break;
            }
        } 

        return flag;
    }
};