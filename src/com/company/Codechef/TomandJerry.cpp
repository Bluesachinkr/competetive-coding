#include <bits/stdc++.h>
using namespace std;
#define lli unsigned long long int

lli p(lli a){
        lli  p = 2;
        while (a%p == 0){
            p = p*2;
        }
        return p;
    }
lli solution(lli ts){
	lli res = 0;
		 if (ts % 2 == 0) {
            lli start = p(ts)/2;
            res = ts/start;
            res/=2;
        } else {
            return ts / 2;
        }
        return res;
	}
int main()
{
	int t;
	cin>>t;
	while(t-- >0){
		lli n;
		cin>>n;
		lli res = solution(n);
		cout<<res<<endl;
	}
	return 0;   
}
