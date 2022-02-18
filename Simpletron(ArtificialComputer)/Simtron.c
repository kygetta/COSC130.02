#include <stdio.h>

//Creators: Kylie Hall and Brittany Miranda
//Date Created:10/20/21

//Code Description: Let’s create a computer called the Simpletron. As its name implies,
// it’s a simple but powerful machine.
// The Simpletron runs programs written in the only language
// it directly understands: Simpletron Machine Language (SML).

#define MEMSIZE 100

#define READ   10
#define WRITE  11

#define LOAD  20
#define STORE 21

#define ADD      30
#define SUBTRACT 31
#define DIVIDE   32
#define MULTIPLY 33

#define BRANCH     40
#define BRANCHNEG  41
#define BRANCHZERO 42
#define HALT       43

//initialization of dump method
void dump(int accumulator, int instructionCounter, int memory[], int operand, int operationCode);

int main(){
int memory[100];
int i;
int instructionCounter = 0;
int operationCode = 0;
int operand = 0; //rightmost 2 digits
int accumulator = 0;

//Introductory message
printf(" *** Welcome to Simpletron! ***");
printf("  *** Please enter your program one instruction   ***");
printf("*** (or data word) at a time.  I will display   ***");
printf("*** the location number and a question mark (?) ***");
printf("*** You then type the word for that location.   ***");
printf("*** Type -99999 to stop entering your program.  ***");

//below will add each user input "word" into the memory array.
int opcode=0;
for(i=0;i<100;i++){
printf("%d\t", i);
printf("?\t");
scanf("%d", &opcode);
//makes sure the user input is within the range needed. If not then it will call for dump method 
if(opcode<-9999 || opcode>9999){
printf("*** Attempt to divide by zero *** *** Simpletron execution abnormally terminated ***");
dump(accumulator, instructionCounter, memory, operand, operationCode);
}else{ 
opcode = memory[i];//stores into int memory[]
}

//Terminates  loop
if(opcode  == -99999){
memory[i] = 0;
i = 100;
}//end if
}//end for 

printf("*** Program loading completed ***\n"
	  "*** Program execution begins  ***\n");


//Below, the code will loop through memory[] and uses the "words" the user entered to now 
//execute the commands.
for(instructionCounter=0;instructionCounter<100;instructionCounter++){
accumulator = memory[instructionCounter];

operationCode = memory[instructionCounter]/100;//finds first 2 digits
operand = memory[instructionCounter]%100;//finds last 2 digits


//USE OF SWITCH STATEMENTS
switch(operationCode){
case READ:
printf("Enter an integer: ");
scanf("%d", &memory[operand]);
break;

case WRITE:
printf("\nMemory location: %.2d\nWord: %d\nASCII: %c\n",
operand, memory[operand], memory[operand]);
break;

case LOAD:
accumulator = memory[operand];
break;

case STORE:
memory[operand] = accumulator;
break;

case ADD:
accumulator += memory[operand];
break;

case SUBTRACT:
accumulator -= memory[operand];
break;

case DIVIDE:
accumulator /= memory[operand];
break;

case MULTIPLY:
accumulator *= memory[operand];
break;

case BRANCH:
i = operand;
break;

case BRANCHNEG:
if(accumulator < 0)
i = operand;
break;

case BRANCHZERO:
if(!accumulator)
i = operand;
break;

case HALT:
printf("*** Simpletron execution terminated ***\n");
dump(accumulator, instructionCounter, memory, operand, operationCode);
return 0;
break;

      }
//USE SWITCH NOT IF STATEMENTS
/*
if(operationCode == READ){
printf("Enter an integer");
scanf("%d", &memory[operand]);
break;
}

if(operationCode == WRITE){
printf("\n Memory index: %d", operand);
printf("\n Word: %d", memory[operand]);
break; 
}

if(operationCode == LOAD){
accumulator = memory[operand];
break;
}

if(operationCode == STORE){
memory[operand] = accumulator;
break;
}

if(operationCode == ADD){
accumulator += memory[operand];
break;
}

if(operationCode == SUBTRACT){
accumulator -= memory[operand];
break;
}

if(operationCode == DIVIDE){
accumulator /= memory[operand];
break;
}

if(operationCode == MULTIPLY){
accumulator *= memory[operand];
break;
}

if(operationCode == BRANCH){
if(accumulator == 0){//exception
instructionCounter = operand;
}
break;
}

if(operationCode == BRANCHNEG && accumulator<0){
instructionCounter = operand;
break;
}

if(operationCode == BRANCHZERO){
instructionCounter = operand;
break;
}
if(operationCode == HALT){
printf(" *** Simpletron execution terminated ***");
dump(accumulator, instructionCounter, memory, operand, operationCode);//calls dump method
break;
}
*/
}//end for loop


dump(accumulator, instructionCounter, memory, operand, operationCode);//calls dump method

return 0;
}


//method dump description: This method will
void dump(int accumulator, int instructionCounter, int memory[], int operand, int operationCode){
int i;
int j;
int instructionRegister;

printf("\n REGISTERS: \n");

//attempt to make each element in table 4 digits...
accumulator = accumulator/100;
instructionCounter = instructionCounter/100;
instructionRegister = instructionRegister/100;
operationCode = operationCode/100;
operand = operand/100;

//Below this will print out each  value
printf("\n accumulator \t %d", accumulator);
printf("\n instructionCounter \t %d", instructionCounter);
printf("\n instructionRegister \t %d", instructionRegister);
printf("\n operationCode \t %d", operationCode);
printf("\n operand \t %d", operand);


printf("\n MEMORY: \n ");
printf("%3c", ' '); //%_ determines width separation to create spaces in table
for(i = 0; i < 10; i++)//This will print the top row index values.
printf("%5d", i);
printf("\n");

for(i = 0; i < 100; i += 10) {
printf("%.2d", i);//prints left hand side of memory table

for(j = i; j < i+10; j++) {
printf(" %c%.4d",  memory[j] < 0 ? '-' : '+', memory[j] < 0 ? -memory[j] : memory[j]);//prints out each varable in memory

}//end for
printf("\n");
}//end for
}//end method
