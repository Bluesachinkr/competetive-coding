#include <bits/stdc++.h>
using namespace std;

#define ll long long


int main(){
	ll a,b;
	cin>>a>>b;
	ll dif = a -b;
	int r = dif%10;
	if(r==0){
		r = 1;
	}else if(r==1){
		r = 2;
	}else{
		r = 1;
	}
	dif/=10;
	dif = (dif*10)+r;
	cout<<dif<<endl;
	return 0;	
	}
