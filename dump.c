//Date:12/05/21
//Creators: Kylie Hall, Brittany Miranda

//Objective: Create a function that will dump the number of bytes
//indicated starting at the address specified

/*
What does this tell you about how local varaibales are stored?
	It tells me that local variables are in a stack that grows as we
	loop through local variables to find the number of bytes. In other
	words, we are pushing new local variables on to the stack!

What do the values mean?
	Clearly, the first print line si the address of the local variable. 
	The following 8 bytes will be the bytes stores at the following
	locations. This can also be understood as each byte storing one 
	character value in hexadecimal values.
	Finally these values are just represented in ASCII.
	They overall are  the values stored at a the starter location.
*/
#include <stdio.h>

void dump(char* start, int bytes){

//outer loop goes through start 8 bytes at a time until it reaches byte max
for(int i=0; i<bytes; i=i+8){
//prints address every 8 bytes
printf("%p", &start[i]);

//inner loop goes through 8 times for the 8 bytes and printes the hexadecimal
//value for each byte
for(int j = 0; j<8; j++){
printf("%02hhX", start[i+j]);
printf(" ");
}

//the second inner loop goes through 8 times for the 8 bytes and prints the 
//ASCII value if it is printable
for(int j = 0; j<8; j++){
char characterValue = '.';

//the printable ASCII value startes at 32 and ends at 126
if(start[i+j]>=32 && start[i+j] <= 126){
characterValue = start[i+j];
}

printf("%c", characterValue);
}
printf("\n");

}
}

//MAIN METHOD INCLUDES FIB(n) CODE AND CALL TO THE DUMP METHOD
int main(){
int n;
int call;

printf("Enter an integer ");
scanf("%d", &n);

int Fib[n+2];//initialize array

Fib[0] = 0;
Fib[1] = 1;

//If Fib[n] doesn't equal 0 or 1 then find value below and return value.
for(int i=2;i<=n;i++){
Fib[i] = Fib[i-1] + Fib[i-2];
}

printf("%d\n",Fib[n]);

//calls for dump method.
dump((char*)Fib,100);
return Fib[n];
}
