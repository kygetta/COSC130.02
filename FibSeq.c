#include <stdio.h>
//Kylie Hall and Brittany Miranda

int main(){
int num;
int Fib;

printf("Enter an integer");
scanf("%d",&num);

Fib = Out(num);
printf("%d" , Fib);

}

int Out(int num){
if (num == 0){
return 0;
}
else if (num == 1){
return 1;
}
else{
return(Out(num-1) + Out(num-2));

}
}
