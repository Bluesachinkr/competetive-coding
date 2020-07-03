#include <bits/stdc++.h>
using namespace std;

#define ll long long

int binarySearch(vector<ll> a,int element,int n){
	int low = 0;
	int high = n-1;
	while(low <= high){
		int mid = low+((high-low)/2);
		if(a[mid] == element){
			return mid;
			}else if(a[mid] > element){
				high = mid-1;
				}else{
					low = mid+1;
					}
		}
	return -1;
	}
int main(){
	int t;
	cin>> t;
	while(t--){
		int n;
		cin>>n;
		vector<ll> a(n);
		for(ll &x : a){
			cin>> x;
			}
		int k;
		cin>>k;
		ll element = a[k-1];
		sort(a.begin(),a.end());
		int pos = binarySearch(a,element,n);
		cout << (pos+1) << endl;		
		}
	return 0;
	}
