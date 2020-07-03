#include <bits/stdc++.h>
using namespace std;
#define mx 100
int solution(vector<int> a,int n){
	int min=0;
		for(int i=0;i<n;i++){
			int r = (i%2);
			int s = (a[i]%2);
			if(r != s){
				for(int j=i+1;j<n;j++){
					if(j%2 !=r && a[j]%2==r ){
						min++;
						int temp = a[i];
						a[i] = a[j];
						a[j] = temp;
					}
				}
			}
			if(r!=(a[i]%2)){
				return -1;
				}
		}
	return min;
	}
int main(){
	int t;
	cin>> t;
	while(t--){
		int n;
		cin>>n;
		vector<int> a(n);
		for(int &x : a){
			cin>>x;
			}
		int res = solution(a,n);
		cout<<res<<endl;
	}
		return 0;
	}
