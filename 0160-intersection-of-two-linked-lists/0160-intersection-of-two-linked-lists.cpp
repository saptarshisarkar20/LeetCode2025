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
    ListNode *getIntersectionNode(ListNode *hA, ListNode *hB) {
        int l1=0, l2=0;
        ListNode* h1 = hA;
        ListNode* h2 = hB;

        while(h1){
            l1++;
            h1=h1->next;
        }

        while(h2){
            l2++;
            h2=h2->next;
        }

        h1 = hA;
        h2 = hB;

        if(l1>l2){
            int x = l1-l2;
            while(x--){
                h1=h1->next;
            }
        }
        else{
            int x = l2-l1;
            while(x--){
                h2=h2->next;
            }
        }

        while(h1 && h2){
            if(h1 == h2) return h1;

            h1=h1->next;
            h2=h2->next;
        }
        return h1;

    }
};