#include <bits/stdc++.h>
using namespace std;

#define ll long long
void solution(ll I,ll n,ll q){
	if(I == 1){
		if(q == 1){
			cout<<(n/2)<<endl;
			}else{
				cout<<((n/2)+1)<<endl;
				}
		}else{
			if(q==1){
				cout<<((n/2)+1)<<endl;
				}else{
					cout<<(n/2)<<endl;
					}
			}
	}
int main(){
	int t;
	cin>>t;
	while(t--){
		ll g;
		cin>>g;
		while(g--){
			ll I,n,q;
			cin>>I>>n>>q;
			solution(I,n,q);
			}
		}
	return 0;
	}
