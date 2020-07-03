#include<bits/stdc++.h>
using namespace std;

#define ll long long

ll fact(ll n){
	int res= 0;
	while(n >=5){
		res+= (n/5);
		n/=5;
	}
	return res;
}
int main(){
	int t;
	cin>> t;
	while(t--){
		ll n;
		cin >> n;
		int res = fact(n);
		cout<< res <<endl;
		}
	return 0;	
	}
