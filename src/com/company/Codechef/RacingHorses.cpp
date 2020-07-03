#include <bits/stdc++.h>
using namespace std;

#define ll long long


int main(){
	int t;
	cin>>t;
	while(t--){
		int n;
		cin>>n;
		vector<ll> a(n);
		for(ll &x :a){
			cin>>x;
			}
		for(int i=0;i<n;i++){
			cout<<a[i]<<" ";
			}
		sort(a.begin(),a.end());
		int min = INT_MAX;
		for(int i=1;i<n;i++){
			if(a[i]-a[i-1] < min){
				min = a[i]-a[i-1];
				}
			}
		cout<<min<<endl;
		}
	return 0;	
	}
